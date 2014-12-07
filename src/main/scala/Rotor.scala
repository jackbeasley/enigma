package com.jackbeasley.enigma

import scala.annotation.switch
import com.jackbeasley.enigma.rotors._

class Rotor (
	stepAt:Char,
  	ciphers:Cipher,
  	literalOffset:Int) {

	// Use index zero within class
	val stepAtNum = stepAt.toUpper.toInt - 65
	val forwardCipher: Map[Char,Char] = ciphers.getForwardCipher
	val backwardCipher: Map[Char,Char] = ciphers.getBackwardCipher
	/*
	 * Rotor position
	 * For example, if 0, a -> a; if 1, a-> b
	 * Smallest value is 0, for machine this would be 1
	 * Because of this, the max number is 25, not 26
	 */

	def setOffset(pos: Int) : Rotor = new Rotor(stepAt, ciphers, pos)

	def encodeForward(input: Char): Char = deOffset(forwardCipher(applyOffset(input)))

	def encodeBackward(input: Char): Char = deOffset(backwardCipher(applyOffset(input)))

	def applyOffset(letter: Char) : Char = {
		var c = (letter.toInt + literalOffset - 1).toChar
		if(c > 'Z'){
			c = (c.toInt - 26).toChar
		}
		return c;
	} 

	def deOffset(letter: Char) : Char = {
		var c = (letter.toInt - (literalOffset - 1)).toChar
		if(c < 'A'){
			c = (c.toInt + 26).toChar
		}
		return c;
	}

	def getStepAt:Char = stepAt

	def turnRotor : Rotor = {
		if(literalOffset == 26){
			return new Rotor(stepAt, ciphers, 1)
		} else {
			return new Rotor(stepAt, ciphers, literalOffset + 1)
		}
	}

	// Plus one to match machine characteritics
	def getOffset:Int = literalOffset
}

object Rotor {

	def createRotor(num:Int, literalOffset:Int = 1) : Rotor = {
		val obj = (num: @switch) match{
			case 1 => new RotorI(literalOffset)
			case 2 => new RotorII(literalOffset)
			case 3 => new RotorIII(literalOffset)
			case 4 => new RotorIV(literalOffset)
			case 5 => new RotorV(literalOffset)
		}
		return obj
	}
}