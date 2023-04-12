package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.model.*
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserResponse
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserVetResponse
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
	fun saveUserRegister(@Body register: UserInfos): Call<PostUserResponse>

//-------------------------------------------RegisterProfessionalActivity-----------------------------------------------------//
	@POST("veterinary")
	fun saveUserRegisterVet(@Body registerVet: UserRegister): Call<PostUserVetResponse>

//----------------------------------------------UserConfigActivity------------------------------------------------------------//
	@GET("user") // User Default
	fun getUserById(@Query("userId") userId: Number): Call<UserInfos>

//	@GET("user") // User Veterinary
//	fun getUseVetById(@Query("userId") userId: Number): Call<UserRegister>
}