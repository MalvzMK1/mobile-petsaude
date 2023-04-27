package br.senai.sp.jandira.petsaudeapp.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.BoringLayout
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.ConfigHeader
import br.senai.sp.jandira.petsaudeapp.model.Token
import br.senai.sp.jandira.petsaudeapp.model.UserDefault
import br.senai.sp.jandira.petsaudeapp.service.integrations.user.validationUserJWT
import br.senai.sp.jandira.petsaudeapp.ui.profile.ProfileVisityActivity
import br.senai.sp.jandira.petsaudeapp.ui.profile.UserConfigActivity
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

class HomePetActivity : ComponentActivity() {
	var isVet: Boolean = false
	var idUser: Int = 0
	override fun onCreate(savedInstanceState: Bundle?) {
//		var isVet: Boolean = false
//		var idUser: Int = 0
		val tokenId: String = intent.getSerializableExtra("tokenID") as String
		Log.i("RESPONSE SUCCESS - JWT HOME", tokenId)
		val user = validationUserJWT("Bearer ${tokenId}") {
			Log.i("RESPONSE SUCCESS - JWT HOME USER", it.toString())
			idUser = it.user.id
			isVet = it.user.isVet
			onUpdateValues(idUser, isVet)
		}
		super.onCreate(savedInstanceState)
		setContentWithValues(idUser, isVet)
	}
	private fun setContentWithValues(idUser: Number, isVet: Boolean) {
		setContent {
			PetSaudeAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					GlobalHomePet(this, idUser.toInt(), isVet)
					Log.i("RESPONSE SUCCESS - JWT HOME idUser", idUser.toString())
					Log.i("RESPONSE SUCCESS - JWT HOME isVet", isVet.toString())
				}
			}
		}
	}
	fun onUpdateValues(idUser: Number, isVet: Boolean) {
		this.idUser = idUser.toInt()
		this.isVet = isVet
		setContentWithValues(idUser, isVet)
	}
}

@Composable
fun GlobalHomePet(context: Context, idUser: Int, isVet: Boolean) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(16.dp)
	) {
//		ConfigHeader(
//			headline = stringResource(id = R.string.name_app_petsaude),
//			context,
//			icon = Icons.Filled.AccountCircle
//		)
		Column(
			modifier = Modifier.fillMaxWidth()
		) {
			Row(
				modifier = Modifier
					.fillMaxWidth(),
				horizontalArrangement = Arrangement.SpaceBetween,
				verticalAlignment = Alignment.CenterVertically
			) {
				IconButton(
					onClick = { }
				) {
					Icon(
						imageVector = Icons.Filled.Menu,
						contentDescription = "leftSideButtonHeader",
						modifier = Modifier.size(32.dp)
					)
				}
				Text(
					text = " ",
					modifier = Modifier.width(200.dp),
					fontSize = 24.sp,
					fontWeight = FontWeight.W500,
					textAlign = TextAlign.Center
				)
				IconButton(
					onClick = {
						val openUserProfileVisityActivity = Intent(context, ProfileVisityActivity::class.java)
						Log.i("RESPONSE SUCCESS - ****userid**** HOME", idUser.toString())
						openUserProfileVisityActivity.putExtra("userID", idUser)
						Log.i("RESPONSE SUCCESS - ****userid**** HOME", idUser.toString())
						Log.i("RESPONSE SUCCESS - ****isvet**** HOME", isVet.toString())
						openUserProfileVisityActivity.putExtra("isVetUser", isVet)
						Log.i("RESPONSE SUCCESS - ****isvet**** HOME", isVet.toString())
						ContextCompat.startActivity(context, openUserProfileVisityActivity, null)
					}
				) {
					Icon(
						imageVector = Icons.Default.Person,
						contentDescription = "rightSideButtonHeader",
						modifier = Modifier.size(30.dp)
					)
				}
			}
		}
	}
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview5() {
//	PetSaudeAppTheme {
//		GlobalHomePet(LocalContext.current, isVet = false)
//	}
//}