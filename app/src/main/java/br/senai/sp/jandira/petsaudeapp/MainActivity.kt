package br.senai.sp.jandira.petsaudeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.components.AuthHeaderTitle
import br.senai.sp.jandira.petsaudeapp.components.BottomMessage
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

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
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp),
		verticalArrangement = Arrangement.SpaceEvenly
	) {
		LoginHeader()
		LoginForm()
		BottomMessage(
			message = "${stringResource(id = R.string.dont_have_account_bottom_message)} ",
			clickable = stringResource(id = R.string.register_yourself_bottom_message)
		)
	}
}

@Composable
fun LoginHeader() {

	Column(
		modifier = Modifier
			.fillMaxWidth(),
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
//					Toast.makeText(context, "Button Click", Toast.LENGTH_SHORT).show()
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
	// TEST ONLY
	//val context = LocalContext.current

	val customColors = TextFieldDefaults.textFieldColors(
		textColor = Color.Black,
		disabledTextColor = Color.Black,
		backgroundColor = Color.Transparent,
		cursorColor = Color.Black,
		errorCursorColor = Color.Red,
		focusedIndicatorColor = MaterialTheme.colors.primaryVariant,
		unfocusedIndicatorColor = Color.Black,
		disabledIndicatorColor = Color.Black,
		errorIndicatorColor = Color.Red,
		focusedLabelColor = MaterialTheme.colors.primary,
		unfocusedLabelColor = Color.Black,
		disabledLabelColor = Color.Black,
		trailingIconColor = Color.Black,
		placeholderColor = Color.Black
	)

	var emailState by rememberSaveable {
		mutableStateOf("")
	}

	var passwordState by rememberSaveable {
		mutableStateOf("")
	}

	var isPasswordVisible by rememberSaveable {
		mutableStateOf(false)
	}

	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 32.dp)
	) {
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.background(Color.Transparent),
		) {
			TextField(
				value = emailState,
				onValueChange = {
					emailState = it
				},
				modifier = Modifier
					.fillMaxWidth(),
				label = { Text(text = stringResource(id = R.string.email)) },
				colors = customColors
			)
		}
		Spacer(Modifier.height(16.dp))
		Column() {
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.background(Color.Transparent),
			) {
				TextField(
					value = passwordState,
					onValueChange = {
						passwordState = it
					},
					visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
					modifier = Modifier
						.fillMaxWidth(),
					label = { Text(text = stringResource(id = R.string.password)) },
					trailingIcon = {
						val image = if (isPasswordVisible)
							Icons.Filled.Visibility
						else Icons.Filled.VisibilityOff

						val description = if (isPasswordVisible) stringResource(id = R.string.hide_pass_alt) else stringResource(id = R.string.show_pass_alt)

						IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
							Icon(
								imageVector = image,
								contentDescription = description
							)
						}
					},
					keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
					colors = customColors
				)
			}
		}
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
				fontSize = 12.sp,
				fontWeight = FontWeight.Bold,
			)
		}
		Spacer(Modifier.height(32.dp))
		Button(
			onClick = {
//				TODO: USER LOGIN
//					Toast.makeText(context, "$emailState, $passwordState", Toast.LENGTH_SHORT).show()
			},
			modifier = Modifier.fillMaxWidth(),
			shape = RoundedCornerShape(size = 5.dp),
			colors = ButtonDefaults.buttonColors(Color(9, 115, 138))
		) {
			Text(
				text = stringResource(id = R.string.login_submit_button_text),
				fontSize = 24.sp,
				fontWeight = FontWeight.Bold,
				color = Color.White
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
