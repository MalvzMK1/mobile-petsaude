package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.model.*
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserResponse
import br.senai.sp.jandira.petsaudeapp.service.response.PostUserVetResponse
import br.senai.sp.jandira.petsaudeapp.service.response.ResponseValidUser
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

	@POST("pet") // Pets User
	fun postPetUser(@Header("Authorization") token: String, @Query("userID") userId: Int): Call<Pets>

//-------------------------------------------------------GET-------------------------------------------------------------------//
	@GET("auth")
  fun validationUser(@Header("Authorization") token: String): Call<ResponseValidUser>

	@GET("user") // User Default
	fun getUserById(@Query("userId") userId: Number): Call<UserInfos>

	@GET("user") // User Veterinary
	fun getUserVetById(@Query("userId") userId: Number): Call<UserRegister>

//	@GET("pet/all") // Pets User
//	fun getAllPetsUser(@Query("userId") userId: Int): Call<List<PetsCard>>
	@GET("pet/all") // Pets User
	fun getAllPetsUser(@Query("userID") userId: Int): Call<List<PetsCard>>
	@GET("pet") // Pets User by ID
	fun getPetUserById(@Query("petID") petId: Int): Call<Pets>

//-------------------------------------------------------PUT-------------------------------------------------------------------//
	@PUT("address")
	fun putUserLocation(@Query("addressId") addressId: Number, @Body userAddress: Address): Call<String>
	@PUT("pet") // Pets User
	fun putPetUser(@Header("Authorization") token: String, @Query("petID") petID: Int): Call<Pets>
//-------------------------------------------------------DELETE-------------------------------------------------------------------//
	@DELETE("pet") // Pets User
	fun deletePetUser(@Header("Authorization") token: String, @Query("petID") petID: Int): Call<Boolean>
}