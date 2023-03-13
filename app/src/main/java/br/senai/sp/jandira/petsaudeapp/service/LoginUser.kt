package br.senai.sp.jandira.petsaudeapp.service

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.Token
import br.senai.sp.jandira.petsaudeapp.model.UserLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun loginUser (loginEmail: String, loginPassword: String, onComplete: (String) -> Unit): String {
	var tokenJWT = ""
	var userInfos = UserLogin(loginEmail, loginPassword)
	val call = RetrofitFactory().retrofitService().loginUser(userInfos)

	call.enqueue(object: Callback<Token> {
		override fun onResponse(call: Call<Token>, response: Response<Token>) {
			if (response.body()?.token == null) {
				Log.i("tokenNulo", tokenJWT)
//				onComplete.invoke(false.toString())
				onComplete.invoke(tokenJWT)
			} else {
				tokenJWT = response.body()!!.token
//				Log.i("CHEGOU", tokenJWT)
				onComplete.invoke(tokenJWT)
			}
		}
		override fun onFailure(call: Call<Token>, t: Throwable) {
			Log.i("ERROR DS3M", t.message.toString())
		}
	})
	return tokenJWT
}