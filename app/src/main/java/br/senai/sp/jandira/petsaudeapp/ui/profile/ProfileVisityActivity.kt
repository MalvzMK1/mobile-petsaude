package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.content.Context
import android.graphics.Paint.Align
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
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
import br.senai.sp.jandira.petsaudeapp.model.Reviews
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType

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
		ConfigHeader(
			headline = stringResource(id = R.string.name_app_petsaude),
			context,
			icon = Icons.Filled.Settings
		)
//		PersonProfessional()
		AvaliationProfessioanl()
		InformationAcademyProfessional()
		LocalizationProfessioanl()
	}
}

//@Composable
//fun PersonProfessional() {
//	TODO("Not yet implemented")
//}

@Composable
fun AvaliationProfessioanl() {
	var reviews by rememberSaveable() {
		mutableStateOf(listOf<Reviews>())
	}
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.height(760.dp)
	) {
		Spacer(modifier = Modifier.height(12.dp))
		Text(
			text = stringResource(id = R.string.reviews_professional),
			modifier = Modifier.fillMaxWidth(),
			fontSize = 18.sp,
			fontWeight = FontWeight.W600,
			textAlign = TextAlign.Start
		)
		Column(
			modifier = Modifier
				.fillMaxSize()
//				.verticalScroll(rememberScrollState())
				.background(color = Color.Red)
		) {
			LazyColumn(
				modifier = Modifier.fillMaxWidth()
			) {
//				items(reviews) {
//					Card(
//						modifier = Modifier
//							.fillMaxWidth()
//							.height(360.dp),
//						shape = RoundedCornerShape(12.dp),
//						backgroundColor = Color.White,
//						border = BorderStroke(0.8.dp, Color(202,196,208))
//					) {
//
//					}
//				}
			}
		}
	}
}

@Composable
fun InformationAcademyProfessional() {
	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Spacer(modifier = Modifier.height(12.dp))
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
					.width(185.dp)
					.height(60.dp),
				elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.formation_professional),
							modifier = Modifier
								.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						//Inserir dados da API//
						Text(
							text = "it.formation",
							modifier = Modifier
								.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
			Spacer(modifier = Modifier.width(12.dp))
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp),
				elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.formation_date_professional),
							modifier = Modifier
								.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						//Inserir dados da API//
						Text(
							text = "it.formationDate",
							modifier = Modifier
								.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
		}
		Spacer(modifier = Modifier.height(8.dp))
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Center
		) {
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp),
				elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.institution_professional),
							modifier = Modifier
								.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						//Inserir dados da API//
						Text(
							text = "it.instituation",
							modifier = Modifier
								.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
			Spacer(modifier = Modifier.width(12.dp))
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp),
				elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.start_atuating_date_professional),
							modifier = Modifier
								.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						//Inserir dados da API//
						Text(
							text = "it.startAtuatingDate",
							modifier = Modifier
								.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
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
		Spacer(modifier = Modifier.height(12.dp))
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
				.height(220.dp),
			shape = RoundedCornerShape(5.dp),
			elevation = 2.dp
		) {
			GoogleMap(
				modifier = Modifier.fillMaxSize(),
				properties = MapProperties(mapType = MapType.NORMAL)
			)
		}
		Spacer(modifier = Modifier.height(32.dp))
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview11() {
	PetSaudeAppTheme {
		GlocalProfileVisity(LocalContext.current)
	}
}