package br.senai.sp.jandira.petsaudeapp.service.integrations

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.VetInfos
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun createVetInfos(userId: Number, vetInfos: VetInfos, onComplete: (VetInfos) -> Unit) {
	val call = RetrofitFactory().retrofitService().createVetInfosInAnExistingUser(userId, vetInfos)

	call.enqueue(object: Callback<VetInfos> {
		override fun onResponse(call: Call<VetInfos>, response: Response<VetInfos>) {
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<VetInfos>, t: Throwable) {
			Log.i("DS3M", t.message.toString())
		}
	})
}