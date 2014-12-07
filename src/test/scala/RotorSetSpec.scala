package com.jackbeasley.enigma.test

import org.scalatest._
import com.jackbeasley.enigma.RotorSet

class RotorSetSpec extends UnitSpec {
	"A RotorSet" should "turn the first rotor" in {
		val rs = new RotorSet(Array(1,2,3))
		for(i <- 1 to 20){
			rs.turnFirstRotor
		}
		val r = rs.getRotors
		r(0).getOffset should be (21)
	}
	it should "turn each of its rotors in succesion" in {
		val rs = new RotorSet(Array(1,2,3))
		for(i <- 1 to 676){
			rs.turnFirstRotor
		}
		rs.getRotorPosition(0) should be (3)
		rs.getRotorPosition(1) should be (2)
		rs.getRotorPosition(2) should be (2)
	}
}