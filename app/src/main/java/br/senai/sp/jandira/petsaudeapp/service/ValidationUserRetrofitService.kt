package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.model.Token
import br.senai.sp.jandira.petsaudeapp.model.UserLogin
import retrofit2.Call
import retrofit2.http.*

interface ValidationUserRetrofitService {
	// BASE-URL = "https://localhost:3333"
	@POST("signup")
	fun loginUser(@Body userLogin: UserLogin): Call<Token>

//	@GET("auth")
//	fun validationUser(@Headers("Authorization") Token): Call<Token>
}