package br.senai.sp.jandira.petsaudeapp.service.integrations.user

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import br.senai.sp.jandira.petsaudeapp.service.response.ApiUserByIdResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun getUserInfosById(userId: Int, onComplete: (ApiUserByIdResponse) -> Unit){
	val call = RetrofitFactory().retrofitService().getUserById(userId)

	call.enqueue(object : Callback<ApiUserByIdResponse> {
		override fun onResponse(call: Call<ApiUserByIdResponse>, response: Response<ApiUserByIdResponse>) {
			Log.i("RESPONSE SUCCESS - USER", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<ApiUserByIdResponse>, t: Throwable) {
			Log.i("RESPONSE ERROR - USER", t.message.toString())
		}
	})

}