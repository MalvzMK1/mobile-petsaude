package br.senai.sp.jandira.petsaudeapp.ui.authentication

import android.content.Intent
import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
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
import androidx.core.content.ContextCompat.startActivity
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.AuthHeaderTitle
import br.senai.sp.jandira.petsaudeapp.components.MaskedZipCodeInput
import br.senai.sp.jandira.petsaudeapp.components.TextFieldAddressInput
import br.senai.sp.jandira.petsaudeapp.components.TextFieldInput
import br.senai.sp.jandira.petsaudeapp.model.Address
import br.senai.sp.jandira.petsaudeapp.model.UserDefault
import br.senai.sp.jandira.petsaudeapp.model.UserInfos
import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import br.senai.sp.jandira.petsaudeapp.service.integrations.saveUserRegister
import br.senai.sp.jandira.petsaudeapp.service.viacep.getAddressByZipCode
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import br.senai.sp.jandira.petsaudeapp.utils.validateEmptyInput
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class RegisterAddressActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {

		val userInfos: UserDefault = intent.getSerializableExtra("userInfosRegister") as UserDefault
//		val userInfos = UserInfos(
//			"",
//			"",
//			"",
//			"",
//			"",
//			""
//		)

		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				Surface(
					modifier = Modifier
						.fillMaxSize()
						.verticalScroll(rememberScrollState()),
					color = MaterialTheme.colors.background
				)
				{
					GlobalLocalization(userInfos)
				}
			}
		}
	}
}

@Composable
fun GlobalLocalization(userInfos: UserDefault) {
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp),
		verticalArrangement = Arrangement.SpaceEvenly
	) {
		LocalizationHeader()
		LocalizationForm(userInfos)
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 32.dp),
			contentAlignment = Alignment.BottomCenter
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center,
			) {
				Text(
					text = "${stringResource(id = R.string.already_have_account_bottom_message)} ",
					fontSize = 14.sp,
					fontWeight = FontWeight.Normal,
					color = MaterialTheme.colors.onBackground
				)
				Text(
					text = stringResource(id = R.string.login_bottom_message),
					modifier = Modifier.clickable {
						val openRegisterActivity = Intent(context, RegisterActivity::class.java)
						startActivity(context, openRegisterActivity, null)
					},
					fontSize = 14.sp,
					fontWeight = FontWeight.Bold,
					color = MaterialTheme.colors.onBackground
				)
			}
		}
	}
}

@Composable
fun LocalizationHeader() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 32.dp),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		AuthHeaderTitle(
			title = stringResource(id = R.string.can_we_know_address_register_header),
			subtitle = stringResource(id = R.string.message_address_register_header)
		)
		Spacer(modifier = Modifier.height(32.dp))
	}
}

