package com.jackbeasley.enigma

import com.jackbeasley.enigma

class Plugboard(settings:Array[(Char,Char)]) {

  def isValid():Boolean = {
    var rawString = ""
    // Empty the mappings to a string
    settings.foreach{case(one,two) => rawString += one + two}
    // Loop through the string (char, index)
    for(t <- rawString.zipWithIndex){
      // String of everything but the tested char
      val excluded = rawString.substring(0,t._2) + rawString.substring(t._2)
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
    val editTable = settings.map(t => t._1)
    val finaltable = table.map{ case(i,o) =>
      val editIndex = editTable.indexOf(i)
      if(editIndex >= 0){
        
      }
    }
  }

}
