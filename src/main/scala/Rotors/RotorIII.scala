package com.jackbeasley.enigma.rotors

import com.jackbeasley.enigma.{Rotor, Cipher}

class RotorIII(literalOffset:Int = 1) 
	extends Rotor(
		//Steps at 'W'
		'W',
		//Value pairs
		new Cipher(Array(
			('A','B'),
			('B','D'),
			('C','F'),
			('D','H'),
			('E','J'),
			('F','L'),
			('G','C'),
			('H','P'),
			('I','R'),
			('J','T'),
			('K','X'),
			('L','V'),
			('M','Z'),
			('N','N'),
			('O','Y'),
			('P','E'),
			('Q','I'),
			('R','W'),
			('S','G'),
			('T','A'),
			('U','K'),
			('V','M'),
			('W','U'),
			('X','S'),
			('Y','Q'),
			('Z','O')
		)),
		literalOffset
	) {

		//Rotor type: I -> 1, II -> 2, III - > 3...
		def rotorType = 1

}