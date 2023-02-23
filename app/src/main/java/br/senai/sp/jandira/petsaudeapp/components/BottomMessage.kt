package br.senai.sp.jandira.petsaudeapp.components

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomMessage() {
	// TEST ONLY
	val context = LocalContext.current

	Box(
		modifier = Modifier.fillMaxWidth().padding(top = 100.dp),
		contentAlignment = Alignment.BottomCenter
	) {
		Row(
			modifier = Modifier.fillMaxWidth(),
			verticalAlignment = Alignment.CenterVertically,
			horizontalArrangement = Arrangement.Center,
		) {
			Text(
				text = "Ainda não tem uma conta? ",
				fontSize = 14.sp,
				fontWeight = FontWeight.Normal,
				color = Color.Black
			)
			Text(
				text = "Cadastre-se",
				modifier = Modifier.clickable(onClick = {
					Toast.makeText(context, "Deu certo!", Toast.LENGTH_SHORT).show()
				}),
				fontSize = 14.sp,
				fontWeight = FontWeight.Bold,
				color = Color.Black
			)
		}
	}
}
