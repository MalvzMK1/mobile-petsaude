package br.senai.sp.jandira.petsaudeapp.service.integrations.user

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.Token
import br.senai.sp.jandira.petsaudeapp.model.UserInfos
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import br.senai.sp.jandira.petsaudeapp.service.response.ResponseValidUser
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun validationUserJWT(token: String, onComplete: (ResponseValidUser) -> Unit) {
	val call = RetrofitFactory().retrofitService().validationUser(token)

	call.enqueue(object : Callback<ResponseValidUser> {
		override fun onResponse(call: Call<ResponseValidUser>, response: Response<ResponseValidUser>) {
			onComplete.invoke(response.body()!!)
			Log.i("RESPONSE SUCCESS - VALID JWT", response.body().toString())
		}

		override fun onFailure(call: Call<ResponseValidUser>, t: Throwable) {
			Log.i("RESPONSE ERROR - VALID JWT", t.message.toString())
		}

	})
}
