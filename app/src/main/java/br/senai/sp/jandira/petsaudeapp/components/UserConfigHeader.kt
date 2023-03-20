package br.senai.sp.jandira.petsaudeapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.ui.profile.GlobalUserConfig
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

@Composable
fun UserConfigHeader() {
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
					imageVector = Icons.Filled.Settings,
					contentDescription = "Configurações",
					modifier = Modifier.size(30.dp)
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
	PetSaudeAppTheme {
		UserConfigHeader()
	}
}
