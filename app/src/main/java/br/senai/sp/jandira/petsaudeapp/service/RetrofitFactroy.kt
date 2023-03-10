package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.lib.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

<<<<<<< HEAD
class RetrofitFactory {
	companion object{
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
=======
class RetrofitFactroy {
	val baseUrl = "http://10.0.2.2"
	val retroFitFactory = Retrofit.Builder()
		.baseUrl(baseUrl)
		.addConverterFactory(GsonConverterFactory.create())
		.build()

>>>>>>> c602039 (validating inputs in progress)
	fun retrofitService(): PetSaudeRetrofitService {
		return getRetrofitInstance().create(PetSaudeRetrofitService::class.java)
	}
}