package br.senai.sp.jandira.petsaudeapp.model

import com.google.gson.annotations.SerializedName

data class UserDefault(
	@SerializedName("personName") val name: String,
	@SerializedName("cpf") val itp: String,
	val email: String,
	val password: String,
	val cellphoneNumber: String,
	val phoneNumber: String?
): java.io.Serializable

