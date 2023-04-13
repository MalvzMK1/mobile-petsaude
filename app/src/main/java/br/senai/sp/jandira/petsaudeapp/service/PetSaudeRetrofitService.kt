package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.model.*
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserResponse
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserVetResponse
import retrofit2.Call
import retrofit2.http.*

interface PetSaudeRetrofitService {

														// BASE-URL = "https://10.0.2.2:3333" //

//------------------------------------------------------POST-------------------------------------------------------------------//
																									//##MainActivity##//
	@POST("signup")
	fun loginUser(@Body userLogin: UserLogin): Call<Token>

																	//##RegisterActivity and RegisterAddressActivity##//
	@POST("user")
	fun saveUserRegister(@Body register: UserInfos): Call<PostUserResponse>

																					//##RegisterProfessionalActivity##//
	@POST("veterinary")
	fun saveUserRegisterVet(@Body registerVet: UserRegister): Call<PostUserVetResponse>

//-------------------------------------------------------GET-------------------------------------------------------------------//
																							//##UserConfigActivity##//
	//	@GET("auth")
	//	fun validationUser(@Headers("Authorization") Token): Call<Token>

	@GET("user") // User Default
	fun getUserById(@Query("userId") userId: Number): Call<UserInfos>

	@GET("user") // User Veterinary
	fun getUserVetById(@Query("userId") userId: Number): Call<UserRegister>

//-------------------------------------------------------PUT-------------------------------------------------------------------//
																							//##UserLocationActivity##//
	@PUT("address")
	fun putUserLocation(@Query("addressId") addressId: Number, @Body userAddress: Address): Call<String>

}