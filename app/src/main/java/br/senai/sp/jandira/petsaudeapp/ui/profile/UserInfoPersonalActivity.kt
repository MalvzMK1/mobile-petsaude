package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.*
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

class UserInfoPersonalActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					GlobalUserPersonal()
				}
			}
		}
	}
}
@Composable
fun GlobalUserPersonal() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		UserConfigHeader(headline = stringResource(id = R.string.user_config_personal_information))
		PersonalPreferences()
	}
}
@Composable
fun PersonalPreferences() {
	val context = LocalContext.current

	var nameState = ""
	var isErrorNameState by rememberSaveable {
		mutableStateOf(false)
	}

	var lastNameState = ""
	var isErrorLastNameState by rememberSaveable {
		mutableStateOf(false)
	}

	var itpState = ""
	var isErrorItpState by rememberSaveable {
		mutableStateOf(false)
	}

	var cellphoneNumberState = ""
	var isErrorCellphoneNumberState by rememberSaveable {
		mutableStateOf(false)
	}

	var phoneNumberState = ""
	var isErrorPhoneNumberState by rememberSaveable {
		mutableStateOf(false)
	}


	Column(
		modifier = Modifier
			.fillMaxSize()
	) {
		Spacer(modifier = Modifier.height(12.dp))

		//----- FOTO DE CAPA -----//

		//----- FOTO DE PERFIL -----//

		nameState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.name_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorNameState
		)
		lastNameState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.last_name_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorLastNameState
		)

		//---- RG ----//

		//----- CPF -----//
		
		cellphoneNumberState = MaskedCellphoneNumberOutlinedInput(
			label = stringResource(id = R.string.cellphone_number_string_resource),
			errorState = isErrorCellphoneNumberState
		)
		phoneNumberState = MaskedPhoneNumberOutlinedInput(
			label = stringResource(id = R.string.phone_number_string_resource),
			errorState = isErrorPhoneNumberState 
		)
		Spacer(modifier = Modifier.height(24.dp))
		Button(
			onClick = { },
			modifier = Modifier
				.height(50.dp)
				.fillMaxWidth(),
			shape = RoundedCornerShape(100.dp),
			colors = ButtonDefaults.buttonColors(Color(158,209,183))
		) {
			Text(
				text = stringResource(id = R.string.user_config_save_edit_user),
				fontSize = 16.sp
			)
		}
	}
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview10() {
	PetSaudeAppTheme {
		GlobalUserPersonal()
	}
}