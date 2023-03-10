package br.senai.sp.jandira.petsaudeapp.utils

fun validateEmptyInput(inputState: String): Boolean {
	if (inputState == "" || inputState == null)
		return true
	return false
}