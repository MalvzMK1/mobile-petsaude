package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.model.Token
import br.senai.sp.jandira.petsaudeapp.model.UserLogin
import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import br.senai.sp.jandira.petsaudeapp.model.VetInfos
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface PetSaudeRetrofitService {

														// BASE-URL = "https://10.0.2.2:3333" //

//------------------------------------------------------MainActivity-----------------------------------------------------------//
	@POST("signup")
	fun loginUser(@Body userLogin: UserLogin): Call<Token>
//	@GET("auth")
//	fun validationUser(@Headers("Authorization") Token): Call<Token>

//--------------------------------------RegisterActivity and RegisterAddressActivity------------------------------------------//
	@POST("user")
	fun saveUserRegister(@Body register: UserRegister): Call<PostUserResponse>

//-------------------------------------------RegisterProfessionalActivity-----------------------------------------------------//
	@POST("veterinarian/user")
	fun createVetInfosInAnExistingUser(@Query("userId") userId: Number, @Body vetInfos: VetInfos): Call<VetInfos>

//----------------------------------------------UserConfigActivity------------------------------------------------------------//
	@GET("user")
	fun getUserById(@Query("userId") userId: Number): Call<PostUserResponse>
}