package com.jackbeasley.enigma

class Rotor (stepAt:Char, ciphers:Cipher, stepCallback:() => Unit, offset:Int = 0) {

	val stepAtNum = stepAt.toUpper.toInt - 65
	val forwardCipher: Map[Char,Char] = ciphers.getForwardCipher
	val backwardCipher: Map[Char,Char] = ciphers.getBackwardCipher
	/*
	 * Rotor position
	 * For example, if 0, a -> a; if 1, a-> b
	 * Smallest value is 0, for machine this would be 1
	 * Because of this, the max number is 25, not 26
	 */

	def setOffset(pos: Int) : Rotor = new Rotor(stepAt, ciphers, stepCallback, pos)

	def encodeForward(input: Char): Char = forwardCipher(applyOffset(input))

	def endodeBackward(input: Char): Char = backwardCipher(applyOffset(input))

	def applyOffset(letter: Char) : Char = (letter.toInt + offset).toChar

	def turnRotor : Rotor = {
		var r:Rotor = null
		if(offset < 25){
			r = new Rotor(stepAt, ciphers, stepCallback, offset + 1)
		} else {
			r = new Rotor(stepAt, ciphers, stepCallback, 0)
		}
		if(offset == stepAtNum){
			stepCallback
		}
		return r
	}
}