package br.senai.sp.jandira.petsaudeapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

class HomePetActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
					GlobalHomePet()
				}
			}
		}
	}
}

@Composable
fun GlobalHomePet() {
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp)
	) {
		HomeHeader()
	}
}

@Composable
fun HomeHeader() {
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
				IconButton(
					onClick = { /*TODO*/ }
				) {
					Icon(
						imageVector = Icons.Filled.Menu,
						contentDescription = "Menu",
						modifier = Modifier.size(32.dp)
					)
				}
			Text(
				text = "Pet Saúde",
				fontSize = 22.sp
			)
			IconButton(
				onClick = { /*TODO*/ }
			) {
				Icon(
					imageVector = Icons.Filled.Person,
					contentDescription = "Menu",
					modifier = Modifier.size(30.dp)
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview5() {
	PetSaudeAppTheme {
		GlobalHomePet()
	}
}