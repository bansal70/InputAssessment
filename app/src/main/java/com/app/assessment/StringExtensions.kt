package com.app.assessment

fun String.isInvalidString(): Boolean {
  // Note: Spaces are treated as special characters here.
  return any { !it.isLetterOrDigit() }
}

fun String.isNumeric(): Boolean {
  return isNotEmpty() && all { it.isDigit() }
}

fun String.append123(): String {
  return this + "123"
}