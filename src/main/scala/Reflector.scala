package com.jackbeasley.enigma

import com.jackbeasley.enigma.reflectors._

class Reflector (ciphers:Cipher){
  
  def reflect(input:Char) : Char = {
    return ciphers.cipherForward(input)
  }
}

object Reflector {

  def createReflector(let:Char) : Reflector = {
    if(let == 'B') return new ReflectorB
    else return new ReflectorC
  }
}
