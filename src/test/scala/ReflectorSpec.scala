package com.jackbeasley.enigma.test

import org.scalatest._
import com.jackbeasley.enigma.reflectors._
import com.jackbeasley.enigma.Reflector

class RefelctorSpec extends UnitSpec {
  "A Reflector" should "reflect chars" in {
    // Cipher keys
    val BRes = "YRUHQSLDPXNGOKMIEBFZCWVJAT"
    val CRes = "FVPJIAOYEDRZXWGCTKUQSBNMHL"
    // Test refelctor b
    var refl = Reflector.createReflector('B')
    for(c <- 'A' to 'Z'){
      refl.reflect(c) should be (BRes.charAt(c.toInt - 65))
    }
    
    // Test reflector c
    refl = Reflector.createReflector('C')
    for(c <- 'A' to 'Z'){
      refl.reflect(c) should be (CRes.charAt(c.toInt - 65))
    }
    
  }
}
