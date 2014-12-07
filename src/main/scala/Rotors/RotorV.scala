package com.jackbeasley.enigma.rotors

import com.jackbeasley.enigma.{Rotor, Cipher}

class RotorV(loc:Int, literalOffset:Int = 1)
	extends Rotor(
		//Steps at 'A'
		'A',
		//Value pairs
		new Cipher(Array(
			('A','V'),
			('B','Z'),
			('C','B'),
			('D','R'),
			('E','G'),
			('F','I'),
			('G','T'),
			('H','Y'),
			('I','U'),
			('J','P'),
			('K','S'),
			('L','D'),
			('M','N'),
			('N','H'),
			('O','L'),
			('P','X'),
			('Q','A'),
			('R','W'),
			('S','M'),
			('T','J'),
			('U','Q'),
			('V','O'),
			('W','F'),
			('X','E'),
			('Y','C'),
			('Z','K')
		)),
		loc,
		literalOffset
	) {

		//Rotor type: I -> 1, II -> 2, III - > 3...
		def rotorType = 1

}