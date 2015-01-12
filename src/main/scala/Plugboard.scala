package com.jackbeasley.enigma

import com.jackbeasley.enigma

class Plugboard(settings:Array[(Char,Char)]) {

  def isValid():Boolean = {
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

  def toCipher():Cipher = {
    // Check for validity
    if(!isValid) return null
    // Create inital array with alphabetical mappings
    val table = ('A' to 'Z') zip ('A' to 'Z')
    val finalTable = table.map(t => determineMapping(t))
    return new Cipher(finalTable.toArray)
  }

  def determineMapping(input:(Char,Char)):(Char,Char) = {
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
