package com.jackbeasley.enigma.rotors

import com.jackbeasley.enigma.{Rotor, Cipher}

class RotorIV(loc:Int, literalOffset:Int = 1, stepCallback:(Int) => Unit)
	extends Rotor(
		//Steps at 'K'
		'K',
		//Value pairs
		new Cipher(Array(
			('A','E'),
			('B','S'),
			('C','O'),
			('D','V'),
			('E','P'),
			('F','Z'),
			('G','J'),
			('H','A'),
			('I','Y'),
			('J','Q'),
			('K','U'),
			('L','I'),
			('M','R'),
			('N','H'),
			('O','X'),
			('P','L'),
			('Q','N'),
			('R','F'),
			('S','T'),
			('T','G'),
			('U','K'),
			('V','D'),
			('W','C'),
			('X','M'),
			('Y','W'),
			('Z','B')
		)),
		loc,
		literalOffset,
		stepCallback
	) {

		//Rotor type: I -> 1, II -> 2, III - > 3...
		def rotorType = 1

}