package br.senai.sp.jandira.petsaudeapp.ui.authentication

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.AuthHeaderTitle
import br.senai.sp.jandira.petsaudeapp.components.TextFieldInput
import br.senai.sp.jandira.petsaudeapp.model.Address
import br.senai.sp.jandira.petsaudeapp.model.UserInfos
import br.senai.sp.jandira.petsaudeapp.model.UserRegister
import br.senai.sp.jandira.petsaudeapp.model.VetInfos
import br.senai.sp.jandira.petsaudeapp.service.integrations.createUserVet
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import br.senai.sp.jandira.petsaudeapp.utils.validateEmptyInput
import com.google.gson.annotations.SerializedName
import java.util.*

class ProfessionalRegisterActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		val userInfosRegister: UserInfos = intent.getSerializableExtra("userInfos") as UserInfos
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				Surface(
					modifier = Modifier
						.fillMaxSize()
						.verticalScroll(rememberScrollState()),
					color = MaterialTheme.colors.background
				) {
					ProfessionalRegisterGlobal(userInfosRegister)
				}
			}
		}
	}
}

@Composable
fun ProfessionalRegisterGlobal(userInfosRegister: UserInfos) {
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		ProfessionalRegisterHeader()
		ProfessionalRegisterForm(userInfosRegister)
		Box(
			modifier = Modifier
				.fillMaxWidth(),
			contentAlignment = Alignment.BottomCenter
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center,
			) {
				Text(
					text = "${stringResource(id = R.string.dont_have_account_bottom_message)} ",
					fontSize = 14.sp,
					fontWeight = FontWeight.Normal,
					color = MaterialTheme.colors.onBackground
				)
				Text(
					text = stringResource(id = R.string.register_yourself_bottom_message),
					modifier = Modifier.clickable {
						val openRegisterActivity = Intent(context, MainActivity::class.java)
						ContextCompat.startActivity(context, openRegisterActivity, null)
					},
					fontSize = 14.sp,
					fontWeight = FontWeight.Bold,
					color = MaterialTheme.colors.onBackground
				)
			}
		}
	}
}

@Composable
fun ProfessionalRegisterHeader() {
	Column(
		modifier = Modifier.padding(top = 32.dp, bottom = 32.dp)
	) {
		AuthHeaderTitle(
			title = stringResource(id = R.string.professional_register_header),
			subtitle = stringResource(id = R.string.message_professional_register_header)
		)
	}
}

