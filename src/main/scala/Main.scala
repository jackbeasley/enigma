package com.jackbeasley.enigma

object Main {
	def main(args: Array[String]) {
		val rotorI = new RotorI(() => Unit)
		rotorI.setOffsetPosition(0);
		println(rotorI.encodeForward('A'))
		rotorI.turnRotor
		println(rotorI.encodeForward('A'))
		rotorI.setOffsetPosition(25);
		println(rotorI.encodeForward('A'))
		rotorI.turnRotor
		println(rotorI.encodeForward('A'))
	}
}