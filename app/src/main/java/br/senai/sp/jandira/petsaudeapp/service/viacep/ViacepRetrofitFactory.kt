package br.senai.sp.jandira.petsaudeapp.service.viacep

import br.senai.sp.jandira.petsaudeapp.lib.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ViacepRetrofitFactory {
	companion object {
		private lateinit var instance: Retrofit
		fun getRetrofitInstance(): Retrofit {
			if (!Companion::instance.isInitialized) {
				instance = Retrofit
					.Builder()
					.baseUrl("https://viacep.com.br/ws/")
					.addConverterFactory(GsonConverterFactory.create())
					.build()
			}
			return instance
		}
	}
	fun retrofitService(): ViacepRetrofitService {
		return getRetrofitInstance().create(ViacepRetrofitService::class.java)
	}
}