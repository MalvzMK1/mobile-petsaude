package br.senai.sp.jandira.petsaudeapp.service.response

data class ResponseValidUser(
	var id: Int,
	var email: String,
	var profileBannerPhoto: String,
	var profilePhoto: String,
	var userName: String,
	var createdAt: String,
	var iat: Number,
	var exp: Number
)
