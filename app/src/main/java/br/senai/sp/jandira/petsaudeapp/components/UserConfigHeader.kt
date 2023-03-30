package br.senai.sp.jandira.petsaudeapp.components

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import br.senai.sp.jandira.petsaudeapp.ui.profile.GlobalUserConfig
import br.senai.sp.jandira.petsaudeapp.ui.profile.UserConfigActivity
import br.senai.sp.jandira.petsaudeapp.ui.profile.UserInfoPersonalActivity
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme

@Composable
fun ConfigHeader(headline: String, context: Context, icon: ImageVector) {
	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Row(
			modifier = Modifier
				.fillMaxWidth(),
			horizontalArrangement = Arrangement.SpaceBetween,
			verticalAlignment = Alignment.CenterVertically
		) {
			IconButton(
				onClick = {
//					val openUserConfigActivity = Intent(context, UserConfigActivity::class.java)
//					ContextCompat.startActivity(context, openUserConfigActivity, null)
				}
			) {
				Icon(
					imageVector = Icons.Filled.Menu,
					contentDescription = "leftSideButtonHeader",
					modifier = Modifier.size(32.dp)
				)
			}
			Text(
				text = headline,
				modifier = Modifier.width(200.dp),
				fontSize = 24.sp,
				fontWeight = FontWeight.W500,
				textAlign = TextAlign.Center
			)
			IconButton(
				onClick = {
					val openUserConfigActivity = Intent(context, UserConfigActivity::class.java)
					ContextCompat.startActivity(context, openUserConfigActivity, null)
				}
			) {
				Icon(
					imageVector = icon,
					contentDescription = "rightSideButtonHeader",
					modifier = Modifier.size(30.dp)
				)
			}
		}
	}
}
