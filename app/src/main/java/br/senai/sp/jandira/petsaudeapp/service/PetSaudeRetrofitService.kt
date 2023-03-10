package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.model.Token
import br.senai.sp.jandira.petsaudeapp.model.UserLogin
import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface PetSaudeRetrofitService {

														// BASE-URL = "https://10.0.2.2:3333" //

//----------------------------------------MainActivity--------------------------------------------//
	@POST("signup")
	fun loginUser(@Body userLogin: UserLogin): Call<Token>
//	@GET("auth")
//	fun validationUser(@Headers("Authorization") Token): Call<Token>

//--------------------------------------RegisterActivity------------------------------------------//
	@POST("user")
	fun saveUserRegister(@Body userRegister: UserRegister): Call<Boolean>

//-----------------------------------RegisterAdressActivity---------------------------------------//
}