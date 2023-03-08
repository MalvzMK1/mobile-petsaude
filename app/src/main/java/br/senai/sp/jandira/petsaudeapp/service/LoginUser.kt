package br.senai.sp.jandira.petsaudeapp.service

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.Token
import br.senai.sp.jandira.petsaudeapp.model.UserLogin
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun loginUser (loginEmail: String, loginPassword: String, onComplete: (String) -> Unit) {
	var tokenJWT = ""

	var userInfos = UserLogin(loginEmail, loginPassword)

	val call = RetrofitFactroy().retrofitService().loginUser(userInfos)

	call.enqueue(object: Callback<Token> {
		override fun onResponse(call: Call<Token>, response: Response<Token>) {
			tokenJWT = response.body()!!.token
			Log.i("CHEGOU", tokenJWT)
			onComplete.invoke(tokenJWT)
		}

		override fun onFailure(call: Call<Token>, t: Throwable) {
			Log.i("ds", t.message.toString())
		}
	})


//	call.enqueue(object : Callback<Token> {
//		override fun onResponse(call: Call<Token>, response: Response<Token>) {
//			tokenJWT = response.body()!!.token
//			onComplete.invoke(tokenJWT)
//			Log.i("ds", tokenJWT)
//
//		override fun onFailure(call: Call<Token>, t: Throwable) {
//			Log.i("ds", t.message.toString())
//		}
//	})
}