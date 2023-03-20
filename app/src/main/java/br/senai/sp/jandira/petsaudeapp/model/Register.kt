package br.senai.sp.jandira.petsaudeapp.model

import com.google.gson.annotations.SerializedName

data class UserRegister(
	@SerializedName("personName") var name: String,
	var userName: String,
	@SerializedName("cpf") var itp: String,
	var email:  String,
	var password: String,

	var phoneNumber: List<String>,
)