@Composable
fun ProfessionalRegisterForm(userInfosRegister: UserInfos) {
	val context = LocalContext.current

	var surgeonCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	var clinicCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	var researchCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	var laboratoryCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	var anesthetistCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	var veterinaryPharmacyCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Text(
			text = stringResource(id = R.string.specialities_string_resource),
			fontSize = 20.sp,
			fontWeight = FontWeight.Bold,
			color = MaterialTheme.colors.onBackground
		)
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Start
		) {
			Row(
				horizontalArrangement = Arrangement.Start,
				verticalAlignment = Alignment.CenterVertically
			) {
				Checkbox(checked = surgeonCheckState, onCheckedChange = { surgeonCheckState = it })
				Text(text = stringResource(id = R.string.surgeon_speciality))
			}
			Row(
				horizontalArrangement = Arrangement.Start,
				verticalAlignment = Alignment.CenterVertically
			) {
				Checkbox(checked = clinicCheckState, onCheckedChange = { clinicCheckState = it })
				Text(text = stringResource(id = R.string.clinic_speciality))
			}
			Row(
				horizontalArrangement = Arrangement.Start,
				verticalAlignment = Alignment.CenterVertically
			) {
				Checkbox(checked = researchCheckState, onCheckedChange = { researchCheckState = it })
				Text(text = stringResource(id = R.string.research_speciality))
			}
		}
		Row(
			modifier = Modifier.fillMaxWidth(),
			horizontalArrangement = Arrangement.Start
		) {
			Row(
				horizontalArrangement = Arrangement.Start,
				verticalAlignment = Alignment.CenterVertically
			) {
				Checkbox(checked = laboratoryCheckState, onCheckedChange = { laboratoryCheckState = it })
				Text(text = stringResource(id = R.string.laboratory_speciality))
			}
			Row(
				horizontalArrangement = Arrangement.Start,
				verticalAlignment = Alignment.CenterVertically
			) {
				Checkbox(checked = anesthetistCheckState, onCheckedChange = { anesthetistCheckState = it })
				Text(text = stringResource(id = R.string.anhestetist_speciality))
			}
		}
		Row(
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			Checkbox(
				checked = veterinaryPharmacyCheckState,
				onCheckedChange = { veterinaryPharmacyCheckState = it })
			Text(text = stringResource(id = R.string.pharmacy_speciality))
		}
	}

	// -----------------------------------------------------------------------------------------------

	var dogCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	var catCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	var reptileCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	var birdCheckState by rememberSaveable {
		mutableStateOf(false)
	}

	var exoticCheckState by rememberSaveable {
		mutableStateOf(false)
	}


	Spacer(modifier = Modifier.height(16.dp))
	Text(
		text = stringResource(id = R.string.attended_animals),
		fontSize = 20.sp,
		fontWeight = FontWeight.Bold,
		color = MaterialTheme.colors.onBackground
	)
	Row(
		modifier = Modifier.fillMaxWidth(),
		horizontalArrangement = Arrangement.Start
	) {
		Row(
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			Checkbox(
				checked = dogCheckState,
				onCheckedChange = { dogCheckState = it },
				colors = CheckboxDefaults.colors(
					checkedColor = MaterialTheme.colors.secondary
				)
			)
			Text(text = stringResource(id = R.string.dog_animal_type))
		}
		Row(
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			Checkbox(
				checked = catCheckState,
				onCheckedChange = { catCheckState = it }
			)
			Text(text = stringResource(id = R.string.cat_animal_type))
		}
		Row(
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			Checkbox(
				checked = reptileCheckState,
				onCheckedChange = { reptileCheckState = it }
			)
			Text(text = stringResource(id = R.string.reptiles_animal_type))
		}
	}
	Row(
		horizontalArrangement = Arrangement.Start,
		verticalAlignment = Alignment.CenterVertically
	) {
		Checkbox(
			checked = birdCheckState,
			onCheckedChange = { birdCheckState = it }
		)
		Text(text = stringResource(id = R.string.birds_animal_type))

		Checkbox(
			checked = exoticCheckState,
			onCheckedChange = { exoticCheckState = it }
		)
		Text(text = stringResource(id = R.string.exotic_animal_type))
	}

	// -----------------------------------------------------------------------------------------------

	val customColors = TextFieldDefaults.textFieldColors(
		textColor = MaterialTheme.colors.onBackground,
		disabledTextColor = MaterialTheme.colors.onBackground,
		backgroundColor = Color.Transparent,
		cursorColor = MaterialTheme.colors.onBackground,
		errorCursorColor = MaterialTheme.colors.error,
		focusedIndicatorColor = MaterialTheme.colors.primaryVariant,
		unfocusedIndicatorColor = MaterialTheme.colors.onBackground,
		disabledIndicatorColor = MaterialTheme.colors.onBackground,
		errorIndicatorColor = MaterialTheme.colors.error,
		focusedLabelColor = MaterialTheme.colors.primary,
		unfocusedLabelColor = MaterialTheme.colors.onBackground,
		disabledLabelColor = MaterialTheme.colors.onBackground,
		trailingIconColor = MaterialTheme.colors.onBackground,
		placeholderColor = MaterialTheme.colors.onBackground
	)

	var occupationAreaState = ""
	var isErrorAtuationAreaState by rememberSaveable {
		mutableStateOf(false)
	}

	var crmvState = ""
	var isErrorCrmvState by rememberSaveable {
		mutableStateOf(false)
	}

	var formationState = ""
	var isErrorFormationState by rememberSaveable {
		mutableStateOf(false)
	}

	var institutionState = ""
	var isErrorInstitutionState by rememberSaveable {
		mutableStateOf(false)
	}

	Spacer(modifier = Modifier.height(16.dp))
	occupationAreaState = TextFieldInput(
		label = stringResource(id = R.string.atuation_area_professional),
		type = KeyboardType.Text,
		errorState = isErrorAtuationAreaState
	)
	Spacer(modifier = Modifier.height(16.dp))
	crmvState = TextFieldInput(
		label = stringResource(id = R.string.crmv_professional),
		type = KeyboardType.Text,
		errorState = isErrorCrmvState
	)
	Spacer(modifier = Modifier.height(16.dp))
	formationState = TextFieldInput(
		label = stringResource(id = R.string.formation_professional),
		type = KeyboardType.Text,
		errorState = isErrorFormationState
	)
	Spacer(modifier = Modifier.height(16.dp))
	institutionState = TextFieldInput(
		label = stringResource(id = R.string.institution_professional),
		type = KeyboardType.Text,
		errorState = isErrorInstitutionState
	)
	Spacer(modifier = Modifier.height(16.dp))

	// -----------------------------------------------------------------------------------------------

	var formationDateState by rememberSaveable { mutableStateOf("") }
	var isErrorFormationDateState by rememberSaveable { mutableStateOf(false) }

	var startAtuatingDateState by rememberSaveable { mutableStateOf("") }
	var isErrorStartAtuatingDateState by rememberSaveable { mutableStateOf(false) }

	val year: Int
	val month: Int
	val day: Int

	val calendar = Calendar.getInstance()
	year = calendar.get(Calendar.YEAR)
	month = calendar.get(Calendar.MONTH)
	day = calendar.get(Calendar.DAY_OF_MONTH)
	calendar.time = Date()


	val formationDatePickerDialog = DatePickerDialog(
		context,
		{ _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
			formationDateState = "$month/$dayOfMonth/$year"
		}, year, month, day
	)

	val startAtuatingDatePickerDialog = DatePickerDialog(
		context,
		{ _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
			startAtuatingDateState = "$month/$dayOfMonth/$year"
		}, year, month, day
	)

	TextField(
		value = formationDateState,
		onValueChange = { if (it.length <= 8) formationDateState = it },
		modifier = Modifier.fillMaxWidth(),
		enabled = false,
		label = { Text(text = stringResource(id = R.string.formation_date_professional)) },
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
		isError = isErrorFormationDateState,
		trailingIcon = {
			val image = Icons.Filled.CalendarMonth
			val description = "Calendar"

			IconButton(onClick = { formationDatePickerDialog.show() }) {
				val iconColor = if (isErrorFormationDateState)
					MaterialTheme.colors.error
				else MaterialTheme.colors.onBackground
				Icon(
					imageVector = image,
					contentDescription = description,
					tint = iconColor
				)
			}
		},
		singleLine = true,
		colors = customColors
	)
	Spacer(modifier = Modifier.height(16.dp))
	TextField(
		value = startAtuatingDateState,
		onValueChange = { if (it.length <= 8) formationDateState = it },
		modifier = Modifier.fillMaxWidth(),
		enabled = false,
		label = { Text(text = stringResource(id = R.string.start_atuating_date_professional)) },
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
		isError = isErrorStartAtuatingDateState,
		trailingIcon = {
			val image = Icons.Filled.CalendarMonth
			val description = "Calendar"

			IconButton(onClick = { startAtuatingDatePickerDialog.show() }) {
				val iconColor = if (isErrorAtuationAreaState)
					MaterialTheme.colors.error
				else MaterialTheme.colors.onBackground
				Icon(
					imageVector = image,
					contentDescription = description,
					tint = iconColor
				)
			}
		},
		singleLine = true,
		colors = customColors
	)
	Spacer(modifier = Modifier.height(32.dp))
	Button(
		onClick = {
			isErrorAtuationAreaState = validateEmptyInput(occupationAreaState)
			isErrorCrmvState = validateEmptyInput(crmvState)
			isErrorFormationState = validateEmptyInput(formationState)
			isErrorInstitutionState = validateEmptyInput(institutionState)
			isErrorFormationDateState = validateEmptyInput(formationDateState)
			isErrorStartAtuatingDateState = validateEmptyInput(startAtuatingDateState)

			if (
				isErrorAtuationAreaState ||
				isErrorCrmvState ||
				isErrorFormationState ||
				isErrorInstitutionState ||
				isErrorFormationState ||
				isErrorFormationDateState ||
				isErrorStartAtuatingDateState
			) {
				Toast.makeText(context, "Campos obrigatórios não preenchidos!", Toast.LENGTH_SHORT).show()
			} else {
				val vetInfos = VetInfos(
					crmv = crmvState,
					formation = formationState,
					formationDate = formationDateState,
					institution = institutionState,
					occupationArea = occupationAreaState,
					startActingDate = startAtuatingDateState
				)
				val userVetRegister = UserRegister(
					name = userInfosRegister.name,
					itp = userInfosRegister.itp,
					email = userInfosRegister.email,
					password = userInfosRegister.password,
					cellphoneNumber = userInfosRegister.cellphoneNumber,
					phoneNumber = userInfosRegister.phoneNumber,
					address = userInfosRegister.address,
					crmv = vetInfos.crmv,
					occupationArea = vetInfos.occupationArea,
					formation = vetInfos.formation,
					institution = vetInfos.institution,
					startActingDate = vetInfos.startActingDate,
					formationDate = vetInfos.formationDate
				)
				//Log.i("USER MODEL", userVetRegister.toString())
				// TODO: CADASTRO DE USUÁRIO VETERINARIO - ****CONCLUIDO****
				val userRegisterVet = createUserVet(userVetRegister) {
					Log.i("CREATE USER RESPONSE", it.toString())
					val id = it.id
					Toast.makeText(context, "Usuário criado com sucesso", Toast.LENGTH_SHORT).show()
					val openMainActivity = Intent(context, MainActivity::class.java)
					openMainActivity.putExtra("userID", id)
					startActivity(context, openMainActivity, null)
				}
			}
		},
		modifier = Modifier.fillMaxWidth(),
		shape = RoundedCornerShape(size = 5.dp),
		colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
	) {
		Text(
			text = stringResource(id = R.string.register_string_resource),
			fontSize = 24.sp,
			fontWeight = FontWeight.Bold,
			color = MaterialTheme.colors.onSecondary
		)
	}
	Spacer(modifier = Modifier.height(32.dp))
}

//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview4() {
//	PetSaudeAppTheme {
//		ProfessionalRegisterGlobal(userInfos = UserRegister(
//			"",
//			"",
//			"",
//			"",
//			"",
//			"",
//			Address(
//				"",
//				"",
//				"",
//				"",
//				"",
//				"",
//				""
//			),
//		))
//	}
//}