package br.senai.sp.jandira.petsaudeapp.service.integrations.pet

import android.util.Log
import br.senai.sp.jandira.petsaudeapp.model.Pets
import br.senai.sp.jandira.petsaudeapp.model.PetsCard
import br.senai.sp.jandira.petsaudeapp.service.RetrofitFactory
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//////// READ - PetsUser ////////
fun getAllPetsUser(userId: Int, onComplete: (List<PetsCard>) -> Unit) {
	Log.i("RESPONSE SUCCESS - ****userid**** READ PET USER", userId.toString())
	val call = RetrofitFactory().retrofitService().getAllPetsUser(userId)

	call.enqueue(object : Callback<List<PetsCard>>{
		override fun onResponse(call: Call<List<PetsCard>>, response: Response<List<PetsCard>>) {
			Log.i("RESPONSE SUCCESS - READ PET USER", response.body().toString())
			onComplete.invoke(response.body()!!)
		}

		override fun onFailure(call: Call<List<PetsCard>>, t: Throwable) {
			Log.i("RESPONSE ERROR - READ PET USER", t.message.toString())
		}
	})
}
fun getPetUserById (petId: Int, onComplete: (Pets) -> Unit) {
	val call = RetrofitFactory().retrofitService().getPetUserById(petId)

	call.enqueue(object : Callback<Pets>{
		override fun onResponse(call: Call<Pets>, response: Response<Pets>) {
			Log.i("RESPONSE SUCCESS - READ by ID PET USER", response.body().toString())
		}

		override fun onFailure(call: Call<Pets>, t: Throwable) {
			Log.i("RESPONSE ERROR - READ by ID PET USER", t.message.toString())
		}
	})
}
//////// INSERT - PetsUser ////////
fun postPetUser(token: String, userId: Int, onComplete: (Pets) -> Unit){
	val call = RetrofitFactory().retrofitService().postPetUser(token, userId)

	call.enqueue(object : Callback<Pets> {
		override fun onResponse(call: Call<Pets>, response: Response<Pets>) {
			Log.i("RESPONSE SUCCESS - POST PET USER", response.body().toString())
		}

		override fun onFailure(call: Call<Pets>, t: Throwable) {
			Log.i("RESPONSE ERROR - POST PET USER", t.message.toString())
		}
	})
}
//////// UPDATE - PetsUser ////////
fun putPetUser(token: String, petId: Int, onComplete: (Pets) -> Unit) {
	val call = RetrofitFactory().retrofitService().putPetUser(token, petId)

	call.enqueue(object : Callback<Pets> {
		override fun onResponse(call: Call<Pets>, response: Response<Pets>) {
			Log.i("RESPONSE SUCCESS - PUT PET USER", response.body().toString())
		}

		override fun onFailure(call: Call<Pets>, t: Throwable) {
			Log.i("RESPONSE ERROR - PUT PET USER", t.message.toString())
		}
	})
}
//////// DELETE - PetsUser ////////
fun deletePetUser(token: String, petId: Int, onComplete: (Boolean) -> Unit) {
	val call = RetrofitFactory().retrofitService().deletePetUser(token, petId)

	call.enqueue(object : Callback<Boolean> {
		override fun onResponse(call: Call<Boolean>, response: Response<Boolean>) {
			Log.i("RESPONSE SUCCESS - DELETE PET USER", response.body().toString())
		}

		override fun onFailure(call: Call<Boolean>, t: Throwable) {
			Log.i("RESPONSE ERROR - DELETE PET USER", t.message.toString())
		}
	})
}
