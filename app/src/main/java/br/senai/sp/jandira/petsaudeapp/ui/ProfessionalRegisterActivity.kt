package br.senai.sp.jandira.petsaudeapp.ui

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
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
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.AuthHeaderTitle
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import java.util.*

class ProfessionalRegisterActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colors.background
				) {
					ProfessionalRegisterGlobal()
				}
			}
		}
	}
}

@Composable
fun ProfessionalRegisterGlobal() {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		ProfessionalRegisterHeader()
		ProfessionalRegisterForm()
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
fun ProfessionalRegisterForm() {
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

	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Text(
			text = "Especialidades",
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
					checked = surgeonCheckState,
					onCheckedChange = {surgeonCheckState = it},
					colors = CheckboxDefaults.colors(
						checkedColor = MaterialTheme.colors.secondary
					)
				)
				Text(text = "Cirurgião")
			}
			Row(
				horizontalArrangement = Arrangement.Start,
				verticalAlignment = Alignment.CenterVertically
			) {
				Checkbox(checked = clinicCheckState, onCheckedChange = {clinicCheckState = it})
				Text(text = "Clínica")
			}
			Row(
				horizontalArrangement = Arrangement.Start,
				verticalAlignment = Alignment.CenterVertically
			) {
				Checkbox(checked = researchCheckState, onCheckedChange = {researchCheckState = it})
				Text(text = "Pesquisa")
			}
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


	Spacer(modifier = Modifier.height(16.dp))
	Text(
		text = "Animais que atende",
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
				onCheckedChange = {dogCheckState = it},
				colors = CheckboxDefaults.colors(
					checkedColor = MaterialTheme.colors.secondary
				)
			)
			Text(text = "Cachorro")
		}
		Row(
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			Checkbox(
				checked = catCheckState,
				onCheckedChange = {catCheckState = it}
			)
			Text(text = "Gato")
		}
		Row(
			horizontalArrangement = Arrangement.Start,
			verticalAlignment = Alignment.CenterVertically
		) {
			Checkbox(
				checked = reptileCheckState,
				onCheckedChange = {reptileCheckState = it}
			)
			Text(text = "Aves")
		}
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

	var atuationAreaState by rememberSaveable {
		mutableStateOf("")
	}

	var crmvState by rememberSaveable {
		mutableStateOf("")
	}

	var formationState by rememberSaveable {
		mutableStateOf("")
	}

	var institutionState by rememberSaveable {
		mutableStateOf("")
	}

	TextField(
		value = atuationAreaState,
		onValueChange = {atuationAreaState = it},
		modifier = Modifier.fillMaxWidth(),
		label = {Text(text = "Área de atuação")},
		singleLine = true,
		colors = customColors
	)
	TextField(
		value = crmvState,
		onValueChange = { if (it.length <= 4) crmvState = it },
		modifier = Modifier.fillMaxWidth(),
		label = {Text(text = "CRMV")},
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
		singleLine = true,
		colors = customColors
	)
	TextField(
		value = formationState,
		onValueChange = {formationState = it},
		modifier = Modifier.fillMaxWidth(),
		label = {Text(text = "Formação")},
		singleLine = true,
		colors = customColors
	)
	TextField(
		value = institutionState,
		onValueChange = {institutionState = it},
		modifier = Modifier.fillMaxWidth(),
		label = {Text(text = "Instituição")},
		singleLine = true,
		colors = customColors
	)

	// -----------------------------------------------------------------------------------------------

	val year: Int
	val month: Int
	val day: Int

	val calendar = Calendar.getInstance()
	year = calendar.get(Calendar.YEAR)
	month = calendar.get(Calendar.MONTH)
	day = calendar.get(Calendar.DAY_OF_MONTH)
	calendar.time = Date()

	var date by rememberSaveable {mutableStateOf("")}
	val datePickerDialog = DatePickerDialog(
		context,
		{_: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
			date = "$month/$dayOfMonth/$year"
		}, year, month, day
	)

	OutlinedButton(onClick = { datePickerDialog.show() }) {
		Text(text = "Data de formação: $date")
	}

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview4() {
	PetSaudeAppTheme {
		ProfessionalRegisterGlobal()
	}
}