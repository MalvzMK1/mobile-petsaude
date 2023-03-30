package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.ConfigHeader
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme


class UserSecurityActivity : ComponentActivity() {
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
					GlobarUserSecurity(this)
				}
			}
		}
	}
}

@Composable
fun GlobarUserSecurity(context: Context) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		ConfigHeader(
			headline = stringResource(id = R.string.user_config_security),
			context,
			icon = Icons.Filled.Settings
		)
		UserSecurityPreferences()
	}
}

@Composable
fun UserSecurityPreferences() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		Card(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp)
				.height(230.dp),
			shape = RoundedCornerShape(size = 28.dp),
			backgroundColor = Color(249,222,220),
			border = BorderStroke(0.8.dp, Color(65,14,11))
		) {
			Column(
				modifier = Modifier
					.fillMaxWidth()
					.padding(32.dp),
				verticalArrangement = Arrangement.SpaceAround
			) {
				Text(
					text = stringResource(id = R.string.user_config_change_email),
					modifier = Modifier.fillMaxWidth(),
					color = Color(65,14,11),
					fontSize = 24.sp,
					fontWeight = FontWeight.Bold
				)
				Spacer(modifier = Modifier.height(10.dp))
				Text(
					text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque elementum laoreet imperdiet. Quisque et pretium mauris, ut posuere justo.",
					color = Color(65,14,11),
				  fontSize = 14.sp,
				  fontWeight = FontWeight.Normal
				)
				Spacer(modifier = Modifier.height(24.dp))
				Text(
					text = stringResource(id = R.string.user_config_change_email),
					modifier = Modifier
						.fillMaxWidth()
						.clickable {

											 //----- IMPLEMENTAR A TROCA DE E-MAIL -----//

						},
					color = Color(65,14,11),
					fontSize = 14.sp,
					fontWeight = FontWeight.Bold,
					textAlign = TextAlign.End
				)
			}
		}
		Card(
			modifier = Modifier
				.fillMaxWidth()
				.padding(16.dp)
				.height(230.dp),
			shape = RoundedCornerShape(size = 28.dp),
			backgroundColor = Color(249,222,220),
			border = BorderStroke(0.8.dp, Color(65,14,11))
		) {
			Column(
				modifier = Modifier
					.fillMaxWidth()
					.padding(32.dp),
				verticalArrangement = Arrangement.SpaceAround
			) {
				Text(
					text = stringResource(id = R.string.user_config_change_password),
					modifier = Modifier.fillMaxWidth(),
					color = Color(65,14,11),
					fontSize = 24.sp,
					fontWeight = FontWeight.Bold
				)
				Spacer(modifier = Modifier.height(10.dp))
				Text(
					text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Quisque elementum laoreet imperdiet. Quisque et pretium mauris, ut posuere justo.",
					modifier = Modifier.fillMaxWidth(),
					color = Color(65,14,11),
					fontSize = 14.sp,
					fontWeight = FontWeight.Normal
				)
				Spacer(modifier = Modifier.height(24.dp))
				Text(
					text = stringResource(id = R.string.user_config_change_password),
					modifier = Modifier
						.fillMaxWidth()
						.clickable {

											 //----- IMPLEMENTAR A TROCA DA SENHA -----//

						},
					color = Color(65,14,11),
					fontSize = 14.sp,
					fontWeight = FontWeight.Bold,
					textAlign = TextAlign.End
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview7() {
	PetSaudeAppTheme {
		GlobarUserSecurity(LocalContext.current)
	}
}