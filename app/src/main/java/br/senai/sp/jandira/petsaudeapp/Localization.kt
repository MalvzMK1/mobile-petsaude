package br.senai.sp.jandira.petsaudeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.components.AuthHeaderTitle
import br.senai.sp.jandira.petsaudeapp.components.BottomMessage
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

class Localization : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				)
				{
					GlobalLocalization()
				}
			}
		}
	}
}

@Composable
fun GlobalLocalization() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp),
		verticalArrangement = Arrangement.SpaceEvenly
	) {
		LocalizationHeader()
		LocalizationForm()
		BottomMessage(
			message = "Já tem uma conta? ",
			clickable = "Faça login"
		)
	}
}

@Composable
fun LocalizationHeader() {
	Column(
		modifier = Modifier.fillMaxWidth(),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		AuthHeaderTitle(
			title = "Podemos saber sua localização?",
			subtitle = "Para a experiência na plataforma, informe-nos a sua localização!"
		)
		Spacer(modifier = Modifier.height(32.dp))
	}
}

@Composable
fun LocalizationForm() {
	val customColors = TextFieldDefaults.textFieldColors(
		backgroundColor = Color.Transparent
	)

	var cepState by rememberSaveable() {
		mutableStateOf("")
	}

	var cityState by rememberSaveable() {
		mutableStateOf("")
	}

	var stateState by rememberSaveable() {
		mutableStateOf("")
	}

	var streetState by rememberSaveable() {
		mutableStateOf("")
	}

	var neighborhoodState by rememberSaveable() {
		mutableStateOf("")
	}

	var numberState by rememberSaveable() {
		mutableStateOf("")
	}

	var complementState by rememberSaveable() {
		mutableStateOf("")
	}

	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		TextField(
			value = cepState,
			onValueChange = {
				cepState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "CEP") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = cityState,
			onValueChange = {
				cityState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Cidade") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = stateState,
			onValueChange = {
				stateState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Estado") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = streetState,
			onValueChange = {
				streetState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Rua") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = neighborhoodState,
			onValueChange = {
				neighborhoodState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Bairro") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = numberState,
			onValueChange = {
				numberState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Número") },
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = complementState,
			onValueChange = {
				complementState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = "Complemento (se houver)") },
			colors = customColors
		)
		Spacer(Modifier.height(32.dp))
		Button(
			onClick = {
				// TODO: USER LOGIN
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(50.dp),
			shape = RoundedCornerShape(size = 5.dp),
			colors = ButtonDefaults.buttonColors(Color(9, 115, 138))
		) {
			Text(
				text = "Cadastre-se como Cliente",
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
				color = Color.White
			)
		}
		Spacer(Modifier.height(16.dp))
		Button(
			onClick = {
				// TODO: USER LOGIN
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(50.dp),
			shape = RoundedCornerShape(size = 5.dp),
			colors = ButtonDefaults.buttonColors(Color(9, 115, 138))
		) {
			Text(
				text = "Cadastre-se como Profissional",
				fontSize = 20.sp,
				fontWeight = FontWeight.Bold,
				color = Color.White,
				textAlign = TextAlign.Center
			)
		}
	}
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
	PetSaudeAppTheme {
		GlobalLocalization()
	}
}