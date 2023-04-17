package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.app.DatePickerDialog
import android.content.Context
import android.graphics.drawable.Icon
import android.os.Bundle
import android.widget.DatePicker
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.ConfigHeader
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import java.util.*

class CreatePetActivity : ComponentActivity() {
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
					GlobalCreatePet(this)
				}
			}
		}
	}
}

@Composable
fun GlobalCreatePet(context: Context) {
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
		ResponsePet()
	}
}

@Composable
fun CardPet() {
	Row(
		modifier = Modifier
			.fillMaxWidth()
			.padding(4.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Card(
			modifier = Modifier
				.height(100.dp)
				.width(100.dp),
			shape = RoundedCornerShape(50)
		) {
			Image(
				//INTEGRACAO API COM A FOTO DO PET
				painter = painterResource(id = R.drawable.media),
				contentDescription = "FOTO DO PET",
				contentScale = ContentScale.Crop
			)
		}
		Spacer(modifier = Modifier.width(18.dp))
		Column() {
			Text(
				text = "it.PETName",
				fontSize = 24.sp,
				fontWeight = FontWeight.W500
			)
			Text(
				text = "it.Espécie",
				color = Color(169, 169, 169),
				fontSize = 20.sp,
				fontWeight = FontWeight.W500
			)
		}
	}
}

@Composable
fun SettingPet() {
	val context = LocalContext.current

	var nameState by rememberSaveable {
		mutableStateOf("")
	}

	var speciesState by rememberSaveable {
		mutableStateOf("")
	}

	var dateState by rememberSaveable { mutableStateOf("00/00/0000") }
	val year: Int
	val month: Int
	val day: Int
	val calendar = Calendar.getInstance()
	year = calendar.get(Calendar.YEAR)
	month = calendar.get(Calendar.MONTH)
	day = calendar.get(Calendar.DAY_OF_MONTH)
	calendar.time = Date()
	val datePickerDialog = DatePickerDialog(
		context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
			dateState = "$month/$dayOfMonth/$year"
		}, year, month, day
	)
	val sexAnimals = listOf(
		stringResource(id = R.string.male_animal_type),
		stringResource(id = R.string.female_animal_type),
		stringResource(id = R.string.gynandromorph_animal_type)
	)
	val sizeAnimals = listOf(
		stringResource(id = R.string.small_animal_type),
		stringResource(id = R.string.medium_animal_type),
		stringResource(id = R.string.big_animal_type)
	)
	var selectedIndexSex by remember { mutableStateOf(0) }
	var selectedIndexSize by remember { mutableStateOf(0) }
	var expandedSex by remember { mutableStateOf(false) }
	var expandedSize by remember { mutableStateOf(false) }

	Column() {
		Text(
			text = stringResource(id = R.string.information_animal_type),
			modifier = Modifier.fillMaxWidth(),
			color = Color.Black,
			fontSize = 42.sp,
			fontWeight = FontWeight.W500,
			textAlign = TextAlign.Center
		)
		Text(
			text = stringResource(id = R.string.name_string_resource),
			color = Color(169, 169, 169),
			fontSize = 22.sp,
			fontWeight = FontWeight.W400
		)
		BasicTextField(
			value = nameState,
			onValueChange = {
				nameState = it
			},
			modifier = Modifier.fillMaxWidth(),
			textStyle = TextStyle(
				fontSize = 28.sp,
				fontWeight = FontWeight.Normal
			),
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
			singleLine = true,
			decorationBox = { innerPlaceHolder ->
				if (nameState.isEmpty()) {
					Text(
						text = stringResource(id = R.string.name_string_resource),
						fontSize = 28.sp
					)
				}
				innerPlaceHolder()
			}
		)
		Spacer(modifier = Modifier.height(10.dp))
		Text(
			text = stringResource(id = R.string.sex_animal_type),
			color = Color(169, 169, 169),
			fontSize = 22.sp,
			fontWeight = FontWeight.W400,
		)
		Row(
			modifier = Modifier.wrapContentHeight(),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				text = sexAnimals[selectedIndexSex],
				fontSize = 28.sp,
			)
			Spacer(modifier = Modifier.width(12.dp))
			Box(
				modifier = Modifier
					.height(24.dp)
					.width(24.dp)
					.clickable(onClick = { expandedSex = true })
					.background(Color(217, 217, 217))
			) {
				Icon(
					imageVector = Icons.Default.KeyboardArrowDown,
					contentDescription = null,
					modifier = Modifier.fillMaxSize()
				)
				DropdownMenu(
					expanded = expandedSex,
					onDismissRequest = { expandedSex = false },
					modifier = Modifier.clip(RoundedCornerShape(5.dp))
				) {
					sexAnimals.forEachIndexed { index, sex ->
						DropdownMenuItem(
							onClick = {
								selectedIndexSex = index
								expandedSex = false
							},
							modifier = Modifier.clip(RoundedCornerShape(5.dp))
						) {
							Text(text = sex)
						}
					}
				}
			}
		}
		Spacer(modifier = Modifier.height(10.dp))
		Text(
			text = stringResource(id = R.string.specie_animal_type),
			color = Color(169, 169, 169),
			fontSize = 22.sp,
			fontWeight = FontWeight.W400,
		)
		BasicTextField(
			value = speciesState,
			onValueChange = {
				speciesState = it
			},
			modifier = Modifier.fillMaxWidth(),
			textStyle = TextStyle(
				fontSize = 28.sp,
				fontWeight = FontWeight.Normal
			),
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
			singleLine = true,
			decorationBox = { innerPlaceHolder ->
				if (speciesState.isEmpty()) {
					Text(
						text = stringResource(id = R.string.specie_animal_type),
						fontSize = 28.sp
					)
				}
				innerPlaceHolder()
			}
		)
		Spacer(modifier = Modifier.height(10.dp))
		Text(
			text = stringResource(id = R.string.size_animal_type),
			color = Color(169, 169, 169),
			fontSize = 22.sp,
			fontWeight = FontWeight.W400,
		)
		Row(
			modifier = Modifier.wrapContentHeight(),
			verticalAlignment = Alignment.CenterVertically
		) {
			Text(
				text = sizeAnimals[selectedIndexSize],
				fontSize = 28.sp,
			)
			Spacer(modifier = Modifier.width(12.dp))
			Box(
				modifier = Modifier
					.height(24.dp)
					.width(24.dp)
					.clickable(onClick = { expandedSize = true })
					.background(Color(217, 217, 217))
			) {
				Icon(
					imageVector = Icons.Default.KeyboardArrowDown,
					contentDescription = null,
					modifier = Modifier.fillMaxSize()
				)
				DropdownMenu(
					expanded = expandedSize,
					onDismissRequest = { expandedSize = false },
					modifier = Modifier.clip(RoundedCornerShape(5.dp))
				) {
					sexAnimals.forEachIndexed { index, size ->
						DropdownMenuItem(
							onClick = {
								selectedIndexSize = index
								expandedSize = false
							},
							modifier = Modifier.clip(RoundedCornerShape(5.dp))
						) {
							Text(text = size)
						}
					}
				}
			}
		}
		Spacer(modifier = Modifier.height(10.dp))
		Text(
			text = stringResource(id = R.string.date_agendamento),
			color = Color(169, 169, 169),
			fontSize = 22.sp,
			fontWeight = FontWeight.W400,
		)
		BasicTextField(
			value = dateState,
			onValueChange = {
				if (it.length <= 8)
					dateState
			},
			modifier = Modifier
				.wrapContentSize()
				.clickable { datePickerDialog.show() },
			enabled = false,
			textStyle = TextStyle(
				fontSize = 28.sp,
				fontWeight = FontWeight.Normal
			),
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
			singleLine = true
		)
	}
}

@Composable
fun ResponsePet() {
	Row(
		modifier = Modifier
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.End,
		verticalAlignment = Alignment.CenterVertically
	) {
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
fun DefaultPreview4() {
	PetSaudeAppTheme {
		GlobalCreatePet(LocalContext.current)
	}
}