package com.jackbeasley.enigma.test

import org.scalatest._
import com.jackbeasley.enigma.rotors._
import com.jackbeasley.enigma.Rotor

class RotorSpec extends UnitSpec {
	"A Rotor" should "cipher chars in accordence with its forward mapping" in {
		//Default offset is 0
		var rotor:Rotor = Rotor.createRotor(1, 1, (Int) => Unit)
		rotor.encodeForward('A') should be ('E')
		rotor = rotor.turnRotor

		rotor.encodeForward('A') should be ('K')
		rotor = rotor.setOffset(26);
		rotor.encodeForward('A') should be ('J')
		rotor = rotor.turnRotor
		rotor.encodeForward('A') should be ('E')
	}
	it should "return the correct offset value" in {
		var rotor:Rotor = Rotor.createRotor(1, 1, (Int) => Unit)
		rotor.getOffset should be (1)
		rotor = rotor.setOffset(25)
		rotor.getOffset should be (25)
	}
	it should "return a valid next rotor object" in {
		var rotor:Rotor = Rotor.createRotor(1, 1, (Int) => Unit)
		rotor.getOffset should be (1)
		rotor = rotor.turnRotor
		rotor.getOffset should be (2)
	}
	it should "rollover the offset from 26 to 1" in {
		var rotor:Rotor = Rotor.createRotor(2, 1, (Int) => Unit)
		for(i <- 1 to 26){
			rotor = rotor.turnRotor
		}
		rotor.getOffset should be (1)
	}
	it should "call the callback method passed to it and pass it its loc" in {
		var loc = 0
		var rotor:Rotor = Rotor.createRotor(2, 1, (l:Int) => 
			loc = l)

		for(i <- 1 to 26){
			rotor = rotor.turnRotor
		}
		// Callback called
		loc should be (1)
	}
}