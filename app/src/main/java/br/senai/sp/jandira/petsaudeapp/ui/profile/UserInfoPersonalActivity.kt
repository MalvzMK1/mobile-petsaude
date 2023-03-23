package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Remove
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
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
					modifier = Modifier
						.fillMaxSize()
						.verticalScroll(rememberScrollState()),
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
		ConfigHeader(headline = stringResource(id = R.string.user_config_personal_information))
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

	var idCardState = ""
	var isErrorIdCardState by rememberSaveable {
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
			.fillMaxSize(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Spacer(modifier = Modifier.height(10.dp))

		//----- FOTO DE CAPA -----//
		Text(
			text = stringResource(id = R.string.user_config_cover_photo),
			modifier = Modifier.fillMaxWidth(),
			fontSize = 16.sp,
			fontWeight = FontWeight.Bold,
			textAlign = TextAlign.Start
		)
		Spacer(modifier = Modifier.height(5.dp))
		Card(
			modifier = Modifier
				.fillMaxWidth()
				.padding(start = 50.dp, end = 50.dp, top = 8.dp, bottom = 8.dp)
				.height(100.dp),
			shape = RoundedCornerShape(8.dp),
			elevation = 2.dp
		) {

			//---------- INSERIR FOTO DE CAPA ----------//

		}
		Spacer(modifier = Modifier.height(5.dp))
		Row {
			Button(
				onClick = {
					//---------- IMPLEMENTAR O DELETE DA FOTO ----------//
				},
				modifier = Modifier
					.width(110.dp)
					.height(45.dp),
				shape = RoundedCornerShape(100.dp),
				border = BorderStroke(0.8.dp, Color(65,14,11)),
				colors = ButtonDefaults.buttonColors(Color(249,222,220))
			) {
				Row(
					modifier = Modifier
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceAround,
					verticalAlignment = Alignment.CenterVertically
				) {
					Icon(
						imageVector = Icons.Filled.Delete,
						contentDescription = "Delete",
						modifier = Modifier.size(18.dp),
						tint = Color(65,14,11)
					)
					Text(
						text = stringResource(id = R.string.user_config_delete_photo),
						color = Color(65,14,11),
						fontSize = 14.sp,
						fontWeight = FontWeight.W500
					)
				}
			}
		}
		Spacer(modifier = Modifier.height(10.dp))

		//----- FOTO DE PERFIL -----//
		Text(
			text = stringResource(id = R.string.user_config_profile_picture),
			modifier = Modifier.fillMaxWidth(),
			fontSize = 16.sp,
			fontWeight = FontWeight.Bold,
			textAlign = TextAlign.Start
		)
		Spacer(modifier = Modifier.height(5.dp))
		Card(
			modifier = Modifier
				.padding(start = 50.dp, end = 50.dp, top = 8.dp, bottom = 8.dp)
				.width(90.dp)
				.height(90.dp),
			shape = RoundedCornerShape(45.dp),
			elevation = 2.dp
		) {

			//---------- INSERIR FOTO DE PERFIL ----------//

		}
		Spacer(modifier = Modifier.height(5.dp))
		Row {
			Button(
				onClick = {
					//----------- IMPLEMENTAR O DELETE DA FOTO ----------//
				},
				modifier = Modifier
					.width(110.dp)
					.height(45.dp),
				shape = RoundedCornerShape(100.dp),
				border = BorderStroke(0.8.dp, Color(65,14,11)),
				colors = ButtonDefaults.buttonColors(Color(249,222,220))
			) {
				Row(
					modifier = Modifier
						.fillMaxWidth(),
					horizontalArrangement = Arrangement.SpaceAround,
					verticalAlignment = Alignment.CenterVertically
				) {
					Icon(
						imageVector = Icons.Filled.Delete,
						contentDescription = "Delete",
						modifier = Modifier.size(18.dp),
						tint = Color(65,14,11)
					)
					Text(
						text = stringResource(id = R.string.user_config_delete_photo),
						color = Color(65,14,11),
						fontSize = 14.sp,
						fontWeight = FontWeight.W500
					)
				}
			}
		}
		Spacer(modifier = Modifier.height(10.dp))

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

		//---- RG (CRIAR MASCARA) ----//
		idCardState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.user_config_rg_id_card),
			type = KeyboardType.Text,
			errorState = isErrorIdCardState
		)

		//----- CPF (CRIAR MASCARA) -----//
		itpState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.itp_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorItpState
		)
		
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