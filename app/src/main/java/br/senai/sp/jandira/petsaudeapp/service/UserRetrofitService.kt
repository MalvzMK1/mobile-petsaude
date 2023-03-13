package br.senai.sp.jandira.petsaudeapp.service

import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import retrofit2.http.Body
import retrofit2.http.POST

interface UserRetrofitService {
	// BASE-URL = "https://10.0.2.2:3333"
	@POST("user")
	fun saveUserRegister(@Body userRegister: UserRegister): Boolean
}