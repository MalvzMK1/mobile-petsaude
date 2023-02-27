package br.senai.sp.jandira.petsaudeapp.ui.theme

import android.app.Activity
import  androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView

private val DarkColorPalette = darkColors(
	primary = Green400,
	primaryVariant = Green500,
	secondary = Blue600,
	background = White100,
	onBackground = Black700
)

private val LightColorPalette = lightColors(
	primary = Green400,
	primaryVariant = Green500,
	secondary = Blue600,
	background = White100,
	onBackground = Black700
)

@Composable
fun PetSaudeAppTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
	val colors = if (darkTheme) {
		DarkColorPalette
	} else {
		LightColorPalette
	}

	val view = LocalView.current
	if (!view.isInEditMode) {
		SideEffect {
			val window = (view.context as Activity).window
			window.statusBarColor = colors.secondary.toArgb()
			window.navigationBarColor = colors.onBackground.toArgb()
		}
	}

	MaterialTheme(
		colors = colors,
		typography = Typography,
		shapes = Shapes,
		content = content
	)
}