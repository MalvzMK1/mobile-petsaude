package br.senai.sp.jandira.petsaudeapp.model

import com.google.gson.annotations.SerializedName

data class UserRegister(
	@SerializedName("personName")
	var name: String,

	@SerializedName("userName")
	var userName: String,

	@SerializedName("cpf")
	var itp: String,
	var email:  String,
	var password: String,
	var cellphoneNumber: String,
	var phoneNumber: String
)
