package com.jackbeasley.enigma.test

import org.scalatest._
import com.jackbeasley.enigma.rotors.RotorI
import com.jackbeasley.enigma.Rotor

class RotorSpec extends UnitSpec {
	"A Rotor" should "cipher chars in accordence with its forward mapping" in {
		//Default offset is 0
		var rotorI:Rotor = new RotorI(() => Unit)
		rotorI.encodeForward('A') should be ('E')
		rotorI = rotorI.turnRotor

		rotorI.encodeForward('A') should be ('K')
		rotorI = rotorI.setOffset(25);
		rotorI.encodeForward('A') should be ('J')
		rotorI = rotorI.turnRotor
		rotorI.encodeForward('A') should be ('E')
	}
}