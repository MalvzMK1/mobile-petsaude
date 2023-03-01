package br.senai.sp.jandira.petsaudeapp.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.AuthHeaderTitle
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import br.senai.sp.jandira.petsaudeapp.utils.ZipCodeTransformation

class RegisterAddressActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				Surface(
					modifier = Modifier
						.fillMaxSize()
						.verticalScroll(rememberScrollState()),
					color = MaterialTheme.colors.background
				)
				{
					GlobalLocalization()
				}
			}
		}
	}
}

@Composable
fun GlobalLocalization() {
	val context = LocalContext.current

	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp),
		verticalArrangement = Arrangement.SpaceEvenly
	) {
		LocalizationHeader()
		LocalizationForm()
		Box(
			modifier = Modifier
				.fillMaxWidth()
				.padding(top = 32.dp),
			contentAlignment = Alignment.BottomCenter
		) {
			Row(
				modifier = Modifier.fillMaxWidth(),
				verticalAlignment = Alignment.CenterVertically,
				horizontalArrangement = Arrangement.Center,
			) {
				Text(
					text = "${stringResource(id = R.string.already_have_account_bottom_message)} ",
					fontSize = 14.sp,
					fontWeight = FontWeight.Normal,
					color = MaterialTheme.colors.onBackground
				)
				Text(
					text = stringResource(id = R.string.login_bottom_message),
					modifier = Modifier.clickable {
						val openRegisterActivity = Intent(context, RegisterActivity::class.java)
						startActivity(context, openRegisterActivity, null)
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
fun LocalizationHeader() {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.padding(top = 32.dp),
		verticalArrangement = Arrangement.SpaceBetween,
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		AuthHeaderTitle(
			title = stringResource(id = R.string.can_we_know_address_register_header),
			subtitle = stringResource(id = R.string.message_address_register_header)
		)
		Spacer(modifier = Modifier.height(32.dp))
	}
}

@Composable
fun LocalizationForm() {
	val context = LocalContext.current

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

	var cepState by rememberSaveable() {
		mutableStateOf("")
	}

	var cityState by rememberSaveable() {
		mutableStateOf("")
	}

	var stateState by rememberSaveable() {
		mutableStateOf("")
	}

	var streetState by rememberSaveable() {
		mutableStateOf("")
	}

	var neighborhoodState by rememberSaveable() {
		mutableStateOf("")
	}

	var numberState by rememberSaveable() {
		mutableStateOf("")
	}

	var complementState by rememberSaveable() {
		mutableStateOf("")
	}

	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		TextField(
			value = cepState,
			onValueChange = {
				if (it.length <= 8) cepState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = stringResource(id = R.string.zip_code_string_resource)) },
			visualTransformation = ZipCodeTransformation(),
			keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
			singleLine = true,
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = cityState,
			onValueChange = {
				cityState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = stringResource(id = R.string.city_string_resource)) },
			singleLine = true,
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = stateState,
			onValueChange = {
				stateState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = stringResource(id = R.string.state_string_resource)) },
			singleLine = true,
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = streetState,
			onValueChange = {
				streetState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = stringResource(id = R.string.street_string_resource)) },
			singleLine = true,
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = neighborhoodState,
			onValueChange = {
				neighborhoodState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = stringResource(id = R.string.neighborhood_string_resource)) },
			singleLine = true,
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = numberState,
			onValueChange = {
				numberState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = stringResource(id = R.string.house_number_string_resource)) },
			singleLine = true,
			colors = customColors
		)
		Spacer(Modifier.height(16.dp))
		TextField(
			value = complementState,
			onValueChange = {
				complementState = it
			},
			modifier = Modifier.fillMaxWidth(),
			label = { Text(text = stringResource(id = R.string.complement_string_resource)) },
			singleLine = true,
			colors = customColors
		)
		Spacer(Modifier.height(32.dp))
		Row(
			modifier = Modifier.padding(bottom = 32.dp),
			horizontalArrangement = Arrangement.SpaceBetween
		) {
			Button(
				onClick = {
					// TODO: USER LOGIN
				},
				modifier = Modifier
					.fillMaxWidth(0.5f)
					.defaultMinSize(minHeight = 50.dp),
				shape = RoundedCornerShape(size = 5.dp),
				colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
			) {
				Text(
					text = stringResource(id = R.string.im_client_button_string),
					fontSize = 18.sp,
					fontWeight = FontWeight.Bold,
					color = MaterialTheme.colors.onSecondary
				)
			}
			Spacer(Modifier.width(4.dp))
			Button(
				onClick = {
					val openProfessionalRegisterActivity =
						Intent(context, ProfessionalRegisterActivity::class.java)
					startActivity(context, openProfessionalRegisterActivity, null)
				},
				modifier = Modifier
					.fillMaxWidth()
					.defaultMinSize(minHeight = 50.dp),
				shape = RoundedCornerShape(size = 5.dp),
				colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
			) {
				Text(
					text = stringResource(id = R.string.im_professional_button_string),
					color = MaterialTheme.colors.onSecondary,
					fontSize = 18.sp,
					fontWeight = FontWeight.Bold,
					textAlign = TextAlign.Center
				)
			}
		}
	}
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview3() {
	PetSaudeAppTheme {
		GlobalLocalization()
	}
}