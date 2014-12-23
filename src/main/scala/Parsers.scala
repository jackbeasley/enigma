package com.jackbeasley.enigma

object Parsers {
  
  def parseRotorSettings(input:String):Array[(Int,Int)] = {
    // Regex to match numbers in pattern: (2:3)(1:28)(3:12)
    val pattern = """\((\d):(\d+?)\)""".r
    val matches = pattern.findAllMatchIn(input)
    val data = matches.map(m => (m.group(1).toInt, m.group(2).toInt)).toArray

    return data
  }

  def parsePlugboardSettings(input:String):Array[(Char,Char)] = {
    // Sanitize input
    val clean = input.toUpperCase
    // Regex to match numbers in pattern: (2:3)(1:28)(3:12)
    val pattern = """\((\w):(\w)\)""".r
    val matches = pattern.findAllMatchIn(clean)
    val data = matches.map(m => (m.group(1).charAt(0), m.group(2).charAt(0))).toArray

    return data
  }
}
