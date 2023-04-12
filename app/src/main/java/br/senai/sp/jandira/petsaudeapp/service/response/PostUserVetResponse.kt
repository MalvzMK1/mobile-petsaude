package br.senai.sp.jandira.petsaudeapp.service.response

data class PostUserVetResponse(
	val id: Number,
	val personName: String,
	val userName: String,
	val cpf: String,
	val rg: String?,
	val profilePhoto: String?,
	val profileBannerPhoto: String?,
	val email: String,
	val password: String,
	val occupationArea: String,
	val formation: String,
  val institution: String,
  val crmv: String,
	val formationDate: String,
	val startActingDate: String,
  val phoneNumber: String?,
	val cellphoneNumber: String,
	val addressId: Number
)
