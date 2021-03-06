package com.jackbeasley.enigma

class Cipher(cipherArray:Array[(Char, Char)]) {

  val forwardCipher = cipherArray.toMap
  val backwardCipher = cipherArray.map(t => (t._2, t._1)).toMap

  def getForwardCipher = forwardCipher
  def getBackwardCipher = backwardCipher

  def cipherForward(input:Char):Char = forwardCipher(input)
  def cipherBackward(input:Char):Char = backwardCipher(input)

}

