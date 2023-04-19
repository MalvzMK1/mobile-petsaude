package br.senai.sp.jandira.petsaudeapp.service.integrations.register

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserVetResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//////// INSERT - UserVet ////////
fun createUserVet(registerVet: UserRegister, onComplete: (PostUserVetResponse) -> Unit) {
	val call = RetrofitFactory().retrofitService().saveUserRegisterVet(registerVet)
	Log.i("NOT EMPTY SUCCESS - VET", registerVet.toString())

	call.enqueue(object: Callback<PostUserVetResponse> {
		override fun onResponse(call: Call<PostUserVetResponse>, response: Response<PostUserVetResponse>) {
			Log.i("RESPONSE SUCCESS - VET", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<PostUserVetResponse>, t: Throwable) {
			Log.i("RESPONSE ERROR - VET", t.message.toString())
		}
	})
}