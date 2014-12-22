package com.jackbeasley.enigma

class RotorManager(rotors:RotorSet, reflector:Reflector){

  def cipherChar(letter:Char):Char = {
    // Sanitize input
    var tmp = letter.toUpper
    tmp = rotors.encodeForward(tmp)
    tmp = reflector.reflect(tmp)
    tmp = rotors.encodeBackward(tmp)
    return tmp
  }

  def cipherString(orig:String):String = {
    var output = ""
    for(c <- orig){
      output += cipherChar(c)
    }
    return output
  }
}
