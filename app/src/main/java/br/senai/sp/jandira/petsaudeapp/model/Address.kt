package br.senai.sp.jandira.petsaudeapp.model

data class Address(
	val cep: String,
	val city: String,
	val state: String,
	val street: String,
	val neighborhood: String,
	val number: String,
	val complement: String?
):java.io.Serializable
