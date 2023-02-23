package br.senai.sp.jandira.petsaudeapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					Global()
				}
			}
		}
	}
}

@Composable
fun Global() {
	LoginHeader()
}

@Composable
fun LoginHeader() {
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 32.dp),
			verticalArrangement = Arrangement.SpaceBetween,
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			AuthHeaderTitle(title = "Bem vindo de volta!", subtitle = "Por favor, insira suas informações abaixo")
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
	PetSaudeAppTheme {
		Global()
	}
}