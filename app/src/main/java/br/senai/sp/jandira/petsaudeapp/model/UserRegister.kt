package br.senai.sp.jandira.petsaudeapp.model

import com.google.gson.annotations.SerializedName

data class UserRegister(
	@SerializedName("personName") val name: String,
	@SerializedName("cpf") val itp: String,
	val email: String,
	val password: String,
	val cellphoneNumber: String,
	val phoneNumber: String?,
	val address: Address
): java.io.Serializable