@Composable
fun LocalizationForm(userInfos: UserDefault) {
	val context = LocalContext.current

	var zipCodeState = ""
	var isErrorZipCodeState by rememberSaveable {
		mutableStateOf(false)
	}

	var cityState = "ice city"
	var cityStateValue by rememberSaveable {
		mutableStateOf("")
	}
	var isErrorCityState by rememberSaveable {
		mutableStateOf(false)
	}

	var stateState = "god state"
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
		modifier = Modifier.fillMaxWidth()
	) {
		zipCodeState = MaskedZipCodeInput(
			label = stringResource(id = R.string.zip_code_string_resource),
			errorState = isErrorZipCodeState,
			onFocusChange = { getAddressByZipCode(zipCodeState) {
					cityStateValue = it.city
					stateStateValue = it.state
					streetStateValue = it.street
					neighborhoodStateValue = it.neighborhood
				}
			}
		)
	}
	Spacer(Modifier.height(16.dp))
	cityState = TextFieldAddressInput(
		textPut = cityStateValue,
		label = stringResource(id = R.string.city_string_resource),
		type = KeyboardType.Text,
		errorState = isErrorCityState
	)
	Spacer(Modifier.height(16.dp))
	stateState = TextFieldAddressInput(
		textPut = stateStateValue,
		label = stringResource(id = R.string.state_string_resource),
		type = KeyboardType.Text,
		errorState = isErrorStateState
	)
	Spacer(Modifier.height(16.dp))
	streetState = TextFieldAddressInput(
		textPut = streetStateValue,
		label = stringResource(id = R.string.street_string_resource),
		type = KeyboardType.Text,
		errorState = isErrorStreetState
	)
	Spacer(Modifier.height(16.dp))
	neighborhoodState = TextFieldAddressInput(
		textPut = neighborhoodStateValue,
		label = stringResource(id = R.string.neighborhood_string_resource),
		type = KeyboardType.Text,
		errorState = isErrorNeighborhoodState
	)
	Spacer(Modifier.height(16.dp))
	numberState = TextFieldInput(
		label = stringResource(id = R.string.house_number_string_resource),
		type = KeyboardType.Text,
		errorState = isErrorNumberState
	)
	Spacer(Modifier.height(16.dp))
	complementState = TextFieldInput(
		label = stringResource(id = R.string.complement_string_resource),
		type = KeyboardType.Text,
		errorState = false
	)
	Spacer(Modifier.height(32.dp))
	Row(
		modifier = Modifier.padding(bottom = 32.dp),
		horizontalArrangement = Arrangement.SpaceBetween
	) {
//		val userInfosNow = userInfos
		Button(
			onClick = {
				isErrorZipCodeState = validateEmptyInput(zipCodeState)
				isErrorCityState = validateEmptyInput(cityStateValue)
				isErrorStateState = validateEmptyInput(stateStateValue)
				isErrorStreetState = validateEmptyInput(streetStateValue)
				isErrorNeighborhoodState = validateEmptyInput(neighborhoodStateValue)
				isErrorNumberState = validateEmptyInput(numberState)

				if (
					isErrorZipCodeState ||
					isErrorCityState ||
					isErrorStateState ||
					isErrorStreetState ||
					isErrorNeighborhoodState ||
					isErrorNumberState
				) {
					Toast.makeText(context, "Campos obrigatórios não preenchidos!", Toast.LENGTH_SHORT).show()
				} else {
					val userAddress = Address(
						zipCode = zipCodeState,
						city = cityStateValue,
						state = stateStateValue,
						street = streetStateValue,
						neighborhood = neighborhoodStateValue,
						number = numberState,
						complement = complementState
					)
					val userRegister = UserInfos(
						name = userInfos.name,
						itp = userInfos.itp,
						email = userInfos.email,
						password = userInfos.password,
						cellphoneNumber = userInfos.cellphoneNumber,
						phoneNumber = userInfos.phoneNumber,
						address = userAddress
					)
					// TODO: CADASTRO DE USUÁRIO PADRÃO - ****CONCLUIDO****
					val responseSaveUser = saveUserRegister(userRegister) {
						Log.i("SAVE USER", it.toString())
					}
					Log.i("responseSaveUser", responseSaveUser.toString())
					val openMainActivity = Intent(context, MainActivity::class.java)
					startActivity(context, openMainActivity, null)
				}
			},
			modifier = Modifier
				.fillMaxWidth(0.5f)
				.defaultMinSize(minHeight = 50.dp),
			shape = RoundedCornerShape(size = 5.dp),
			colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
		) {
			Text(
				text = stringResource(id = R.string.im_client_button_string),
				fontSize = 18.sp,
				fontWeight = FontWeight.Bold,
				color = MaterialTheme.colors.onSecondary
			)
		}
		Spacer(Modifier.width(4.dp))
		Button(
			onClick = {
				val userAddress = Address(
					zipCode = zipCodeState,
					city = cityStateValue,
					state = stateStateValue,
					street = streetStateValue,
					neighborhood = neighborhoodStateValue,
					number = numberState,
					complement = complementState
				)
				val userRegister = UserInfos(
					name = userInfos.name,
					itp = userInfos.itp,
					email = userInfos.email,
					password = userInfos.password,
					cellphoneNumber = userInfos.cellphoneNumber,
					phoneNumber = userInfos.phoneNumber,
					address = userAddress
				)
				val openProfessionalRegisterActivity = Intent(context, ProfessionalRegisterActivity::class.java)
				openProfessionalRegisterActivity.putExtra("userInfos", userRegister)
				startActivity(context, openProfessionalRegisterActivity, null)
			},
			modifier = Modifier
				.fillMaxWidth()
				.defaultMinSize(minHeight = 50.dp),
			shape = RoundedCornerShape(size = 5.dp),
			colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
		) {
			Text(
				text = stringResource(id = R.string.im_professional_button_string),
				color = MaterialTheme.colors.onSecondary,
				fontSize = 18.sp,
				fontWeight = FontWeight.Bold,
				textAlign = TextAlign.Center
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
	PetSaudeAppTheme {
//		GlobalLocalization(
//			userInfos = UserInfos(
//				"",
//				"",
//				"",
//				"",
//				"",
//				""
//			)
//		)
	}
}