package br.senai.sp.jandira.petsaudeapp.model

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.senai.sp.jandira.petsaudeapp.service.integrations.login.loginUser
import kotlinx.coroutines.launch

//class PetSaudeViewModel : ViewModel() {
//	private var myData by mutableStateOf("")
//
//	fun fetchData(email: String, password: String) {
//		viewModelScope.launch {
//			val token = loginUser(email, password) {
//				myData.value = it
//			}
//		}
//	}
//}