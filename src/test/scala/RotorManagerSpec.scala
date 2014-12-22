package com.jackbeasley.enigma.test

import com.jackbeasley.enigma.{RotorManager,RotorSet,Reflector}

class RotorManagerSpec extends UnitSpec{
  "a RotorManager" should "cipher an individual letter" in {
    var rm = new RotorManager(
      new RotorSet(Array(1,2,3)),
      Reflector.createReflector('B')
    )
    rm.cipherChar('A') should be ('F')
  }

  it should "cipher sentences" in {
    var rm = new RotorManager(
      new RotorSet(Array(1,2,3)),
      Reflector.createReflector('B')
    )
    val test = "hellothisisatestoftherotors"
    val correct = "MFNCZXEZHZUWBNRCEOFLQEUKJWI"
    rm.cipherString(test) should be (correct)

  }
}
