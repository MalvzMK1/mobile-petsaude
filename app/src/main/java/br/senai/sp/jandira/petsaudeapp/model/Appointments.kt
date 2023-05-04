package br.senai.sp.jandira.petsaudeapp.model

data class Appointments(
	var id: Int,
	var description: String,
	var status: String,
	var date: String,
	var startsAt: String,
	var endsAt: String,
	var clientId: Int,
	var veterinaryId: Int,
	var petId: Int
)
