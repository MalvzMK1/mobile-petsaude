package br.senai.sp.jandira.petsaudeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun AuthHeaderTitle(title: String, subtitle: String) {
	Column(
		modifier = Modifier.fillMaxWidth(),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		Text(
			text = title,
			color = MaterialTheme.colors.onBackground,
			fontSize = 32.sp,
			fontWeight = FontWeight.Bold,
			textAlign = TextAlign.Center
		)
		Text(
			text = subtitle,
			color = MaterialTheme.colors.onBackground,
			fontSize = 16.sp,
			fontWeight = FontWeight.Normal,
			textAlign = TextAlign.Center
		)
	}
}