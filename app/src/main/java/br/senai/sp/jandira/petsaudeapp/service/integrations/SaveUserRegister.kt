package br.senai.sp.jandira.petsaudeapp.service

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserResponse
//import br.senai.sp.jandira.petsaudeapp.model.PhoneNumber
//import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun saveUserRegister(userRegister: UserRegister, onComplete: (PostUserResponse) -> Unit) {
	val call = RetrofitFactory().retrofitService().saveUserRegister(userRegister)

	call.enqueue(object: Callback<PostUserResponse> {
		override fun onResponse(call: Call<PostUserResponse>, response: Response<PostUserResponse>) {
			Log.i("RESPONSE SUCCESS", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<PostUserResponse>, t: Throwable) {
			Log.i("RESPONSE FAILURE", t.message.toString())
		}
	})
}