package com.jackbeasley.enigma.rotors

import com.jackbeasley.enigma.{Rotor, Cipher}

class RotorI(literalOffset:Int = 1) 
	extends Rotor(
		//Steps at 'R'
		'R',
		//Value pairs
		new Cipher(Array(
			('A','E'),
			('B','K'),
			('C','M'),
			('D','F'),
			('E','L'),
			('F','G'),
			('G','D'),
			('H','Q'),
			('I','V'),
			('J','Z'),
			('K','N'),
			('L','T'),
			('M','O'),
			('N','W'),
			('O','Y'),
			('P','H'),
			('Q','X'),
			('R','U'),
			('S','S'),
			('T','P'),
			('U','A'),
			('V','I'),
			('W','B'),
			('X','R'),
			('Y','C'),
			('Z','J')
		)),
		literalOffset
	) {

		//Rotor type: I -> 1, II -> 2, III - > 3...
		def rotorType = 1

}