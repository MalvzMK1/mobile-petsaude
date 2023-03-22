package br.senai.sp.jandira.petsaudeapp.service.viacep

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ViacepRetrofitService {

	@GET("{zipCode}/json")
	fun getAddressByZipCode(@Path("zipCode") zipCode: String): Call<ViacepAddress>

}