package com.jackbeasley.enigma.test

import com.jackbeasley.enigma.Parsers

class ParseresSpec extends UnitSpec {
  "a Rotor settings parser" should "parse rotor settings" in {
    val input = "(1:2)(2:23)(3:12)"
    val data = Parsers.parseRotorSettings(input)
    data(0)._1 should be (1)
    data(0)._2 should be (2)
    data(1)._1 should be (2)
    data(1)._2 should be (23)
    data(2)._1 should be (3)
    data(2)._2 should be (12)
  }

  "a Plugboard settings parser" should "parse plugboard settings" in {
    val input = "(a:b)(G:D)(Y:K)"
    val data = Parsers.parsePlugboardSettings(input)
    data(0)._1 should be ('A')
    data(0)._2 should be ('B')
    data(1)._1 should be ('G')
    data(1)._2 should be ('D')
    data(2)._1 should be ('Y')
    data(2)._2 should be ('K)
  }

}
