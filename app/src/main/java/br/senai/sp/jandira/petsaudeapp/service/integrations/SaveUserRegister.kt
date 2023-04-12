package br.senai.sp.jandira.petsaudeapp.service.integrations

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.Address
import br.senai.sp.jandira.petsaudeapp.model.UserInfos
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun saveUserRegister(userRegister: UserInfos, onComplete: (PostUserResponse) -> Unit) {
//	var responseSaveUserRegister: PostUserResponse
// 	var responseSaveUserRegister = ""
	val call = RetrofitFactory().retrofitService().saveUserRegister(userRegister)

	call.enqueue(object: Callback<PostUserResponse> {
		override fun onResponse(call: Call<PostUserResponse>, response: Response<PostUserResponse>) {
			Log.i("RESPONSE SUCCESS - SAVE USER", response.body().toString())
			onComplete.invoke(response.body()!!)
//			responseSaveUserRegister = response.body()!!
//			onComplete.invoke(responseSaveUserRegister)
		}

		override fun onFailure(call: Call<PostUserResponse>, t: Throwable) {
			Log.i("RESPONSE ERROR - SAVE USER", t.message.toString())
		}
	})
//	return responseSaveUserRegister
}