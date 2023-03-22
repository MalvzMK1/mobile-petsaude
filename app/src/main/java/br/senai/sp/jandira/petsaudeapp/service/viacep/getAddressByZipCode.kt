package br.senai.sp.jandira.petsaudeapp.service.viacep

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun getAddressByZipCode(zipCode: String, onComplete: (ViacepAddress) -> Unit): ViacepAddress {
	var address: ViacepAddress = ViacepAddress("", "", "", "", "")

	if (zipCode.length == 8) {
		val call = ViacepRetrofitFactory().retrofitService().getAddressByZipCode(zipCode = zipCode)

		call.enqueue(object: Callback<ViacepAddress> {
			override fun onResponse(call: Call<ViacepAddress>, response: Response<ViacepAddress>) {
				if (response.body() !== null) {
					address = response.body()!!
					onComplete.invoke(address)
				}
			}

			override fun onFailure(call: Call<ViacepAddress>, t: Throwable) {
				Log.i("ERROR", t.message.toString())
			}
		})
	}

	return address
}