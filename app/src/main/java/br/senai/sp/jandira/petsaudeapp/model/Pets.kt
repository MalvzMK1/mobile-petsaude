package br.senai.sp.jandira.petsaudeapp.model

data class Pets(
	var id: Int,
	var name: String,
	var birthDate: String,
	var photo: String,
	var microship: Boolean,
	var petSize: String,
	var petGender: String,
	var petSpecieId: Int,
	var ownerId: Int
)
