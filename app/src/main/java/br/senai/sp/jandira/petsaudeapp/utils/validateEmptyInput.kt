package br.senai.sp.jandira.petsaudeapp.utils

fun validateEmptyInput(inputState: String): Boolean {
	if (inputState == "")
		return true
	return false
}
