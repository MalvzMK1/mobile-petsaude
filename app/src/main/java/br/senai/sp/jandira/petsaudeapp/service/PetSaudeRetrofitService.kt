package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.model.*
import br.senai.sp.jandira.petsaudeapp.service.response.*
import retrofit2.Call
import retrofit2.http.*

interface PetSaudeRetrofitService {

																				// BASE-URL = "https://10.0.2.2:3333" //

//------------------------------------------------------POST-------------------------------------------------------------------//

	@POST("signup")
	fun loginUser(@Body userLogin: UserLogin): Call<Token>

	@POST("client")
	fun saveUserRegister(@Body register: UserInfos): Call<UserByIdInfos>

	@POST("veterinary")
	fun saveUserRegisterVet(@Body registerVet: UserRegister): Call<PostUserVetResponse>

	@POST("pet") // Pets User
	fun postPetUser(@Header("Authorization") token: String, @Query("userID") userId: Int): Call<Pet>

//-------------------------------------------------------GET-------------------------------------------------------------------//
	@GET("auth")
  fun validationUser(@Header("Authorization") token: String): Call<ResponseValidUser>

	@GET("client") // User Default
	fun getUserById(@Query("userID") userId: Number): Call<ApiUserByIdResponse>

	@GET("user") // User Veterinary
	fun getUserVetById(@Query("userID") userId: Number): Call<UserRegister>

//	@GET("pet/all") // Pets User
//	fun getAllPetsUser(@Query("userId") userId: Int): Call<List<PetsCard>>
	@GET("pet/all") // Pets User
	fun getAllPetsUser(@Query("userID") userId: Int): Call<ApiAllPetResponse>
	@GET("pet") // Pets User by ID
	fun getPetUserById(@Query("petID") petId: Int): Call<Pet>

//-------------------------------------------------------PUT-------------------------------------------------------------------//
	@PUT("address")
	fun putUserLocation(@Query("addressId") addressId: Number, @Body userAddress: Address): Call<String>
	@PUT("pet") // Pets User
	fun putPetUser(@Header("Authorization") token: String, @Query("petID") petID: Int): Call<Pet>

//-------------------------------------------------------DELETE-------------------------------------------------------------------//

	@DELETE("pet") // Pets User
	fun deletePetUser(@Header("Authorization") token: String, @Query("petID") petID: Int): Call<Boolean>
}