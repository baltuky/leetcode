package com.leetcode

import java.util.UUID

import scala.collection.mutable

trait Rex

case class Literal(c: Char) extends Rex

case class Repeat(regEx: Rex) extends Rex

object Rex {
  private val Epsilon: Char = '*'

  def isMatch(s: String, p: String): Boolean = eval(toNFA(parse(p)), s)

  private def eval(state: State, input: String): Boolean = eval(Set(state), input)

  private def parse(s: String): List[Rex] = s.foldLeft(List[Rex]()) { case (acc, c) => c match {
    case Epsilon => Repeat(acc.head) :: acc.tail
    case _ => Literal(c) :: acc
  }
  }.reverse

  private def toNFA(regExes: List[Rex]): State = if (regExes.isEmpty) Match else toNFA(regExes.head, toNFA(regExes.tail))

  private def toNFA(regEx: Rex, andThen: State): State = regEx match {
    case Literal(c) => Consume(c, andThen)
    case Repeat(r) =>
      val placeholder = Placeholder(null, UUID.randomUUID().toString)
      val split = Split(toNFA(r, placeholder), andThen)
      placeholder.pointingTo = split
      placeholder
  }

  private def eval(nfas: Set[State], input: String): Boolean =
    if (input.isEmpty) eval(nfas, None).contains(Match)
    else eval(eval(nfas, input.headOption), input.tail)

  private def eval(nfas: Set[State], input: Option[Char]): Set[State] = {
    val visited = mutable.Set[State]()
    nfas.flatMap(eval(_, input, visited))
  }

  private def eval(s: State, input: Option[Char], visited: mutable.Set[State]): Set[State] = {
    if (visited.contains(s)) Set()
    else {
      visited.add(s)
      s match {
        case Consume(c, out) => if (input.isDefined && (input.contains(c) || c == '.')) Set(out) else Set()
        case Placeholder(out, _) => eval(out, input, visited)
        case Split(out1, out2) => eval(out1, input, visited) ++ eval(out2, input, visited)
        case Match => if (input.isDefined) Set() else Set(Match)
      }
    }
  }
}

//----------------------------------------------------------------------------------------------------------------------
//----------------------------------------------------------------------------------------------------------------------

trait State

case class Consume(c: Char, out: State) extends State

object Match extends State

case class Split(out1: State, out2: State) extends State

case class Placeholder(var pointingTo: State, id: String) extends State {
  override def equals(obj: Any): Boolean = obj match {
    case Placeholder(_, identifier) => id == identifier
    case _ => false
  }

  override def hashCode(): Int = id.hashCode
}

object Solution {
  private val AnyCharacter = '.'
  private val EpsilonCharacter = '*'

  private val TrueAnswer = "t"
  private val FalseAnswer = "f"

  def isMatch(text: String, pattern: String): Boolean = {
    if (pattern.isEmpty) text.isEmpty
    else {
      val firstMatch = text.nonEmpty && (text.head == pattern.head || pattern.head == AnyCharacter)

      if (pattern.length > 1 && pattern.charAt(1) == EpsilonCharacter)
        isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern))
      else
        firstMatch && isMatch(text.substring(1), pattern.substring(1))
    }
  }

  def isMatchWithMemo(text: String, pattern: String): Boolean =
    isMatchWithMemo(Array.ofDim[String](text.length + 1, pattern.length + 1), 0, 0, text, pattern)

  private def isMatchWithMemo(memo: Array[Array[String]], i: Int, j: Int, text: String, pattern: String): Boolean = {
    if (memo(i)(j) != null) memo(i)(j) == TrueAnswer
    else {
      val answer: Boolean =
        if (j == pattern.length) i == text.length
        else {
          val firstMatch = (i < text.length) && (text(i) == pattern(j) || pattern(j) == AnyCharacter)

          if (j + 1 < pattern.length && pattern(j + 1) == EpsilonCharacter)
            isMatchWithMemo(memo, i, j + 2, text, pattern) || (firstMatch && isMatchWithMemo(memo, i + 1, j, text, pattern))
          else
            firstMatch && isMatchWithMemo(memo, i + 1, j + 1, text, pattern)
        }

      memo(i)(j) = if (answer) TrueAnswer else FalseAnswer
      answer
    }
  }
}