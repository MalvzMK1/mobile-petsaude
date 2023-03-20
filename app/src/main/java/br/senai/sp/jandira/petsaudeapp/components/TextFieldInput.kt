package br.senai.sp.jandira.petsaudeapp.components

import android.util.Log
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.onKeyEvent
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.utils.CellPhoneNumberTransformation
import br.senai.sp.jandira.petsaudeapp.utils.PhoneNumberTransformation
import br.senai.sp.jandira.petsaudeapp.utils.ZipCodeTransformation

@Composable
fun TextFieldInput(label: String, type: KeyboardType, errorState: Boolean): String {
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

	var error = errorState

	var thisInputState by rememberSaveable {
		mutableStateOf("")
	}

	TextField(
		value = thisInputState,
		onValueChange = {
			thisInputState = it
			error = false
		},
		modifier = Modifier.fillMaxWidth(),
		label = { Text(text = label) },
		isError = error,
		keyboardOptions = KeyboardOptions(keyboardType = type),
		singleLine = true,
		colors = customColors
	)

	return thisInputState
}

@Composable
fun PasswordInputHideShowIcon(label: String, errorState: Boolean): String {
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

	var error = errorState

	var thisPasswordInputState by rememberSaveable {
		mutableStateOf("")
	}

	var isPasswordVisible by rememberSaveable {
		mutableStateOf(false)
	}

	TextField(
		value = thisPasswordInputState,
		onValueChange = {
			thisPasswordInputState = it
			error = false
		},
		visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
		modifier = Modifier
			.fillMaxWidth(),
		label = { Text(text = label) },
		trailingIcon = {
			val image = if (isPasswordVisible)
				Icons.Filled.Visibility
			else Icons.Filled.VisibilityOff

			val description =
				if (isPasswordVisible) stringResource(id = R.string.hide_pass_alt) else stringResource(id = R.string.show_pass_alt)

			IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
				Icon(
					imageVector = image,
					contentDescription = description
				)
			}
		},
		isError = error,
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
		singleLine = true,
		colors = customColors
	)

	return thisPasswordInputState
}

@Composable
fun MaskedPhoneNumberInput(label: String, errorState: Boolean): String {
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

	var thisPhoneNumberState by rememberSaveable {
		mutableStateOf("")
	}

	TextField(
		value = thisPhoneNumberState,
		onValueChange = { if (it.length <= 12) thisPhoneNumberState = it },
		modifier = Modifier
			.fillMaxWidth(),
		label = { Text(text = label) },
		isError = errorState,
		visualTransformation = PhoneNumberTransformation(),
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
		singleLine = true,
		colors = customColors
	)

	return thisPhoneNumberState
}

@Composable
fun MaskedCellphoneNumberInput(label: String, errorState: Boolean): String {
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

	var thisPhoneNumberState by rememberSaveable {
		mutableStateOf("")
	}

	TextField(
		value = thisPhoneNumberState,
		onValueChange = { if (it.length <= 13) thisPhoneNumberState = it },
		modifier = Modifier
			.fillMaxWidth(),
		label = { Text(text = label) },
		isError = errorState,
		visualTransformation = CellPhoneNumberTransformation(),
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
		singleLine = true,
		colors = customColors
	)

	return thisPhoneNumberState
}


@Composable
fun MaskedZipCodeInput(label: String, errorState: Boolean): String {
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

	var thisInputState by rememberSaveable {
		mutableStateOf("")
	}

	TextField(
		value = thisInputState,
		onValueChange = { if (it.length <= 8) thisInputState = it },
		modifier = Modifier
			.fillMaxWidth()
			.onKeyEvent {
				Log.i("key", it.key.toString())
				true

			},
		label = { Text(text = label) },
		isError = errorState,
		visualTransformation = ZipCodeTransformation(),
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
		singleLine = true,
		colors = customColors
	)

	return thisInputState
}
