package br.senai.sp.jandira.petsaudeapp.service.response

data class PostUserResponse(
	val id: Int,
	val personName: String,
	val userName: String,
	val cpf: String,
	val rg: String?,
	val profilePhoto: String?,
	val profileBannerPhoto: String?,
	val email: String,
	val password: String,
	val phoneNumber: String,
	val cellphoneNumber: String,
	val addressId: Number
)
