package com.jackbeasley.enigma.test

import org.scalatest._
import com.jackbeasley.enigma.{Plugboard,Cipher}

class PlugboardSpec extends UnitSpec {
  "A Plugboard" should "Check for validity" in {
    // Good config, no conflicts
    var p = new Plugboard(Array(('D','C'),('A','Z'),('Y','E'),('X','T')))
    p.isValid() should be (true)
    // Conflict
    p = new Plugboard(Array(('A','C'),('V','T'),('A','R'),('U','P'),('W','E')))
    p.isValid() should be (false)
  }
  it should "Determine correct mappings" in {
    var p = new Plugboard(Array(('A','C'),('Y','U'),('P','K')))
    p.determineMapping(('A','A')) should be (('A','C'))
    p.determineMapping(('C','C')) should be (('C','A'))
    p.determineMapping(('Z','Z')) should be (('Z','Z'))
  }
  it should "Create a valid Cipher object" in {
    var p = new Plugboard(Array(('A','C'),('Y','U'),('P','K')))
    val c = p.toCipher()
    val m = c.getForwardCipher
    m('A') should be ('C')
    m('Y') should be ('U')
    m('U') should be ('Y')
    m('B') should be ('B')
  }
}
