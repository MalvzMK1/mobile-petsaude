//package br.senai.sp.jandira.petsaudeapp.service.integrations.user
//
//import android.util.Log
//import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
//import br.senai.sp.jandira.petsaudeapp.service.response.PostUserResponse
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//fun getUserInfosById(userId: Number, onComplete: (PostUserResponse) -> Unit){
//	val call = RetrofitFactory().retrofitService().getUserById(userId)
//
//	call.enqueue(object : Callback<PostUserResponse> {
//		override fun onResponse(call: Call<PostUserResponse>, response: Response<PostUserResponse>) {
//			Log.i("RESPONSE SUCCESS - USER", response.toString())
//		}
//
//		override fun onFailure(call: Call<PostUserResponse>, t: Throwable) {
//			Log.i("RESPONSE ERROR - USER", t.message.toString())
//		}
//
//	})
//}