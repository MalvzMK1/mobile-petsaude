package br.senai.sp.jandira.petsaudeapp.components

import br.senai.sp.jandira.petsaudeapp.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GoogleAuthColumn() {
	Button(
		onClick = {
//				TODO: FIREBASE AUTHENTICATION
		},
		modifier = Modifier.size(60.dp),
		shape = RoundedCornerShape(50),
		colors = ButtonDefaults.buttonColors(Color.LightGray)
	) {
		Image(
			painter = painterResource(id = R.drawable.google_logo),
			contentDescription = "Google Logo",
			modifier = Modifier.fillMaxSize()
		)
	}
	Spacer(modifier = Modifier.height(32.dp))
	Row(
		modifier = Modifier
			.fillMaxWidth(),
		horizontalArrangement = Arrangement.Center,
		verticalAlignment = Alignment.CenterVertically
	) {
		Spacer(
			modifier = Modifier
				.height(1.dp)
				.width(100.dp)
				.background(color = Color.LightGray)
		)
		Text(
			text = "Ou use o e-mail",
			modifier = Modifier.padding(start = 10.dp, end = 10.dp),
			color = Color.LightGray,
			fontSize = 14.sp,
			fontWeight = FontWeight.Normal,
			textAlign = TextAlign.Center
		)
		Spacer(
			modifier = Modifier
				.height(1.dp)
				.width(100.dp)
				.background(color = Color.LightGray)
		)
	}
}

@Composable
@Preview
fun GoogleAuthColumnPreview() {
	GoogleAuthColumn()
}