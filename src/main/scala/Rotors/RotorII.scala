package com.jackbeasley.enigma.rotors

import com.jackbeasley.enigma.{Rotor, Cipher}

class RotorII(stepCallback:() => Unit) 
	extends Rotor(
		//Steps at 'F'
		'F',
		//Value pairs
		new Cipher(Array(
			('A','A'),
			('B','J'),
			('C','D'),
			('D','K'),
			('E','S'),
			('F','I'),
			('G','R'),
			('H','U'),
			('I','X'),
			('J','B'),
			('K','L'),
			('L','H'),
			('M','W'),
			('N','T'),
			('O','M'),
			('P','C'),
			('Q','Q'),
			('R','G'),
			('S','Z'),
			('T','N'),
			('U','P'),
			('V','Y'),
			('W','F'),
			('X','V'),
			('Y','O'),
			('Z','E')
		)),
		stepCallback
	) {

		//Rotor type: I -> 1, II -> 2, III - > 3...
		def rotorType = 2

}