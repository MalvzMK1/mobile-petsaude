package br.senai.sp.jandira.petsaudeapp.service.integrations.pet

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.ApiAllPetResponse
import br.senai.sp.jandira.petsaudeapp.model.Pet
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//////// READ - PetsUser ////////
fun getAllPetsUser(userId: Int, onComplete: (ApiAllPetResponse) -> Unit) {
	val call = RetrofitFactory().retrofitService().getAllPetsUser(userId)

	call.enqueue(object : Callback<ApiAllPetResponse>{
		override fun onResponse(call: Call<ApiAllPetResponse>, response: Response<ApiAllPetResponse>) {
			Log.i("RESPONSE SUCCESS - READ PET USER", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<ApiAllPetResponse>, t: Throwable) {
			Log.i("RESPONSE ERROR - READ PET USER", t.message.toString())
		}
	})
}
fun getPetUserById (petId: Int, onComplete: (Pet) -> Unit) {
	val call = RetrofitFactory().retrofitService().getPetUserById(petId)

	call.enqueue(object : Callback<Pet>{
		override fun onResponse(call: Call<Pet>, response: Response<Pet>) {
			Log.i("RESPONSE SUCCESS - READ by ID PET USER", response.body().toString())
		}

		override fun onFailure(call: Call<Pet>, t: Throwable) {
			Log.i("RESPONSE ERROR - READ by ID PET USER", t.message.toString())
		}
	})
}
//////// INSERT - PetsUser ////////
fun postPetUser(token: String, userId: Int, onComplete: (Pet) -> Unit){
	val call = RetrofitFactory().retrofitService().postPetUser(token, userId)

	call.enqueue(object : Callback<Pet> {
		override fun onResponse(call: Call<Pet>, response: Response<Pet>) {
			Log.i("RESPONSE SUCCESS - POST PET USER", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<Pet>, t: Throwable) {
			Log.i("RESPONSE ERROR - POST PET USER", t.message.toString())
		}
	})
}
//////// UPDATE - PetsUser ////////
fun putPetUser(token: String, petId: Int, onComplete: (Pet) -> Unit) {
	val call = RetrofitFactory().retrofitService().putPetUser(token, petId)

	call.enqueue(object : Callback<Pet> {
		override fun onResponse(call: Call<Pet>, response: Response<Pet>) {
			Log.i("RESPONSE SUCCESS - PUT PET USER", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<Pet>, t: Throwable) {
			Log.i("RESPONSE ERROR - PUT PET USER", t.message.toString())
		}
	})
}
//////// DELETE - PetUser ////////
fun deletePetUser(token: String, petId: Int, onComplete: (Boolean) -> Unit) {
	val call = RetrofitFactory().retrofitService().deletePetUser(token, petId)

	call.enqueue(object : Callback<Boolean> {
		override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
			Log.i("RESPONSE SUCCESS - DELETE PET USER", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<Boolean>, t: Throwable) {
			Log.i("RESPONSE ERROR - DELETE PET USER", t.message.toString())
		}
	})
}
