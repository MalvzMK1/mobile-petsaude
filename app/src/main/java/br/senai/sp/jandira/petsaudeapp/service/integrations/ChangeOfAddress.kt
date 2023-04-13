package br.senai.sp.jandira.petsaudeapp.service.integrations

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.Address
import br.senai.sp.jandira.petsaudeapp.model.Token
import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserVetResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Body

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