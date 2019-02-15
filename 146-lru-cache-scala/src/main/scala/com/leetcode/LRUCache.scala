package com.leetcode

  import scala.collection.mutable

  class LRUCache(capacity: Int) {
    private val DefaultValue = -1

    private var head: Node = _
    private var end: Node = _
    private val nodes: mutable.Map[Int, Node] = mutable.Map.empty[Int, Node]

    def get(key: Int): Int = nodes.get(key) match {
      case Some(node) =>
        remove(node)
        setHead(node)
        node.value
      case _ => DefaultValue
    }

    def put(key: Int, value: Int): Unit = {
      val existNodeOption = nodes.get(key)

      if (existNodeOption.isDefined) {
        val node = existNodeOption.get
        remove(node)
        nodes.remove(key)
        node.value = value
        nodes.put(key, node)
        setHead(node)
      }
      else {
        if (nodes.size == capacity) {
          nodes.remove(end.key)
          remove(end)
        }
        val node = Node(key, value, null, null)
        nodes.put(key, node)
        setHead(node)
      }
    }

    private def setHead(node: Node): Unit = {
      if (head == null && end == null) {
        end = node
        head = node
      }
      else {
        node.prev = head
        head.next = node
        head = node
      }
    }

    private def remove(node: Node): Unit = {
      if (node.eq(end) && node.eq(head)) {
        end = null
        head = null
      }
      else if (node.eq(end)) {
        end = node.next
        end.prev = null
      }
      else if (node.eq(head)) {
        head = node.prev
        head.next = null
      }
      else {
        node.prev.next = node.next
        node.next.prev = node.prev
      }

      node.next = null
      node.prev = null
    }

    private case class Node(key: Int, var value: Int, var next: Node, var prev: Node)

  }
