package br.senai.sp.jandira.petsaudeapp.service

import android.util.Log
import androidx.compose.material.Text
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
			if (tokenJWT == response.body()!!.token) {
				Log.i("CHEGOU", tokenJWT)
//				onComplete.invoke(tokenJWT)

			} else {
//				response.body() == null
//				Log.i("ds3", "token nulo")
			}
		}

		override fun onFailure(call: Call<Token>, t: Throwable) {
			Log.i("ds", t.message.toString())
		}
	})
}