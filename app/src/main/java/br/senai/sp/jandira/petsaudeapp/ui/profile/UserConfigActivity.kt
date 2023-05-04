package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.ConfigHeader
import br.senai.sp.jandira.petsaudeapp.service.integrations.user.getUserInfosById
import br.senai.sp.jandira.petsaudeapp.ui.authentication.MainActivity
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import coil.compose.AsyncImage

class UserConfigActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		val idUser: Int = intent.getIntExtra("userID", 0)
		val isVetUser: Boolean = intent.getBooleanExtra("isVetUser", false)
		val tokenId: String = intent.getStringExtra("tokenUserID") as String
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
					GlobalUserConfig(this, idUser, isVetUser, tokenId)
				}
			}
		}
	}
}

@Composable
fun GlobalUserConfig(context: Context, idUser: Int, isVetUser: Boolean, tokenId: String) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		ConfigHeader(
			headline = stringResource(id = R.string.user_config_profile),
			context,
			icon = Icons.Filled.Settings
		)
		UserProfile(idUser)
		UserPreferences(idUser, isVetUser, tokenId)
	}
}

@Composable
fun UserProfile(idUser: Int) {
	var profilePhotoStateValue by rememberSaveable() {
		mutableStateOf("")
	}
	var nameStateValue by rememberSaveable() {
		mutableStateOf("")
	}
	var emailStateValue by rememberSaveable() {
		mutableStateOf("")
	}
	getUserInfosById(idUser) {
		profilePhotoStateValue = it.response.user.profileBannerPhoto.toString()
		nameStateValue = it.response.user.personName
		emailStateValue = it.response.user.biography.toString()
	}
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
			AsyncImage(
				//---------- COLOCAR FOTO DO PET ----------//
				model = profilePhotoStateValue,
				contentDescription = "Image Card",
				modifier = Modifier
					.fillMaxWidth(),
				contentScale = ContentScale.FillWidth
			)
		}
		Spacer(modifier = Modifier.width(16.dp))
		Column(
			modifier = Modifier
				.fillMaxWidth()
		) {
			Text(
				//---------- COLOCAR NOME DE PERFIL DO USUARIO ----------//
				text = nameStateValue,
				fontSize = 22.sp,
				fontWeight = FontWeight.W400
			)
			Text(
				//---------- COLOCAR EMAIL DE CADASTRO DO USUARIO ----------//
				text = emailStateValue,
				color = Color(169, 169, 169),
				fontSize = 12.sp,
				fontWeight = FontWeight.W400
			)
		}
	}
}

