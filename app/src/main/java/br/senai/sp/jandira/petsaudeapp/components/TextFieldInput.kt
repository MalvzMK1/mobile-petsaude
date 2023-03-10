package br.senai.sp.jandira.petsaudeapp.components

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import br.senai.sp.jandira.petsaudeapp.R

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
		colors = customColors
	)

	return thisPasswordInputState
}

//@Composable
//fun MaskedPhoneNumberInput(label: String): String {
//	val customColors = TextFieldDefaults.textFieldColors(
//		textColor = MaterialTheme.colors.onBackground,
//		disabledTextColor = MaterialTheme.colors.onBackground,
//		backgroundColor = Color.Transparent,
//		cursorColor = MaterialTheme.colors.onBackground,
//		errorCursorColor = MaterialTheme.colors.error,
//		focusedIndicatorColor = MaterialTheme.colors.primaryVariant,
//		unfocusedIndicatorColor = MaterialTheme.colors.onBackground,
//		disabledIndicatorColor = MaterialTheme.colors.onBackground,
//		errorIndicatorColor = MaterialTheme.colors.error,
//		focusedLabelColor = MaterialTheme.colors.primary,
//		unfocusedLabelColor = MaterialTheme.colors.onBackground,
//		disabledLabelColor = MaterialTheme.colors.onBackground,
//		trailingIconColor = MaterialTheme.colors.onBackground,
//		placeholderColor = MaterialTheme.colors.onBackground
//	)
//
//	var thisPhoneNumberState by rememberSaveable {
//		mutableStateOf("")
//	}
//
//	TextField(
//		value = thisPhoneNumberState,
//		onValueChange = {
//			thisPhoneNumberState = it
//		},
//		modifier = Modifier
//			.fillMaxWidth(),
//		label = { Text(text = label) },
//		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
//		colors = customColors
//	)
//
//	return thisPhoneNumberState
//}
