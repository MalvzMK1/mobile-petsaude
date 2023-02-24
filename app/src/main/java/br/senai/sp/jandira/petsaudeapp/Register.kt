package br.senai.sp.jandira.petsaudeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

class Register : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
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
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp),
		verticalArrangement = Arrangement.SpaceEvenly
	) {
		RegisterHeader()
		RegisterForm()
		BottomMessage(
			message = "Já tem uma conta? ",
			clickable = "Faça login"
		)
	}
}

@Composable
fun RegisterHeader() {
	Column(
		modifier = Modifier.fillMaxWidth(),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Column(
			modifier = Modifier.fillMaxWidth(),
			verticalArrangement = Arrangement.SpaceBetween,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			AuthHeaderTitle(
				title = "É novo por aqui?",
				subtitle = "Insira suas informações abaixo e cadastre-se!"
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
					text = "Ou use o e-mail",
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
	val customColors = TextFieldDefaults.textFieldColors(
		backgroundColor = Color.Transparent
	)

	var nameState by rememberSaveable() {
		mutableStateOf("")
	}

	var lastnameState by rememberSaveable() {
		mutableStateOf("")
	}

	var emailState by rememberSaveable {
		mutableStateOf("")
	}

	var passwordState by rememberSaveable {
		mutableStateOf("")
	}

	var checkPassState by rememberSaveable() {
		mutableStateOf("")
	}

	var cellphoneNumberState by rememberSaveable() {
		mutableStateOf("")
	}

	var phoneNumberState by rememberSaveable() {
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
		TextField(
			value = nameState,
			onValueChange = {
				nameState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Nome") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = lastnameState,
			onValueChange = {
				lastnameState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Sobrenome") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = emailState,
			onValueChange = {
				emailState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "E-mail") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = passwordState,
			onValueChange = {
				passwordState = it
			},
			visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
			modifier = Modifier
				.fillMaxWidth(),
			label = { Text(text = "Senha") },
			trailingIcon = {
				val image = if (isPasswordVisible)
					Icons.Filled.Visibility
				else Icons.Filled.VisibilityOff

				val description = if (isPasswordVisible) "Esconder Senha" else "Mostrar senha"

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
		Spacer(Modifier.height(16.dp))
		TextField(
			value = checkPassState,
			onValueChange = {
				checkPassState = it
			},
			visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
			modifier = Modifier
				.fillMaxWidth(),
			label = { Text(text = "Confirme sua senha") },
			trailingIcon = {
				val image = if (isPasswordVisible)
					Icons.Filled.Visibility
				else Icons.Filled.VisibilityOff

				val description = if (isPasswordVisible) "Esconder Senha" else "Mostrar senha"

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
		Spacer(Modifier.height(16.dp))
		TextField(
			value = cellphoneNumberState,
			onValueChange = {
				cellphoneNumberState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Celular") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = phoneNumberState,
			onValueChange = {
				phoneNumberState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Telefone") },
			colors = customColors
		)
		Spacer(Modifier.height(32.dp))
		Button(
			onClick = {
				// TODO: USER LOGIN
			},
			modifier = Modifier.fillMaxWidth(),
			shape = RoundedCornerShape(size = 5.dp),
			colors = ButtonDefaults.buttonColors(Color(9, 115, 138))
		) {
			Text(
				text = "Continuar",
				fontSize = 24.sp,
				fontWeight = FontWeight.Bold,
				color = Color.White
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