@Composable
fun UserPreferences(idUser: Int, isVetUser: Boolean, tokenId: String) {
	val context = LocalContext.current
	Column(
		modifier = Modifier.fillMaxSize()
	) {
		//-------------------------------------------------- CONFIGURACOES ---------------------------------------------------//
		Text(
			text = stringResource(id = R.string.user_config_settings),
			fontSize = 16.sp,
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(4.dp))
		Button(
			onClick = {
				val openInfoPersonalActivity = Intent(context, UserInfoPersonalActivity::class.java)
				ContextCompat.startActivity(context, openInfoPersonalActivity, null)
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202, 196, 208)),
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
						contentDescription = "Person",
						modifier = Modifier.size(30.dp)
					)
					Text(
						text = stringResource(id = R.string.user_config_personal_information),
						modifier = Modifier.padding(start = 16.dp),
						color = Color(28, 27, 31),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "ArrowForwardIos",
					modifier = Modifier.size(25.dp)
				)
			}
		}
		Button(
			onClick = {
				val openSecurityActivity = Intent(context, UserSecurityActivity::class.java)
				ContextCompat.startActivity(context, openSecurityActivity, null)
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202, 196, 208)),
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
						contentDescription = "Lock",
						modifier = Modifier.size(30.dp)
					)
					Text(
						text = stringResource(id = R.string.user_config_security),
						modifier = Modifier.padding(start = 16.dp),
						color = Color(28, 27, 31),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "ArrowForwardIos",
					modifier = Modifier.size(25.dp)
				)
			}
		}
		Button(
			onClick = {
				val openLocationActivity = Intent(context, UserLocationActivity::class.java)
				ContextCompat.startActivity(context, openLocationActivity, null)
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202, 196, 208)),
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
						contentDescription = "LocationOn",
						modifier = Modifier.size(30.dp)
					)
					Text(
						text = stringResource(id = R.string.user_config_location),
						modifier = Modifier.padding(start = 16.dp),
						color = Color(28, 27, 31),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "ArrowForwardIos",
					modifier = Modifier.size(25.dp)
				)
			}
		}
		Spacer(modifier = Modifier.height(10.dp))
		//-------------------------------------------------- ADICIONAIS ---------------------------------------------------//
		Text(
			text = stringResource(id = R.string.user_config_additional),
			fontSize = 16.sp,
			fontWeight = FontWeight.Bold
		)
		Spacer(modifier = Modifier.height(4.dp))
		Button(
			onClick = {
//				val openQueriesActivity = Intent(context, QueriesActivity::class.java)
//				ContextCompat.startActivity(context, openQueriesActivity, null)
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202, 196, 208)),
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
						contentDescription = "PermContactCalendar",
						modifier = Modifier.size(30.dp)
					)
					Text(
						text = stringResource(id = R.string.user_config_queries),
						modifier = Modifier.padding(start = 16.dp),
						color = Color(28, 27, 31),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "ArrowForwardIos",
					modifier = Modifier.size(25.dp)
				)
			}
		}
		////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		Button(
			onClick = {
				if (isVetUser) {
					val openProfessionalActivity = Intent(context, UserProfessionalActivity::class.java)
					openProfessionalActivity.putExtra("isVetUser", isVetUser)
					ContextCompat.startActivity(context, openProfessionalActivity, null)
				} else {
					val openMyPetsActivity = Intent(context, MyPetsActivity::class.java)
					Log.i("RESPONSE SUCCESS - ****userid**** CONFIG", idUser.toString())
					openMyPetsActivity.putExtra("userId", idUser)
					openMyPetsActivity.putExtra("tokenUserID", tokenId)
					ContextCompat.startActivity(context, openMyPetsActivity, null)
				}
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(70.dp)
				.padding(bottom = 4.dp),
			elevation = ButtonDefaults.elevation(0.dp),
			shape = RoundedCornerShape(size = 12.dp),
			border = BorderStroke(0.5.dp, Color(202, 196, 208)),
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
					if (isVetUser) {
						Icon(
							imageVector = Icons.Filled.Work,
							contentDescription = "Work",
							modifier = Modifier.size(30.dp)
						)
					} else {
						Icon(
							imageVector = Icons.Filled.Pets,
							contentDescription = "Work",
							modifier = Modifier.size(30.dp)
						)
					}
					Text(
						text =
						if (isVetUser) stringResource(id = R.string.user_config_professional_information)
						else stringResource(id = R.string.user_config_pets),
						modifier = Modifier.padding(start = 16.dp),
						color = Color(28, 27, 31),
						fontSize = 16.sp,
						fontWeight = FontWeight.Normal
					)
				}
				Icon(
					imageVector = Icons.Default.ArrowForwardIos,
					contentDescription = "ArrowForwardIos",
					modifier = Modifier.size(25.dp)
				)
			}
		}
	}
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//-------------------------------------------------- SAIR ---------------------------------------------------//
	Spacer(modifier = Modifier.height(32.dp))
	Button(
		onClick = {
			val openLoginActivity = Intent(context, MainActivity::class.java)
			ContextCompat.startActivity(context, openLoginActivity, null)
		},
		modifier = Modifier
			.fillMaxWidth()
			.height(70.dp)
			.padding(bottom = 4.dp),
		elevation = ButtonDefaults.elevation(0.dp),
		shape = RoundedCornerShape(size = 12.dp),
		border = BorderStroke(0.5.dp, Color(179, 38, 30)),
		colors = ButtonDefaults.buttonColors(
			backgroundColor = Color.Transparent,
			contentColor = Color(179, 38, 30)
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
					contentDescription = "Logout",
					modifier = Modifier.size(30.dp),
					tint = Color(179, 38, 30)
				)
				Text(
					text = stringResource(id = R.string.user_config_logout),
					modifier = Modifier.padding(start = 16.dp),
					color = Color(179, 38, 30),
					fontSize = 16.sp,
					fontWeight = FontWeight.Normal
				)
			}
			Icon(
				imageVector = Icons.Default.ArrowForwardIos,
				contentDescription = "ArrowForwardIos",
				modifier = Modifier.size(25.dp),
				tint = Color(179, 39, 30)
			)
		}
	}
}
