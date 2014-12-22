package com.jackbeasley.enigma.reflectors

import com.jackbeasley.enigma.{Reflector, Cipher}

class ReflectorC extends Reflector(
  new Cipher(Array(
    ('A','F'),
    ('B','V'),
    ('C','P'),
    ('D','J'),
    ('E','I'),
    ('F','A'),
    ('G','O'),
    ('H','Y'),
    ('I','E'),
    ('J','D'),
    ('K','R'),
    ('L','Z'),
    ('M','X'),
    ('N','W'),
    ('O','G'),
    ('P','C'),
    ('Q','T'),
    ('R','K'),
    ('S','U'),
    ('T','Q'),
    ('U','S'),
    ('V','B'),
    ('W','N'),
    ('X','M'),
    ('Y','H'),
    ('Z','L')
  ))
) {

  def reflectorType = 'B'

}
