package com.jackbeasley.enigma.test

import org.scalatest._
import com.jackbeasley.enigma.{Plugboard,Cipher}

class PlugboardSpec extends UnitSpec {
  "A Plugboard" should "Check for validity" in {
    // Good config, no conflicts
    var settings = Array(('D','C'),('A','Z'),('Y','E'),('X','T'))
    Plugboard.isValid(settings) should be (true)
    // Conflict
    settings = Array(('A','C'),('V','T'),('A','R'),('U','P'),('W','E'))
    Plugboard.isValid(settings) should be (false)
  }
  it should "Determine correct mappings" in {
    var settings = Array(('A','C'),('Y','U'),('P','K'))
    Plugboard.determineMapping(('A','A'), settings) should be (('A','C'))
    Plugboard.determineMapping(('C','C'), settings) should be (('C','A'))
    Plugboard.determineMapping(('Z','Z'),settings) should be (('Z','Z'))
  }
  it should "Create a valid Cipher object" in {
    var settings = Array(('A','C'),('Y','U'),('P','K'))
    val c = Plugboard.toCipher(settings)
    val m = c.getForwardCipher
    m('A') should be ('C')
    m('Y') should be ('U')
    m('U') should be ('Y')
    m('B') should be ('B')
  }
}
