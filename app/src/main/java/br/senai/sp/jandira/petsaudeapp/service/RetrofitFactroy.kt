package br.senai.sp.jandira.petsaudeapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactroy {
	val baseUrl = "http://10.0.2.2:3333/"
	val retroFitFactory = Retrofit.Builder()
		.baseUrl(baseUrl)
		.addConverterFactory(GsonConverterFactory.create())
		.build()

	fun retrofitService(): PetSaudeRetrofitService {
		return retroFitFactory.create(PetSaudeRetrofitService::class.java)
	}
}