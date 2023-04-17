package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.ConfigHeader
import br.senai.sp.jandira.petsaudeapp.model.PetsCard
import br.senai.sp.jandira.petsaudeapp.model.Reviews
import br.senai.sp.jandira.petsaudeapp.ui.profile.ui.theme.PetSaudeAppTheme

class MyPetsActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier
						.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					GlobalMyPets(this)
				}
			}
		}
	}
}

@Composable
fun GlobalMyPets(context: Context) {
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
		Spacer(modifier = Modifier.height(8.dp))
		Text(
			text = stringResource(id = R.string.my_pets_activity),
			fontSize = 22.sp,
			fontWeight = FontWeight.W600
		)
		CardsPet()
//		FloatingActionButton(
//			onClick = { /*TODO*/ },
//			modifier = Modifier
//				.height(68.dp)
//				.width(68.dp)
//				.offset(x = 312.dp, y = 48.dp)
//				.absoluteOffset(x = 16.dp, y = 16.dp),
//			shape = RoundedCornerShape(16.dp),
//			backgroundColor = Color(158, 209, 183)
//		) {
//			Icon(
//				imageVector = Icons.Default.Add,
//				contentDescription = "rightButton",
//				modifier = Modifier.size(48.dp),
//				tint = Color(65, 86, 75)
//			)
//		}
	}
}

@Composable
fun CardsPet() {
	var pets by rememberSaveable() {
		mutableStateOf(listOf<PetsCard>())
	}

	Column(
		modifier = Modifier
			.verticalScroll(rememberScrollState())
			.fillMaxWidth()
			.height(1060.dp)
			.background(Color(236, 236, 236))
	) {
//		LazyColumn(
//			modifier = Modifier
//				.fillMaxWidth()
//				.height(780.dp)
//				.background(Color(236, 236, 236))
//		) {
//			items(pets) {
//				Card(
//					modifier = Modifier
//						.fillMaxWidth(),
//					shape = RoundedCornerShape(16.dp),
//					backgroundColor = Color.White,
//					border = BorderStroke(0.8.dp, Color(202, 196, 208))
//				) {
//					Column(
//						modifier = Modifier.fillMaxSize()
//					) {
//						Row(
//							modifier = Modifier
//								.fillMaxWidth()
//								.wrapContentHeight()
//								.padding(16.dp),
//							horizontalArrangement = Arrangement.SpaceBetween,
//							verticalAlignment = Alignment.CenterVertically
//						) {
//							Card(
//								modifier = Modifier
//									.width(55.dp)
//									.height(55.dp),
//								shape = RoundedCornerShape(50),
//								border = BorderStroke(0.7.dp, Color(202, 196, 208)),
//								elevation = 2.dp
//							) {
//								//---------- COLOCAR IMAGEM DE PERFIL DO USUARIO ----------//
//							}
//							Text(
//								//---------- COLOCAR NOME DO PET ----------//
//								text = "it.petName",
//								fontSize = 16.sp,
//								fontWeight = FontWeight.W500,
//								textAlign = TextAlign.Start
//							)
//						}
//						Image(
//							//---------- COLOCAR IMAGEM DO PET ----------//
//							painter = painterResource(id = R.drawable.media),
//							contentDescription = "Image Card",
//							modifier = Modifier
//								.fillMaxWidth(),
//							contentScale = ContentScale.FillWidth
//						)
//					}
//				}
//			}
//		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview12() {
	PetSaudeAppTheme {
		GlobalMyPets(LocalContext.current)
	}
}