package br.senai.sp.jandira.petsaudeapp.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import br.senai.sp.jandira.petsaudeapp.R

@Composable
fun TextFieldInput(label: String, type: KeyboardType): String {
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
		onValueChange = { thisInputState = it },
		modifier = Modifier.fillMaxWidth(),
		label = { Text(text = label) },
		keyboardOptions = KeyboardOptions(keyboardType = type),
		colors = customColors
	)

	return thisInputState
}

@Composable
fun PasswordInputHideShowIcon(label: String): String {
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
		},
		visualTransformation = if (isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
		modifier = Modifier
			.fillMaxWidth(),
		label = { Text(text = stringResource(id = R.string.password_string_resource)) },
		trailingIcon = {
			val image = if (isPasswordVisible)
				Icons.Filled.Visibility
			else Icons.Filled.VisibilityOff

			val description = if (isPasswordVisible) stringResource(id = R.string.hide_pass_alt) else stringResource(id = R.string.show_pass_alt)

			IconButton(onClick = { isPasswordVisible = !isPasswordVisible }) {
				Icon(
					imageVector = image,
					contentDescription = description
				)
			}
		},
		keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
		colors = customColors
	)

	return thisPasswordInputState
}