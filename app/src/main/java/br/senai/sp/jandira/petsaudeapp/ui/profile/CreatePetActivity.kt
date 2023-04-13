package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.ConfigHeader
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

class CreatePetActivity : ComponentActivity() {
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
					GlobalCreatePet(this)
				}
			}
		}
	}
}
@Composable
fun GlobalCreatePet(context: Context) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		ConfigHeader(
			headline = stringResource(id = R.string.user_config_pets),
			context,
			icon = Icons.Filled.Settings
		)
		CardPet()
//		SettingPet()
		ResponsePet()
	}
}

@Composable
fun CardPet() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(12.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Card(
			modifier = Modifier
				.height(100.dp)
				.width(100.dp),
			shape = RoundedCornerShape(50)
		) {
			Image(
				//INTEGRACAO API COM A FOTO DO PET
				painter = painterResource(id = R.drawable.media),
				contentDescription = "FOTO DO PET",
				contentScale = ContentScale.Crop
			)
		}
		Spacer(modifier = Modifier.width(16.dp))
		Column(
			
		) {
			Text(
				text = "PET Name",
				fontSize = 24.sp,
				fontWeight = FontWeight.W400
			)
			Text(
				text = "Espécie",
				color = Color(169, 169, 169),
				fontSize = 20.sp,
				fontWeight = FontWeight.W500
			)
		}
	}
}

//@Composable
//fun SettingPet() {
//	TODO("Not yet implemented")
//}

@Composable
fun ResponsePet() {
	Row(
		modifier = Modifier
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceAround,
		verticalAlignment = Alignment.CenterVertically
	) {
		Button(
			onClick = { /*TODO*/ },
			modifier = Modifier
				.height(68.dp)
				.width(68.dp),
			shape = RoundedCornerShape(16.dp),
			colors = ButtonDefaults.buttonColors(Color(249,222,220))
		) {
			Icon(
				imageVector = Icons.Default.Delete,
				contentDescription = "leftButton",
				modifier = Modifier.size(62.dp),
				tint = Color(65,14,11)
			)
		}
		Button(
			onClick = { /*TODO*/ },
			modifier = Modifier
				.height(68.dp)
				.width(68.dp),
			shape = RoundedCornerShape(16.dp),
			colors = ButtonDefaults.buttonColors(Color(158, 209, 183))
		) {
			Icon(
				imageVector = Icons.Default.Check,
				contentDescription = "rightButton",
				modifier = Modifier.size(62.dp),
				tint = Color(65,86,75)
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
	PetSaudeAppTheme {
		GlobalCreatePet(LocalContext.current)
	}
}