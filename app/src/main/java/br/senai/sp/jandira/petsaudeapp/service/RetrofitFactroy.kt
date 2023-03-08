package br.senai.sp.jandira.petsaudeapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactroy {
	val baseUrl = "http://localhost:3333/"
	val retroFitFactory = Retrofit.Builder()
		.baseUrl(baseUrl)
		.addConverterFactory(GsonConverterFactory.create())
		.build()

	fun retrofitService(): ValidationUserRetrofitService {
		return retroFitFactory.create(ValidationUserRetrofitService::class.java)
	}
}