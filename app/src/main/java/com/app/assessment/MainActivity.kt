package com.app.assessment

import android.app.Activity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.core.widget.addTextChangedListener
import com.app.assessment.databinding.ActivityMainBinding

class MainActivity : Activity() {

  private lateinit var binding: ActivityMainBinding

  private val inputText: String
    get() = binding.etInput.text.toString()

  private val outputText by lazy { binding.output }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    binding = ActivityMainBinding.inflate(layoutInflater)
    setContentView(binding.root)

    setupClickListeners()
  }

  private fun setupClickListeners() {
    binding.btCalculateLength.setOnClickListener {
      calculateLength()
    }

    binding.btReverseString.setOnClickListener {
      reverseString()
    }

    binding.btAppendString.setOnClickListener {
      appendToInputString()
    }

    binding.btCheckNumeric.setOnClickListener {
      checkIfNumeric()
    }

    binding.btClearText.setOnClickListener {
      clearInput()
    }

    binding.etInput.addTextChangedListener { editable ->
      checkIfStringOnlyAlphaNumeric(editable?.toString())
    }
  }

  private fun checkIfStringOnlyAlphaNumeric(text: String?) {
    val isInvalid = text?.isInvalidString() ?: false
    binding.errorText.isVisible = isInvalid
    outputText.text = ""
    enableButtons(!isInvalid)
  }

  private fun enableButtons(enable: Boolean) {
    with(binding) {
      btCalculateLength.isEnabled = enable
      btReverseString.isEnabled = enable
      btAppendString.isEnabled = enable
      btCheckNumeric.isEnabled = enable
    }
  }

  private fun calculateLength() {
    outputText.text = inputText.length.toString()
  }

  private fun reverseString() {
    outputText.text = inputText.reversed()
  }

  private fun appendToInputString() {
    outputText.text = inputText.append123()
  }

  private fun checkIfNumeric() {
    outputText.text = if (inputText.isNumeric()) "Yes" else "No"
  }

  private fun clearInput() {
    outputText.text = ""
    binding.etInput.setText("")
    binding.errorText.isVisible = false
    enableButtons(true)
  }
}