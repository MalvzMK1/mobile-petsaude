package br.senai.sp.jandira.petsaudeapp.service.integrations.user

//import br.senai.sp.jandira.petsaudeapp.model.Token
//import retrofit2.Call
//import retrofit2.Callback
//import retrofit2.Response
//
//fun validationUserJWT(auth: String, onComplete: (String) -> Unit) {
//	var result = ""
//	var token = Token(auth)
//
//	val call = RetrofitFactroy().retrofitService().validationUser(token)
//
//	call.enqueue(object : Callback<Token> {
//		override fun onResponse(call: Call<Token>, response: Response<Token>) {
//			result = response.body()!!.token
//			onComplete.invoke(result)
//		}
//
//		override fun onFailure(call: Call<Token>, t: Throwable) {
//			TODO("Not yet implemented")
//		}
//
//
//	})
//}
