package com.jackbeasley.enigma

class RotorI(stepCallback: () => Unit) 
	extends Rotor(
		//Steps at 'R'
		'R',
		//Value pairs
		Array(
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
		),
		//Callback passed to main constructor
		stepCallback) {

		//Rotor type: I -> 1, II -> 2, III - > 3...
		def rotorType = 1

}