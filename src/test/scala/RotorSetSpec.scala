package com.jackbeasley.enigma.test

import org.scalatest._
import com.jackbeasley.enigma.RotorSet

class RotorSetSpec extends UnitSpec {
	"A RotorSet" should "turn the first rotor" in {
		val rs = new RotorSet(Array(1,2,3))
		for(i <- 1 to 20){
			rs.turnSet()
		}
		val r = rs.getRotors
		r(0).getOffset should be (21)
	}
	it should "turn each of its rotors in succesion" in {
		var rs = new RotorSet(Array(1,2,3))
		for(i <- 1 to 260){
			rs.turnSet()
		}
		rs.getRotorPosition(0) should be (1)
		rs.getRotorPosition(1) should be (11)

		rs = new RotorSet(Array(1,2,3))
		for(i <- 1 to 676){
			rs.turnSet()
		}
		rs.getRotorPosition(0) should be (1)
		rs.getRotorPosition(1) should be (1)
		rs.getRotorPosition(2) should be (2)
	}
	it should "cipher a char forward correctly" in {
		var rs = new RotorSet(Array(1,2,3))
		rs.encodeForward('A') should be ('D')
		for(i <- 1 to 674){
			rs.encodeForward('A')
		}
		// 676 turns rotors in pos 1, 1, 2
		rs.encodeForward('A') should be ('Z')
	}
}