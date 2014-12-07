package com.jackbeasley.enigma

class RotorSet (rotorTypes: Array[Int]) {

	var rotors = createRotors
	
	def createRotors:Array[Rotor] = {
		var a = new Array[Rotor](rotorTypes.length)
		for(i <- 0 to rotorTypes.length - 1){
			// Loc is plus 1 because it affects the rotor one to the right(left in machine)
			a(i) = Rotor.createRotor(rotorTypes(i), i + 1, turnRotorCallback)
		}
		return a
	}

	def turnRotorCallback(loc:Int) = {
		if(loc < rotorTypes.length){
			rotors(loc) = rotors(loc).turnRotor
		}
	}

	def turnFirstRotor = {
		val r = rotors(0).turnRotor
		rotors(0) = r
	}

	def getRotors:Array[Rotor] = rotors

	def getRotorPosition(rotorIndex:Int) : Int = rotors(rotorIndex).getOffset

	def encodeForward(letter:Char):Char = {
		var c = letter
		for(r <- rotors){
			c = r.encodeForward(c)
		}
		return c
	}

	def encodeBackward(letter:Char):Char = {
		var c = letter
		for(i <- rotors.length - 1 to 0 by -1){
			c = rotors(i).encodeBackward(c)
		}
		return c
	}
}