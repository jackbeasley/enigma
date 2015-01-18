package com.jackbeasley.enigma

class Plugboard(cipher:Cipher) {

  def mapForward(input:Char):Char = cipher.cipherForward(input)

  def mapBackward(input:Char):Char = cipher.cipherBackward(input)

}

object Plugboard {

  def isValid(settings:Array[(Char,Char)]):Boolean = {
    var rawString = ""
    // Empty the mappings to a string
    settings.foreach{case(one:Char,two:Char) => rawString += "" + one + two}
    // Loop through the string (char, index)
    for(t <- rawString.zipWithIndex){
      // String of everything but the tested char
      val excluded = rawString.substring(0,t._2) + rawString.substring(t._2 + 1)
      if(excluded.contains(t._1)){
        // Double mapping
        return false
      }
    }
    // No double mappings
    return true
  }

  def toCipher(settings:Array[(Char,Char)]):Cipher = {
    // Check for validity
    if(isValid(settings)){
      // Create inital array with alphabetical mappings
      val table = ('A' to 'Z') zip ('A' to 'Z')
      val finalTable = table.map(t => Plugboard.determineMapping(t, settings))
      return new Cipher(finalTable.toArray)
    } else {
      // TODO: add safe exception
      return new Cipher(Array())
    }
  }

  def determineMapping(input:(Char,Char), settings:Array[(Char,Char)]):(Char,Char) = {
    val target = input._2
    val left = settings.unzip._1.zipWithIndex
    val right = settings.unzip._2.zipWithIndex
    for(t <- left){
      if(t._1 == target) return (t._1, settings(t._2)._2)
    }
    for(t <- right){
      if(t._1 == target) return (t._1, settings(t._2)._1)
    }
    // No plugboard mapping found
    return (target,target)
  }

}


