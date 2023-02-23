package br.senai.sp.jandira.petsaudeapp

import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
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
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

class MainActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				Surface(
					modifier = Modifier
						.fillMaxSize()
						.padding(12.dp),
					color = MaterialTheme.colors.background
				) {
					Global()
				}
			}
		}
	}
}

@Composable
fun RegisterMessage() {
	// TEST ONLY
	val context = LocalContext.current

	Box(
		modifier = Modifier.fillMaxWidth().padding(top = 100.dp),
		contentAlignment = Alignment.BottomCenter
	) {
		Row(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Center,
		) {
			Text(
				text = "Ainda não tem uma conta? ",
				fontSize = 14.sp,
				fontWeight = FontWeight.Normal,
				color = Color.Black
			)
			Text(
				text = "Cadastre-se",
				modifier = Modifier.clickable(onClick = {
					Toast.makeText(context, "Deu certo!", Toast.LENGTH_SHORT).show()
				}),
				fontSize = 14.sp,
				fontWeight = FontWeight.Bold,
				color = Color.Black
			)
		}
	}
}

@Composable
fun Global() {
	Column(
		modifier = Modifier.fillMaxSize(),
		verticalArrangement = Arrangement.SpaceEvenly
	) {
		LoginHeader()
		LoginForm()
		RegisterMessage()
	}
}

@Composable
fun LoginHeader() {
	val context = LocalContext.current

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
				title = "Bem vindo de volta!",
				subtitle = "Por favor, insira suas informações abaixo"
			)
			Spacer(modifier = Modifier.height(32.dp))
			Button(
				onClick = {
//				TODO: FIREBASE AUTHENTICATION
					Toast.makeText(context, "Button Click", Toast.LENGTH_SHORT).show()
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
fun LoginForm() {
	// TEST ONLY
	val context = LocalContext.current

	val customColors = TextFieldDefaults.textFieldColors(
		backgroundColor = Color.Transparent
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
				.border(BorderStroke(1.dp, Color.Black), shape = MaterialTheme.shapes.small)
				.background(Color.Transparent),
		) {
			TextField(
				value = emailState,
				onValueChange = {
					emailState = it
				},
				modifier = Modifier
					.fillMaxWidth(),
				label = { Text(text = "E-mail") },
				colors = customColors
			)
		}
		Spacer(Modifier.height(16.dp))
		Column() {
			Box(
				modifier = Modifier
					.fillMaxWidth()
					.border(BorderStroke(1.dp, Color.Black), shape = MaterialTheme.shapes.small)
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
			}
		}
		Box(
			modifier = Modifier.fillMaxWidth(),
			contentAlignment = Alignment.CenterEnd
		) {
			Text(
				text = "Esqueceu a senha?",
				modifier = Modifier
					.clickable(onClick = {
						//TODO: GO TO PASSWORD RECOVER PAGE
					}),
				fontSize = 12.sp,
				fontWeight = FontWeight.Bold,
			)
		}
		Spacer(Modifier.height(32.dp))
		Button(
			onClick = {
				Toast.makeText(context, "$emailState, $passwordState", Toast.LENGTH_SHORT).show()
				// TODO: USER LOGIN
			},
			modifier = Modifier.fillMaxWidth(),
			shape = RoundedCornerShape(size = 5.dp),
			colors = ButtonDefaults.buttonColors(Color(9, 115, 138))
		) {
			Text(
				text = "Entrar",
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
		Global()
	}
}
