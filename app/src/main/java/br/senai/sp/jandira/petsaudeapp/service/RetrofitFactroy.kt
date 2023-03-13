package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.lib.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {
	companion object {
		private lateinit var instance: Retrofit
		fun getRetrofitInstance(): Retrofit {
			if (!::instance.isInitialized) {
				instance = Retrofit
					.Builder()
					.baseUrl(Constants.BASE_URL)
					.addConverterFactory(GsonConverterFactory.create())
					.build()
			}
			return instance
		}
	}
	fun retrofitService(): PetSaudeRetrofitService {
		return getRetrofitInstance().create(PetSaudeRetrofitService::class.java)
	}
}