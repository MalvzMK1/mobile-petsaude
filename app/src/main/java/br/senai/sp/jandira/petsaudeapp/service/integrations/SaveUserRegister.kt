package br.senai.sp.jandira.petsaudeapp.service.integrations

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.Address
import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun saveUserRegister(userRegister: UserRegister, onComplete: (PostUserResponse) -> Unit) {
//	Log.i("O QUE TEM AQUI", userRegister.toString())
	val call = RetrofitFactory().retrofitService().saveUserRegister(userRegister)

	call.enqueue(object: Callback<PostUserResponse> {
		override fun onResponse(call: Call<PostUserResponse>, response: Response<PostUserResponse>) {
//			Log.i("RESPONSE SUCCESS", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<PostUserResponse>, t: Throwable) {
			Log.i("RESPONSE FAILURE", t.message.toString())
		}
	})
}