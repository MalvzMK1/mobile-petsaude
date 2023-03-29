package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.ui.Modifier
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
import com.google.maps.android.compose.GoogleMap

class ProfileVisityActivity : ComponentActivity() {
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
					GlocalProfileVisity(this)
				}
			}
		}
	}
}

@Composable
fun GlocalProfileVisity(context: Context) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		ConfigHeader(headline = stringResource(id = R.string.name_app_petsaude), context)
//		PersonProfessional()
//		AvaliationProfessioanl()
		InformationAcademyProfessional()
		LocalizationProfessioanl()
	}
}

//@Composable
//fun PersonProfessional() {
//	TODO("Not yet implemented")
//}

//@Composable
//fun AvaliationProfessioanl() {
//	Column(
//		modifier = Modifier
//			.fillMaxWidth()
//			.height(760.dp)
//	) {
//		Text(
//			text = stringResource(id = R.string.reviews_professional),
//			modifier = Modifier.fillMaxWidth(),
//			fontSize = 18.sp,
//			fontWeight = FontWeight.W600,
//			textAlign = TextAlign.Start
//		)
//		Column(
//			modifier = Modifier
//				.fillMaxWidth()
//				.verticalScroll(rememberScrollState())
//		) {
//			CONSUMIR A API INSERINDO AS AVALIACOES NA TELA
//		}
//	}
//}

@Composable
fun InformationAcademyProfessional() {
	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Text(
			text = stringResource(id = R.string.user_config_academic_information),
			modifier = Modifier.fillMaxWidth(),
			fontSize = 18.sp,
			fontWeight = FontWeight.W600,
			textAlign = TextAlign.Start
		)
		Spacer(modifier = Modifier.height(2.dp))
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
		) {
			Card(
				modifier = Modifier
					.fillMaxWidth()
//					.width(170.dp)
//					.padding(end = 6.dp)
					.height(60.dp)
			) {
				
			}
			Spacer(modifier = Modifier.width(12.dp))
			Card(
				modifier = Modifier
					.fillMaxWidth()
//					.width(170.dp)
//					.padding(start = 6.dp)
					.height(60.dp)
			) {
				
			}
		}
		Spacer(modifier = Modifier.height(8.dp))
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
		) {
			Card(
				modifier = Modifier
//					.fillMaxWidth()
					.width(170.dp)
					.height(60.dp)
			) {

			}
			Spacer(modifier = Modifier.width(12.dp))
			Card(
				modifier = Modifier
//					.fillMaxWidth()
					.width(170.dp)
					.height(60.dp)
			) {

			}
		}
	}
}

@Composable
fun LocalizationProfessioanl() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
	) {
		Text(
			text = stringResource(id = R.string.user_config_location),
			modifier = Modifier.fillMaxWidth(),
			fontSize = 18.sp,
			fontWeight = FontWeight.W600,
			textAlign = TextAlign.Start
		)
		Spacer(modifier = Modifier.height(2.dp))
		Card(
			modifier = Modifier
				.fillMaxWidth()
				.height(200.dp),
			shape = RoundedCornerShape(5.dp)
		) {
//			GoogleMap(
//			INSERIR O MAPA FUNCIONAL
//			)
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
	PetSaudeAppTheme {
		GlocalProfileVisity(LocalContext.current)
	}
}