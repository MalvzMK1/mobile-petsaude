package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.ConfigHeader
import br.senai.sp.jandira.petsaudeapp.ui.profile.ui.theme.PetSaudeAppTheme

class EditPetActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					GlobalEditPet(this)
				}
			}
		}
	}
}

@Composable
fun GlobalEditPet(context: Context) {
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
		Spacer(modifier = Modifier.height(10.dp))
		CardPet()
		Spacer(modifier = Modifier.height(4.dp))
		SettingPet()
		Spacer(modifier = Modifier.height(32.dp))
		ResponsePetEdit()
	}
}

@Composable
fun ResponsePetEdit() {
	Row(
		modifier = Modifier
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.SpaceBetween,
		verticalAlignment = Alignment.CenterVertically
	) {
		Button(
			onClick = { /*TODO*/ },
			modifier = Modifier
				.height(68.dp)
				.width(68.dp),
			shape = RoundedCornerShape(16.dp),
			colors = ButtonDefaults.buttonColors(Color(249, 222, 220))
		) {
			Icon(
				imageVector = Icons.Default.Delete,
				contentDescription = "leftButton",
				modifier = Modifier.size(62.dp),
				tint = Color(65, 14, 11)
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
				tint = Color(65, 86, 75)
			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
	PetSaudeAppTheme {
		GlobalEditPet(LocalContext.current)
	}
}