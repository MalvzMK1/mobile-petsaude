package br.senai.sp.jandira.petsaudeapp.service.integrations.pet

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.PetsCard
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//////// READ - PetsUser ////////
fun getAllPetsUser(userId: Number, onComplete: (PetsCard) -> Unit) {
	val call = RetrofitFactory().retrofitService().getAllPetsUser(userId)

	call.enqueue(object : Callback<PetsCard> {
		override fun onResponse(call: Call<PetsCard>, response: Response<PetsCard>) {
			Log.i("RESPONSE ERROR - READ PETS USER", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<PetsCard>, t: Throwable) {
			Log.i("RESPONSE ERROR - READ PETS USER", t.message.toString())
		}
	})
}