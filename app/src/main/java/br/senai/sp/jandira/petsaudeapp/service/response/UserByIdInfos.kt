package br.senai.sp.jandira.petsaudeapp.service.response

import br.senai.sp.jandira.petsaudeapp.model.Address
import br.senai.sp.jandira.petsaudeapp.model.Appointments
import br.senai.sp.jandira.petsaudeapp.model.Pet
import com.google.gson.annotations.SerializedName

data class ApiUserByIdResponse(
	val response: UserObject
)

data class UserObject(
	val user: UserByIdInfos
)

data class UserByIdInfos(
	var id: Int,
	var personName: String,
	var userName: String,
	var cpf: String,
	var rg: String?,
	var profilePhoto: String?,
	var profileBannerPhoto: String?,
	var email: String,
	var password: String,
	var phoneNumber: String,
	var cellphoneNumber: String,
	var isVet: Boolean,
	var biography: String?,
	var addressId: Number,
	@SerializedName("Pet") var pet: List<Pet>,
	@SerializedName("Address") var address: Address,
	@SerializedName("Appointments") var appointments: List<Appointments>
)
