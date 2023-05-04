package br.senai.sp.jandira.petsaudeapp.model

data class Pet(
	var id: Int,
	var name: String,
	var birthDate: String,
	var photo: String,
	var microship: Boolean,
	var petSize: String,
	var petGender: String,
	var petSpecieId: Int,
	var ownerId: Int,
	var petSpecie: PetSpecie?
)
data class ApiAllPetResponse(
	var response: List<Pet>
)

data class PetSpecie(
	var id: Int,
	var name: String
)
