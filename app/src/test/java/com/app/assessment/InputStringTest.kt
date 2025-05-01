package com.app.assessment

import org.junit.Assert.*
import org.junit.Test

class InputStringTest {

  @Test
  fun testIsInvalidString() {
    val str = "Hello@123"
    val isInvalid = str.isInvalidString()
    assertTrue(isInvalid)
  }

  @Test
  fun testIsNumeric() {
    val str = "123"
    val isNumeric = str.isNumeric()
    assertTrue(isNumeric)
  }

  @Test
  fun testAppend123() {
    val str = "Hello"
    val appendedStr = str.append123()
    assertEquals("Hello123", appendedStr)
  }

  @Test
  fun testIsNumericFalse() {
    val str = "Hello"
    val isNumeric = str.isNumeric()
    assertFalse(isNumeric)
  }

  @Test
  fun testIsInvalidStringFalse() {
    val str = "Hello123"
    val isInvalid = str.isInvalidString()
    assertFalse(isInvalid)
  }

  @Test
  fun testIsNumericEmpty() {
    val str = ""
    val isNumeric = str.isNumeric()
    assertFalse(isNumeric)
  }

  @Test
  fun testIsInvalidStringEmpty() {
    val str = ""
    val isInvalid = str.isInvalidString()
    assertFalse(isInvalid)
  }
}