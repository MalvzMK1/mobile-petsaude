package br.senai.sp.jandira.petsaudeapp.ui.authentication

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
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
import br.senai.sp.jandira.petsaudeapp.service.loginUser
import br.senai.sp.jandira.petsaudeapp.ui.HomePetActivity
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import br.senai.sp.jandira.petsaudeapp.utils.validateEmptyInput

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					GlobalLogin()
				}
			}
		}
	}
}
@Composable
fun GlobalLogin() {
	val context = LocalContext.current
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp),
		verticalArrangement = Arrangement.SpaceBetween
	) {
		LoginHeader()
		LoginForm()
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(bottom = 32.dp),
			contentAlignment = Alignment.BottomCenter
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center,
			) {
				Text(
					text = "${stringResource(id = R.string.dont_have_account_bottom_message)} ",
					fontSize = 14.sp,
					fontWeight = FontWeight.Normal,
					color = MaterialTheme.colors.onBackground
				)
				Text(
					text = stringResource(id = R.string.register_yourself_bottom_message),
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
fun LoginHeader() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 32.dp),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth(),
			verticalArrangement = Arrangement.SpaceBetween,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			AuthHeaderTitle(
				title = stringResource(id = R.string.welcome_back_login_header),
				subtitle = stringResource(id = R.string.insert_infos_login_header)
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
fun LoginForm() {
	val context = LocalContext.current
	var loginEmailState = ""
	var loginPasswordState = ""
	var loginState by rememberSaveable() { mutableStateOf("") }
	var isErrorEmailState by rememberSaveable { mutableStateOf(false) }
	var isErrorPasswordState by rememberSaveable { mutableStateOf(false) }
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 32.dp)
	) {
		loginEmailState = TextFieldInput(
			label = stringResource(id = R.string.email_string_resource),
			type = KeyboardType.Email,
			errorState = isErrorEmailState
		)
		Spacer(Modifier.height(16.dp))
		loginPasswordState =
			PasswordInputHideShowIcon(label = stringResource(id = R.string.password_string_resource), errorState = isErrorPasswordState)
		Box(
			modifier = Modifier.fillMaxWidth(),
			contentAlignment = Alignment.CenterEnd
		) {
			Text(
				text = stringResource(id = R.string.forgot_password),
				modifier = Modifier
					.clickable(onClick = {
//							TODO: GO TO PASSWORD RECOVER PAGE
					}),
				color = MaterialTheme.colors.onBackground,
				fontSize = 12.sp,
				fontWeight = FontWeight.Bold,
			)
		}
		Spacer(Modifier.height(32.dp))
		Button(
			onClick = {
				isErrorPasswordState = validateEmptyInput(loginPasswordState)
				isErrorEmailState = validateEmptyInput(loginEmailState)
				if (isErrorEmailState || isErrorPasswordState) {
					Toast.makeText(context, "Campos obrigatórios não informados", Toast.LENGTH_SHORT).show()
				} else {
					if (loginEmailState.indexOf("@") != -1) {
						loginState = loginUser(loginEmailState, loginPasswordState) {
							Log.i("DS", it)
							loginState = it
							if (loginState.isNotEmpty()) {
								val openHomePetActivity = Intent(context, HomePetActivity::class.java)
								startActivity(context, openHomePetActivity, null)
								Toast.makeText(context, "Seja Bem-Vindo!", Toast.LENGTH_SHORT).show()
							} else {
								isErrorEmailState = true
								isErrorPasswordState = true
								Toast.makeText(context, "Email ou Senha Incorretos!!!", Toast.LENGTH_SHORT).show()
							}
						}
					} else {
						Toast.makeText(context, "E-mail inválido", Toast.LENGTH_SHORT).show()
						isErrorEmailState = true
					}
				}
			},
			modifier = Modifier.fillMaxWidth(),
			shape = RoundedCornerShape(size = 5.dp),
			colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
		) {
			Text(
				text = stringResource(id = R.string.enter_string_resource),
				fontSize = 24.sp,
				fontWeight = FontWeight.Bold,
				color = MaterialTheme.colors.onSecondary
			)
		}
	}
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	PetSaudeAppTheme {
		GlobalLogin()
	}
}
