package br.senai.sp.jandira.petsaudeapp.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
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
import br.senai.sp.jandira.petsaudeapp.components.PasswordInputHideShowIcon
import br.senai.sp.jandira.petsaudeapp.components.TextFieldInput
import br.senai.sp.jandira.petsaudeapp.service.saveUserRegister
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import br.senai.sp.jandira.petsaudeapp.utils.validateEmptyInput

class RegisterActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				Surface(
					modifier = Modifier
						.fillMaxSize()
						.verticalScroll(rememberScrollState()),
					color = MaterialTheme.colors.background
				) {
					GlobalRegister()
				}
			}
		}
	}
}

@Composable
fun GlobalRegister() {
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp),
		verticalArrangement = Arrangement.SpaceEvenly
	) {
		RegisterHeader()
		RegisterForm()
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
					color = MaterialTheme.colors.onBackground,
					fontSize = 14.sp,
					fontWeight = FontWeight.Normal
				)
				Text(
					text = stringResource(id = R.string.login_bottom_message),
					modifier = Modifier.clickable {
						val openRegisterAddressActivity = Intent(context, MainActivity::class.java)
						startActivity(context, openRegisterAddressActivity, null)
					},
					color = MaterialTheme.colors.onBackground,
					fontSize = 14.sp,
					fontWeight = FontWeight.Bold
				)
			}
		}
	}
}

@Composable
fun RegisterHeader() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 32.dp),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Column(
			modifier = Modifier.fillMaxWidth(),
			verticalArrangement = Arrangement.SpaceBetween,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			AuthHeaderTitle(
				title = stringResource(id = R.string.are_you_new_signup_header),
				subtitle = stringResource(id = R.string.message_signup_header)
			)
			Spacer(modifier = Modifier.height(32.dp))
			Button(
				onClick = {
//				TODO: FIREBASE AUTHENTICATION
				},
				modifier = Modifier.size(60.dp),
				shape = RoundedCornerShape(50),
				colors = ButtonDefaults.buttonColors(Color.LightGray)
			) {
				Image(
					painter = painterResource(id = R.drawable.google_logo),
					contentDescription = "Google Logo",
					modifier = Modifier.fillMaxSize()
				)
			}
			Spacer(modifier = Modifier.height(32.dp))
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.Center,
				verticalAlignment = Alignment.CenterVertically
			) {
				Spacer(
					modifier = Modifier
						.height(1.dp)
						.width(100.dp)
						.background(color = Color.LightGray)
				)
				Text(
					text = stringResource(id = R.string.or_use_email),
					modifier = Modifier.padding(start = 10.dp, end = 10.dp),
					color = Color.LightGray,
					fontSize = 14.sp,
					fontWeight = FontWeight.Normal,
					textAlign = TextAlign.Center
				)
				Spacer(
					modifier = Modifier
						.height(1.dp)
						.width(100.dp)
						.background(color = Color.LightGray)
				)
			}
		}
	}
}

@Composable
fun RegisterForm() {
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

	var emailState = ""
	var isErrorEmailState by rememberSaveable {
		mutableStateOf(false)
	}

	var passwordState = ""
	var isErrorPasswordState by rememberSaveable {
		mutableStateOf(false)
	}

	var checkPassState = ""
	var isErrorCheckPasswordState by rememberSaveable {
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

	var userSaveRegister by rememberSaveable { mutableStateOf("") }

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 32.dp)
	) {
		nameState = TextFieldInput(
			label = stringResource(id = R.string.name_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorNameState
		)
		Spacer(Modifier.height(16.dp))
		lastNameState = TextFieldInput(
			label = stringResource(id = R.string.last_name_string_resource),
			type = KeyboardType.Text,
			errorState = isErrorLastNameState
		)
		Spacer(Modifier.height(16.dp))
		itpState = TextFieldInput(
			label = stringResource(id = R.string.itp_string_resource),
			type = KeyboardType.Number,
			errorState = isErrorItpState
		)
		Spacer(Modifier.height(16.dp))
		emailState = TextFieldInput(
			label = stringResource(id = R.string.email_string_resource),
			type = KeyboardType.Email,
			errorState = isErrorEmailState
		)
		Spacer(Modifier.height(16.dp))
		passwordState = PasswordInputHideShowIcon(
			label = stringResource(id = R.string.password_string_resource),
			errorState = isErrorPasswordState
		)
		Spacer(Modifier.height(16.dp))
		checkPassState = PasswordInputHideShowIcon(
			label = stringResource(id = R.string.confirm_password_string_resource),
			errorState = isErrorCheckPasswordState
		)
		Spacer(Modifier.height(16.dp))
		cellphoneNumberState = TextFieldInput(
			label = stringResource(id = R.string.cellphone_number_string_resource),
			type = KeyboardType.Number,
			errorState = isErrorCellphoneNumberState
		)
		Spacer(Modifier.height(16.dp))
		phoneNumberState = TextFieldInput(
			label = stringResource(id = R.string.phone_number_string_resource),
			type = KeyboardType.Number,
			errorState = isErrorPhoneNumberState
		)
		Spacer(Modifier.height(32.dp))
		Button(
			onClick = {
				isErrorNameState = validateEmptyInput(nameState)
				isErrorLastNameState = validateEmptyInput(lastNameState)
				isErrorItpState = validateEmptyInput(itpState)
				isErrorEmailState = validateEmptyInput(emailState)
				isErrorPasswordState = validateEmptyInput(passwordState)
				isErrorCheckPasswordState = validateEmptyInput(checkPassState)
				isErrorCellphoneNumberState = validateEmptyInput(cellphoneNumberState)
				isErrorPhoneNumberState = validateEmptyInput(phoneNumberState)

				if (
					isErrorNameState ||
					isErrorLastNameState ||
					isErrorItpState ||
					isErrorEmailState ||
					isErrorPasswordState ||
					isErrorCheckPasswordState ||
					isErrorCellphoneNumberState ||
					isErrorPhoneNumberState
				) {
					Toast.makeText(context, "Campos vazios", Toast.LENGTH_SHORT).show()
				} else {
					if (checkPassState == passwordState) {
//						userSaveRegister = saveUserRegister(
//							nameState,
//							lastNameState,
//							itpState,
//							emailState,
//							passwordState,
//							cellphoneNumberState,
//							phoneNumberState
//						) { userSaveRegister = it }.toString()
//						if (userSaveRegister.isNotEmpty()) {
//							Log.i("DS3M", "USUÁRIO CRIADO COM SUCESSO, NOME: ${nameState}")
						val openRegisterAddressActivity = Intent(context, RegisterAddressActivity::class.java)
						startActivity(context, openRegisterAddressActivity, null)
//						}
					} else {
						Toast.makeText(context, "As senhas não batem", Toast.LENGTH_SHORT).show()
						isErrorCheckPasswordState = true
					}
				}
			},
			modifier = Modifier.fillMaxWidth(),
			shape = RoundedCornerShape(size = 5.dp),
			colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
		) {
			Text(
				text = stringResource(id = R.string.continue_string_resource),
				fontSize = 24.sp,
				fontWeight = FontWeight.Bold,
				color = MaterialTheme.colors.onSecondary
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview2() {
	PetSaudeAppTheme {
		GlobalRegister()
	}
}
