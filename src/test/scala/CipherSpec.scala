package com.jackbeasley.enigma.test

import org.scalatest._
import com.jackbeasley.enigma.Cipher

class CipherSpec extends UnitSpec {
  "A Cipher" should "Return a map in the forward direction" in {
    val a = Array(('A', 'B'), ('C', 'D'))
    val c = new Cipher(a)
    val m = c.getForwardCipher
    m('A') should be ('B')
    m('C') should be ('D')
  }
  it should "Return a map in the backward direction" in {
    val a = Array(('A', 'B'), ('C', 'D'))
    val c = new Cipher(a)
    val m = c.getBackwardCipher
    m('B') should be ('A')
    m('D') should be ('C')
  }
}
