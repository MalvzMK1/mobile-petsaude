package br.senai.sp.jandira.petsaudeapp.model

data class UserRegister(
	var name: String,
	var lastName: String,
	var itp: String,
	var email:  String,
	var password: String,
	var cellphone: String,
	var phone: String
)
