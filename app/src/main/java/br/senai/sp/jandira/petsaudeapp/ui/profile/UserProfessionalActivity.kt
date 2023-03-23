package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
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
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.ConfigHeader
import br.senai.sp.jandira.petsaudeapp.components.OutlinedTextFieldInput
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import br.senai.sp.jandira.petsaudeapp.utils.validateEmptyInput
import java.util.*

class UserProfessionalActivity : ComponentActivity() {
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
					GlobalUserProfessional()
				}
			}
		}
	}
}
@Composable
fun GlobalUserProfessional() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		ConfigHeader(headline = stringResource(id = R.string.user_config_professional_information))
		ProfessionalPreferences()
	}
}
@Composable
fun ProfessionalPreferences() {
	val context = LocalContext.current

	var atuationAreaState = ""
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

	Column(
		modifier = Modifier
			.fillMaxSize()
	) {
		Spacer(modifier = Modifier.height(10.dp))
		atuationAreaState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.atuation_area_professional),
			type = KeyboardType.Text,
			errorState = isErrorAtuationAreaState
		)
		crmvState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.crmv_professional),
			type = KeyboardType.Number, 
			errorState = isErrorCrmvState
		)
		formationState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.formation_professional),
			type = KeyboardType.Text,
			errorState = isErrorFormationState
		)
		institutionState = OutlinedTextFieldInput(
			label = stringResource(id = R.string.institution_professional),
			type = KeyboardType.Text, 
			errorState = isErrorInstitutionState
		)
		OutlinedTextField(
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
		OutlinedTextField(
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

		Spacer(modifier = Modifier.height(4.dp))
		Text(
			text = stringResource(id = R.string.attended_animals),
			fontSize = 18.sp,
			fontWeight = FontWeight.W500,
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
		Spacer(modifier = Modifier.height(4.dp))
		Column(
			modifier = Modifier.fillMaxWidth()
		) {
			Text(
				text = stringResource(id = R.string.specialities_string_resource),
				fontSize = 18.sp,
				fontWeight = FontWeight.W500,
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
		Spacer(modifier = Modifier.height(24.dp))
		Button(
			onClick = {
				isErrorAtuationAreaState = validateEmptyInput(atuationAreaState)
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
					Toast.makeText(context, "Campos vazios", Toast.LENGTH_SHORT).show()
				}
			},
			modifier = Modifier
				.height(50.dp)
				.fillMaxWidth(),
			shape = RoundedCornerShape(100.dp),
			colors = ButtonDefaults.buttonColors(Color(158,209,183))
		) {
			Text(
				text = stringResource(id = R.string.user_config_save_edit_user),
				fontSize = 16.sp
			)
		}
	}
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview9() {
	PetSaudeAppTheme {
		GlobalUserProfessional()
	}
}