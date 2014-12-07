package com.jackbeasley.enigma

import scala.annotation.switch
import com.jackbeasley.enigma.rotors._

class Rotor (
	stepAt:Char,
  	ciphers:Cipher,
  	loc:Int,
  	literalOffset:Int) {

	// Use index zero within class
	val offset = literalOffset - 1
	val stepAtNum = stepAt.toUpper.toInt - 65
	val forwardCipher: Map[Char,Char] = ciphers.getForwardCipher
	val backwardCipher: Map[Char,Char] = ciphers.getBackwardCipher
	/*
	 * Rotor position
	 * For example, if 0, a -> a; if 1, a-> b
	 * Smallest value is 0, for machine this would be 1
	 * Because of this, the max number is 25, not 26
	 */

	def setOffset(pos: Int) : Rotor = new Rotor(stepAt, ciphers, loc, pos)

	def encodeForward(input: Char): Char = forwardCipher(applyOffset(input))

	def encodeBackward(input: Char): Char = backwardCipher(applyOffset(input))

	def applyOffset(letter: Char) : Char = (letter.toInt + offset).toChar

	def getStepAt() : Char = stepAt

	def turnRotor : Rotor = {
		var r:Rotor = null
		if(offset < 25){
			r = new Rotor(stepAt, ciphers, loc, literalOffset + 1)
		} else {
			r = new Rotor(stepAt, ciphers, loc, 1)
		}
		return r
	}

	// Plus one to match machine characteritics
	def getOffset:Int = literalOffset
}

object Rotor {

	def createRotor(num:Int, loc:Int) : Rotor = {
		val obj = (num: @switch) match{
			case 1 => new RotorI(loc)
			case 2 => new RotorII(loc)
			case 3 => new RotorIII(loc)
			case 4 => new RotorIV(loc)
			case 5 => new RotorV(loc)
		}
		return obj
	}
}