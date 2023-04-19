package br.senai.sp.jandira.petsaudeapp.service.integrations.register

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.Address
import br.senai.sp.jandira.petsaudeapp.model.Token
import br.senai.sp.jandira.petsaudeapp.model.UserInfos
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserResponse
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserVetResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//////// INSERT - UserRegister ////////
fun saveUserRegister(userRegister: UserInfos, onComplete: (PostUserResponse) -> Unit) {
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
}

//////// UPDATE - Address ////////
fun putUserLocation(token: Token, addressId: Number, userAddress: Address, onComplete: (PostUserVetResponse) -> Unit){
	val call = RetrofitFactory().retrofitService().putUserLocation(addressId, userAddress)
	Log.i("NOT EMPTY SUCCESS - ADDRESSid", addressId.toString())
	Log.i("NOT EMPTY SUCCESS - USERADDRESS", userAddress.toString())

	call.enqueue(object : Callback<String>{
		override fun onResponse(call: Call<String>, response: Response<String>) {
			TODO("Not yet implemented")
		}

		override fun onFailure(call: Call<String>, t: Throwable) {
			TODO("Not yet implemented")
		}

	})
}