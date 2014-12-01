package com.jackbeasley.enigma.test

import org.scalatest._
import com.jackbeasley.enigma.RotorI

class RotorSpec extends UnitSpec {
	"A Rotor" should "cipher chars in accordence with its forward mapping" in {
		val rotorI = new RotorI(() => Unit)
		rotorI.setOffsetPosition(0);
		rotorI.encodeForward('A') should be ('E')
		rotorI.turnRotor

		rotorI.encodeForward('A') should be ('K')
		rotorI.setOffsetPosition(25);
		rotorI.encodeForward('A') should be ('J')
		rotorI.turnRotor
		rotorI.encodeForward('A') should be ('E')
	}
}