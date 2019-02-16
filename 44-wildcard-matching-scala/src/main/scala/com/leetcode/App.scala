package com.leetcode

object App {
  def main(args: Array[String]): Unit = {
    List(
      ("mississippi", "m??*ss*?i*pi"),
      ("abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb",
        "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb"),
      ("ho", "ho**"),
      ("", "*"),
      ("aa", "a"),
      ("aaa", "aa?"),
      ("aaab", "*b")
    ).foreach { case (s, p) => println(s"isMatch('$s','$p') = ${Solution.isMatch(s, p)}") }
  }
}
