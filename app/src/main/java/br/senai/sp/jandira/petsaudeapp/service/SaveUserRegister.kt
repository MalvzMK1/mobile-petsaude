package br.senai.sp.jandira.petsaudeapp.service

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun saveUserRegister(nameState: String,
										 lastnameState: String,
										 itpState: String,
										 emailState: String,
										 passwordState: String,
										 cellphoneNumberState: String,
										 phoneNumberState: String,
										 onComplete: (String) -> Unit) {
//	var resultSave = ""
	var userRegister = UserRegister(
		nameState,
		lastnameState,
		itpState,
		emailState,
		passwordState,
		cellphoneNumberState,
		phoneNumberState
	)
	val call = RetrofitFactory().retrofitService().saveUserRegister(userRegister)
	
	call.enqueue(object: Callback<Boolean> {
		override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
//			Log.i("DS3M", "USUÁRIO CRIADO COM SUCESSO, NOME: ${response.body()!!}")
			Log.i("DS3M", "USUÁRIO CRIADO COM SUCESSO, NOME: ${response.body()!!}")
		}

		override fun onFailure(call: Call<Boolean>, t: Throwable) {
//			Log.i("DS3M", "ERRO AO CRIAR O USUÁRIO")
		}

	})
}