package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.UserConfigHeader
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

class UserConfigActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					GlobalUserConfig()
				}
			}
		}
	}
}

@Composable
fun GlobalUserConfig() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		UserConfigHeader(headline = stringResource(id = R.string.user_config_profile))
		UserProfile()
		UserPreferences()
	}
}

@Composable
fun UserProfile() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(10.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Card(
			modifier = Modifier
				.width(70.dp)
				.height(70.dp),
			shape = RoundedCornerShape(35.dp),
			elevation = 2.dp
		) {
			
			//---------- COLOCAR IMAGEM DE PERFIL DO USUARIO ----------//

		}
		Spacer(modifier = Modifier.width(16.dp))
		Column(
			modifier = Modifier
				.fillMaxWidth()
		) {
			Text(

				//---------- COLOCAR NOME DE PERFIL DO USUARIO ----------//

				text = "Hayley Williams",
				fontSize = 22.sp,
				fontWeight = FontWeight.W400
			)
			Text(

				//---------- COLOCAR EMAIL DE CADASTRO DO USUARIO ----------//

				text = "hayley.williams@useremail.com",
				color = Color(169,169,169),
				fontSize = 12.sp,
				fontWeight = FontWeight.W400
			)
		}
	}
}

@Composable
fun UserPreferences() {
	val context = LocalContext.current
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		//-------------------------------------------------- CONFIGURACOES ---------------------------------------------------//
		Text(
			text = "Configurações",
			fontSize = 16.sp,
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(4.dp))
		Button(
			onClick = {
				/*TODO*/
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202,196,208)),
			colors = ButtonDefaults.buttonColors(
				backgroundColor = Color.Transparent,
				contentColor = Color.Black
			)
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
					Row(
						modifier = Modifier.padding(start = 4.dp),
						horizontalArrangement = Arrangement.Start,
						verticalAlignment = Alignment.CenterVertically
					) {
						Icon(
							imageVector = Icons.Filled.Person,
							contentDescription = "Informacoes Pessoais",
							modifier = Modifier.size(30.dp)
						)
						Text(
							text = "Informações pessoais",
							modifier = Modifier.padding(start = 16.dp),
							color = Color(28,27,31),
							fontSize = 16.sp,
							fontWeight = FontWeight.Normal
						)
					}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "Seguinte",
					modifier = Modifier.size(25.dp)
				)
			}
		}
		Button(
			onClick = {
				/*TODO*/
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202,196,208)),
			colors = ButtonDefaults.buttonColors(
				backgroundColor = Color.Transparent,
				contentColor = Color.Black
			)
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					modifier = Modifier.padding(start = 4.dp),
					horizontalArrangement = Arrangement.Start,
					verticalAlignment = Alignment.CenterVertically
				) {
					Icon(
						imageVector = Icons.Filled.Lock,
						contentDescription = "Segurança",
						modifier = Modifier.size(30.dp)
					)
					Text(
						text = "Segurança",
						modifier = Modifier.padding(start = 16.dp),
						color = Color(28,27,31),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "Seguinte",
					modifier = Modifier.size(25.dp)
				)
			}
		}
		Button(
			onClick = {
				/*TODO*/
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202,196,208)),
			colors = ButtonDefaults.buttonColors(
				backgroundColor = Color.Transparent,
				contentColor = Color.Black
			)
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					modifier = Modifier.padding(start = 4.dp),
					horizontalArrangement = Arrangement.Start,
					verticalAlignment = Alignment.CenterVertically
				) {
					Icon(
						imageVector = Icons.Filled.LocationOn,
						contentDescription = "Localização",
						modifier = Modifier.size(30.dp)
					)
					Text(
						text = "Localização",
						modifier = Modifier.padding(start = 16.dp),
						color = Color(28,27,31),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "Seguinte",
					modifier = Modifier.size(25.dp)
				)
			}
		}
		Spacer(modifier = Modifier.height(10.dp))
		//-------------------------------------------------- ADICIONAIS ---------------------------------------------------//
		Text(
			text = "Adicionais",
			fontSize = 16.sp,
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(4.dp))
		Button(
			onClick = {
				/*TODO*/
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202,196,208)),
			colors = ButtonDefaults.buttonColors(
				backgroundColor = Color.Transparent,
				contentColor = Color.Black
			)
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					modifier = Modifier.padding(start = 4.dp),
					horizontalArrangement = Arrangement.Start,
					verticalAlignment = Alignment.CenterVertically
				) {
					Icon(
						imageVector = Icons.Filled.PermContactCalendar,
						contentDescription = "Consultas",
						modifier = Modifier.size(30.dp)
					)
					Text(
						text = "Consultas",
						modifier = Modifier.padding(start = 16.dp),
						color = Color(28,27,31),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "Seguinte",
					modifier = Modifier.size(25.dp)
				)
			}
		}
		Button(
			onClick = {
				/*TODO*/
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202,196,208)),
			colors = ButtonDefaults.buttonColors(
				backgroundColor = Color.Transparent,
				contentColor = Color.Black
			)
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					modifier = Modifier.padding(start = 4.dp),
					horizontalArrangement = Arrangement.Start,
					verticalAlignment = Alignment.CenterVertically
				) {
					Icon(
						imageVector = Icons.Filled.Work,
						contentDescription = "Informacoes Profissionais",
						modifier = Modifier.size(30.dp)
					)
					Text(
						text = "Informações profissionais",
						modifier = Modifier.padding(start = 16.dp),
						color = Color(28,27,31),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "Seguinte",
					modifier = Modifier.size(25.dp)
				)
			}
		}
		//-------------------------------------------------- SAIR ---------------------------------------------------//
		Spacer(modifier = Modifier.height(32.dp))
		Button(
			onClick = {
				/*TODO*/
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(179,38,30)),
			colors = ButtonDefaults.buttonColors(
				backgroundColor = Color.Transparent,
				contentColor = Color(179,38,30)
			)
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				Row(
					modifier = Modifier.padding(start = 4.dp),
					horizontalArrangement = Arrangement.Start,
					verticalAlignment = Alignment.CenterVertically
				) {
					Icon(
						imageVector = Icons.Filled.Logout,
						contentDescription = "Sair",
						modifier = Modifier.size(30.dp),
						tint = Color(179,38,30)
					)
					Text(
						text = "Sair",
						modifier = Modifier.padding(start = 16.dp),
						color = Color(179,38,30),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "Seguinte",
					modifier = Modifier.size(25.dp),
					tint = Color(179,39,30)
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview6() {
	PetSaudeAppTheme {
		GlobalUserConfig()
	}
}