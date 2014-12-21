package com.jackbeasley.enigma

class Reflector (ciphers:Cipher){
  val cipher:Map[Char,Char] = ciphers.getForwardCipher

  def reflect(input:Char) : Char = {
    return cipher(input)
  }
}
