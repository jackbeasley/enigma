package com.jackbeasley.enigma

class RotorSet (rotorTypes: Array[Int]) {

  var rotors = createRotors

  def createRotors:Array[Rotor] = {
    var a = new Array[Rotor](rotorTypes.length)
    for(i <- 0 to rotorTypes.length - 1){
      a(i) = Rotor.createRotor(rotorTypes(i))
    }
    return a
  }

  def turnSet() = turnRotor()

  def turnRotor(rotorIndex:Int = 0):Unit = {
    var turnsAt = rotors(rotorIndex).getStepAt
    rotors(rotorIndex) = rotors(rotorIndex).turnRotor

    if(turnsAt.toInt - 64 == rotors(rotorIndex).getOffset){
      // Make sure that it does not go out of bounds
      if(rotorIndex + 1 < rotors.length){
        turnRotor(rotorIndex + 1)
      }
    }
		
  }

  def getRotors:Array[Rotor] = rotors

  def getRotorPosition(rotorIndex:Int) : Int = rotors(rotorIndex).getOffset

  def encodeForward(letter:Char):Char = {
    turnSet
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
