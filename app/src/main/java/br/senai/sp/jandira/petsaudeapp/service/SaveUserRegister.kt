package br.senai.sp.jandira.petsaudeapp.service

import android.util.Log
//import br.senai.sp.jandira.petsaudeapp.model.PhoneNumber
//import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//fun saveUserRegister(
//	name: String,
//	lastName: String,
//	userName: String,
//	itp: String,
//	email: String,
//	password: String,
//	phoneNumber: List<String>,
//	onComplete: (String) -> Unit
//) {
//	val userRegister = UserRegister(
//		name = "$name $lastName",
//		userName,
//		itp,
//		email,
//		password,
//		phoneNumber,
//	)
//	val call = RetrofitFactory().retrofitService().saveUserRegister(userRegister)

//	call.enqueue(object : Callback<Boolean> {
//		override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
//			Log.i("DS3M", "USUÁRIO CRIADO COM SUCESSO")
//		}
//
//		override fun onFailure(call: Call<Boolean>, t: Throwable) {
//			Log.i("DS3M", "ERRO AO CRIAR O USUÁRIO")
//		}

//	})
//}