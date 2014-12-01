package com.jackbeasley.enigma

class Rotor (stepAt: Char, ciphers: Array[(Char, Char)], stepCallback: () => Unit) {

	val stepAtNum = stepAt.toUpper.toInt - 65
	val forwardCipher: Map[Char,Char] = ciphers.toMap
	val backwardCipher: Map[Char,Char] = ciphers.map(t => (t._2, t._1)).toMap
	/*
	 * Rotor position
	 * For example, if 0, a -> a; if 1, a-> b
	 * Smallest value is 0, for machine this would be 1
	 * Because of this, the max number is 25, not 26
	 */
	var offset: Int = 0

	def encodeForward(input: Char): Char = {
		return forwardCipher(applyOffset(input))
	}

	def endodeBackward(input: Char): Char = backwardCipher(applyOffset(input))

	def applyOffset(letter: Char) : Char = (letter.toInt + offset).toChar

	def turnRotor = {
		if(offset < 25){
			offset += 1
		} else {
			offset = 0
		}
		if(offset == stepAtNum){
			stepCallback
		}
	}
}