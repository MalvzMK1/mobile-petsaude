package br.senai.sp.jandira.petsaudeapp.service.viacep

import com.google.gson.annotations.SerializedName

data class ViacepAddress(
	@SerializedName("cep") val zipCode: String,
	@SerializedName("logradouro") val street: String,
	@SerializedName("bairro") val neighborhood: String,
	@SerializedName("localidade") val city: String,
	@SerializedName("uf") val state: String
)
