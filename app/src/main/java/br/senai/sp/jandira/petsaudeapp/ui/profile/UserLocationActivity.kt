package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
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
import br.senai.sp.jandira.petsaudeapp.model.Address
import br.senai.sp.jandira.petsaudeapp.service.viacep.getAddressByZipCode
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import br.senai.sp.jandira.petsaudeapp.utils.validateEmptyInput

class UserLocationActivity : ComponentActivity() {
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
					GlobalUserLocation(this)
				}
			}
		}
	}
}

@Composable
fun GlobalUserLocation(context: Context) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		ConfigHeader(
			headline = stringResource(id = R.string.user_config_location),
			context,
			icon = Icons.Filled.Settings
		)
		UserLocation()
	}
}

@Composable
fun UserLocation() {
	val context = LocalContext.current

	var zipCodeState = ""
	var isErrorZipCodeState by rememberSaveable {
		mutableStateOf(false)
	}

	var cityState = ""
	var cityStateValue by rememberSaveable {
		mutableStateOf("")
	}
	var isErrorCityState by rememberSaveable {
		mutableStateOf(false)
	}

	var stateState = ""
	var stateStateValue by rememberSaveable {
		mutableStateOf("")
	}
	var isErrorStateState by rememberSaveable {
		mutableStateOf(false)
	}

	var streetState = ""
	var streetStateValue by rememberSaveable {
		mutableStateOf("")
	}
	var isErrorStreetState by rememberSaveable {
		mutableStateOf(false)
	}

	var neighborhoodState = ""
	var neighborhoodStateValue by rememberSaveable {
		mutableStateOf("")
	}
	var isErrorNeighborhoodState by rememberSaveable {
		mutableStateOf(false)
	}

	var numberState = ""
	var isErrorNumberState by rememberSaveable {
		mutableStateOf(false)
	}

	var complementState = ""
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		zipCodeState = MaskedZipCodeOutlinedInput(
			label = stringResource(id = R.string.zip_code_string_resource),
			errorState = isErrorZipCodeState,
			onFocusChange = {
				getAddressByZipCode(zipCodeState) {
					cityStateValue = it.city
					stateStateValue = it.state
					streetStateValue = it.street
					neighborhoodStateValue = it.neighborhood
				}
			}
		)
		cityState = OutlinedTextFieldAddressInput(
			textPut = cityStateValue,
			label = stringResource(id = R.string.city_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorCityState
		)
		stateState = OutlinedTextFieldAddressInput(
			textPut = stateStateValue,
			label = stringResource(id = R.string.state_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorStateState
		)
		streetState = OutlinedTextFieldAddressInput(
			textPut = streetStateValue,
			label = stringResource(id = R.string.street_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorStreetState
		)
		neighborhoodState = OutlinedTextFieldAddressInput(
			textPut = neighborhoodStateValue,
			label = stringResource(id = R.string.neighborhood_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorNeighborhoodState
		)
		numberState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.house_number_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorNumberState
		)
		complementState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.complement_string_resource),
			type = KeyboardType.Text,
			errorState = false
		)
		Spacer(modifier = Modifier.height(24.dp))
		Button(
			onClick = {
				isErrorZipCodeState = validateEmptyInput(zipCodeState)
				isErrorCityState = validateEmptyInput(cityState)
				isErrorStateState = validateEmptyInput(stateState)
				isErrorStreetState = validateEmptyInput(streetState)
				isErrorNeighborhoodState = validateEmptyInput(neighborhoodState)
				isErrorNumberState = validateEmptyInput(numberState)

				if (
					isErrorZipCodeState ||
					isErrorCityState ||
					isErrorStateState ||
					isErrorStreetState ||
					isErrorNeighborhoodState ||
					isErrorNumberState
				) {
					Toast.makeText(context, "Campos vazios!", Toast.LENGTH_SHORT).show()
				} else {
					val userAddress = Address(
						cep = zipCodeState,
						city = cityStateValue,
						state = stateStateValue,
						street = streetStateValue,
						neighborhood = neighborhoodStateValue,
						number = numberState,
						complement = complementState
					)
//					val responsePutUserLocation = PutUserLocation(addressId, userAddress) {
//						Log.i("PUT USER LOCATION", it.toString())
//					}
//					Toast.makeText(context, "Dados de endereço atualizado com com sucesso", Toast.LENGTH_SHORT).show()
				}
			},
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
	fun DefaultPreview8() {
		PetSaudeAppTheme {
			GlobalUserLocation(LocalContext.current)
		}
	}