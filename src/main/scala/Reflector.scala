package com.jackbeasley.enigma

import com.jackbeasley.enigma.reflectors._

class Reflector (ciphers:Cipher){
  val cipher:Map[Char,Char] = ciphers.getForwardCipher

  def reflect(input:Char) : Char = {
    return cipher(input)
  }
}

object Reflector {

  def createReflector(let:Char) : Reflector = {
    if(let == 'B') return new ReflectorB
    else return new ReflectorC
  }
}
