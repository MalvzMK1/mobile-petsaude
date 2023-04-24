package br.senai.sp.jandira.petsaudeapp.ui.profile

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import android.graphics.Paint.Align
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import android.widget.ImageButton
import android.widget.TimePicker
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material.icons.rounded.Share
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.sp.jandira.petsaudeapp.R
import br.senai.sp.jandira.petsaudeapp.components.ConfigHeader
import br.senai.sp.jandira.petsaudeapp.model.PetsCard
import br.senai.sp.jandira.petsaudeapp.model.Reviews
import br.senai.sp.jandira.petsaudeapp.ui.theme.PetSaudeAppTheme
import com.google.android.material.transition.MaterialContainerTransform.FitMode
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapProperties
import com.google.maps.android.compose.MapType
import java.sql.Time
import java.text.SimpleDateFormat
import java.util.*

class ProfileVisityActivity : ComponentActivity() {
	override fun onCreate(savedInstanceState: Bundle?) {
		val idUser: Int = intent.getSerializableExtra("userID") as Int
		Log.i("RESPONSE SUCCESS - ID PERFIL", idUser.toString())
		val isVetUser: Boolean = intent.getSerializableExtra("isVetUser") as Boolean
		Log.i("RESPONSE SUCCESS - ISVET PERFIL", isVetUser.toString())
		super.onCreate(savedInstanceState)
		setContent {
			PetSaudeAppTheme {
				// A surface container using the 'background' color from the theme
				Surface(
					modifier = Modifier
						.fillMaxSize()
						.verticalScroll(rememberScrollState()),
					color = MaterialTheme.colors.background
				) {
					GlobalProfileVisity(this, idUser, isVetUser)
				}
			}
		}
	}
}

@Composable
fun GlobalProfileVisity(context: Context, idUser: Number, isVetUser: Boolean) {
	Column(
		modifier = Modifier
			.fillMaxSize()
			.padding(12.dp)
	) {
		ConfigHeader(
			headline = stringResource(id = R.string.empty_string),
			context,
			icon = Icons.Filled.Settings
		)
		if (isVetUser) {
			PersonProfessional()
			AvaliationProfessional()
			InformationAcademyProfessional()
			LocalizationProfile()
		} else {
			ProfileUser()
			PetsFromUser()
			LocalizationProfile()
		}
	}
}

@Composable
fun PersonProfessional() {
	val context = LocalContext.current

	var expandState by remember {
		mutableStateOf(false)
	}
	var expandAboutMe by remember {
		mutableStateOf(false)
	}
	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Row(
			modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
		) {
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp), elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.total_queries_profile),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						Text(
							//Inserir dados da API//
							text = "it.NumberQueries",
							modifier = Modifier.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
			Spacer(modifier = Modifier.width(12.dp))
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp),
				backgroundColor = Color(227, 239, 240),
				elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.score_professional),
							color = Color(9, 115, 138),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						Text(
							//Inserir dados da API//
							text = "it.Score",
							color = Color(9, 115, 138),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
		}
		Spacer(modifier = Modifier.height(16.dp))
		Button(
			onClick = {
				expandState = true
			},
			modifier = Modifier
				.fillMaxWidth()
				.height(35.dp),
			colors = ButtonDefaults.buttonColors(Color(132, 207, 126))
		) {
			Text(
				text = stringResource(id = R.string.to_schedule_an_appointment_profile),
				modifier = Modifier.fillMaxWidth(),
				color = Color(28, 27, 31),
				fontSize = 14.sp,
				fontWeight = FontWeight.Bold,
				textAlign = TextAlign.Center
			)
		}
		Spacer(modifier = Modifier.height(24.dp))
		Column(
			modifier = Modifier.fillMaxWidth()
		) {
			Text(
				text = stringResource(id = R.string.about_me_profile),
				modifier = Modifier.fillMaxWidth(),
				fontSize = 18.sp,
				fontWeight = FontWeight.W600,
				textAlign = TextAlign.Start
			)
			Text(
				//Inserir dados da API//
				text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet quam sapien, in porta mi tristique necLorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet quam sapien, in porta mi tristique nec. Se Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet quam sapien, in porta mi tristique nec. See ",
				overflow = TextOverflow.Ellipsis,
				maxLines = if (expandAboutMe) 50 else 3,
				modifier = Modifier.fillMaxWidth(),
				color = Color(169, 169, 169),
				fontSize = 14.sp,
				fontWeight = FontWeight.W400
			)
			Row(
				modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
			) {
				Text(
					text = if (expandAboutMe) stringResource(id = R.string.about_me_read_less) else stringResource(
						id = R.string.about_me_read_more
					),
					modifier = Modifier.clickable { expandAboutMe = !expandAboutMe },
					color = Color(9, 115, 138),
					fontSize = 12.sp,
					fontWeight = FontWeight.W500
				)
			}
		}
	}
	var dateState by rememberSaveable { mutableStateOf("") }
	var isErrorDateState by rememberSaveable { mutableStateOf(false) }

	var timeState by rememberSaveable { mutableStateOf("") }
	var isErrorTimeState by rememberSaveable { mutableStateOf(false) }
	val timeFormat = "HH:mm"
	val timeFormatDisplay = SimpleDateFormat(timeFormat, Locale.getDefault())

	val year: Int
	val month: Int
	val day: Int
	val hour: Int
	val minute: Int

	val calendar = Calendar.getInstance()
	year = calendar.get(Calendar.YEAR)
	month = calendar.get(Calendar.MONTH)
	day = calendar.get(Calendar.DAY_OF_MONTH)
	hour = calendar.get(Calendar.HOUR_OF_DAY)
	minute = calendar.get(Calendar.MINUTE)
	calendar.time = Date()

	val datePickerDialog = DatePickerDialog(
		context, { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
			dateState = "$month/$dayOfMonth/$year"
		}, year, month, day
	)
	val timePickerDialog = TimePickerDialog(
		context, { _, hour: Int, minute: Int ->
			timeState = "$hour:$minute"
		}, hour, minute, true
	)
	AnimatedVisibility(
		visible = expandState,
		enter = slideInVertically(tween(durationMillis = 500)) + expandVertically(expandFrom = Alignment.Top) + fadeIn(
			initialAlpha = 0.3f
		),
		exit = slideOutVertically(tween(durationMillis = 500)) + shrinkVertically() + fadeOut(
			targetAlpha = 0.3f
		)
	) {
		Card(
			modifier = Modifier
				.fillMaxWidth()
				.wrapContentHeight(),
			shape = RoundedCornerShape(12.dp),
			border = BorderStroke(0.5.dp, Color(202, 196, 208))
		) {
			Column(
				modifier = Modifier
					.fillMaxWidth()
					.padding(12.dp)
			) {
				Text(
					text = stringResource(id = R.string.select_the_animal_agendamento),
					modifier = Modifier.fillMaxWidth(),
					color = Color.Black,
					fontSize = 28.sp,
					fontWeight = FontWeight.W400,
					textAlign = TextAlign.Center
				)
				Spacer(modifier = Modifier.height(14.dp))
				Box(
					modifier = Modifier.border(
						width = 0.5.dp, color = Color(202, 196, 208), shape = RoundedCornerShape(5.dp)
					)
				) {
					Column(
						modifier = Modifier
							.fillMaxWidth()
							.height(82.dp)
							.verticalScroll(rememberScrollState())
					) {
						Card(
							border = BorderStroke(0.5.dp, Color(202, 196, 208))
						) {
							Row(
								modifier = Modifier
									.fillMaxWidth()
									.height(82.dp)
									.padding(12.dp),
								verticalAlignment = Alignment.CenterVertically
							) {
								Image(
									//COLOCAR A IMAGEM DO PET A SER ATENDIDO//
									painter = painterResource(id = R.drawable.media),
									contentDescription = "Imagem do Pet",
									modifier = Modifier.size(58.dp),
									contentScale = ContentScale.Crop
								)
								Spacer(modifier = Modifier.width(12.dp))
								Text(
									//COLOCAR A NOME DO PET A SER ATENDIDO//
									text = "it.namePet",
									fontSize = 20.sp,
									fontWeight = FontWeight.W400,
								)
							}
						}
						Card(
							border = BorderStroke(0.5.dp, Color(202, 196, 208))
						) {
							Row(
								modifier = Modifier
									.fillMaxWidth()
									.height(70.dp)
									.padding(12.dp),
								verticalAlignment = Alignment.CenterVertically
							) {
								Image(
									//COLOCAR A IMAGEM DO PET A SER ATENDIDO//
									painter = painterResource(id = R.drawable.media),
									contentDescription = "Imagem do Pet",
									modifier = Modifier.size(58.dp),
									contentScale = ContentScale.Crop
								)
								Spacer(modifier = Modifier.width(12.dp))
								Text(
									//COLOCAR A NOME DO PET A SER ATENDIDO//
									text = "it.namePet",
									fontSize = 20.sp,
									fontWeight = FontWeight.W400,
								)
							}
						}
						Card(
							border = BorderStroke(0.5.dp, Color(202, 196, 208))
						) {
							Row(
								modifier = Modifier
									.fillMaxWidth()
									.height(70.dp)
									.padding(12.dp),
								verticalAlignment = Alignment.CenterVertically
							) {
								Image(
									//COLOCAR A IMAGEM DO PET A SER ATENDIDO//
									painter = painterResource(id = R.drawable.media),
									contentDescription = "Imagem do Pet",
									modifier = Modifier.size(58.dp),
									contentScale = ContentScale.Crop
								)
								Spacer(modifier = Modifier.width(12.dp))
								Text(
									//COLOCAR A NOME DO PET A SER ATENDIDO//
									text = "it.namePet",
									fontSize = 20.sp,
									fontWeight = FontWeight.W400,
								)
							}
						}
						Card(
							border = BorderStroke(0.5.dp, Color(202, 196, 208))
						) {
							Row(
								modifier = Modifier
									.fillMaxWidth()
									.height(70.dp)
									.padding(12.dp),
								verticalAlignment = Alignment.CenterVertically
							) {
								Image(
									//COLOCAR A IMAGEM DO PET A SER ATENDIDO//
									painter = painterResource(id = R.drawable.media),
									contentDescription = "Imagem do Pet",
									modifier = Modifier.size(58.dp),
									contentScale = ContentScale.Crop
								)
								Spacer(modifier = Modifier.width(12.dp))
								Text(
									//COLOCAR A NOME DO PET A SER ATENDIDO//
									text = "it.namePet",
									fontSize = 20.sp,
									fontWeight = FontWeight.W400,
								)
							}
						}
					}
				}
				Spacer(modifier = Modifier.height(14.dp))
				Text(
					text = stringResource(id = R.string.date_and_time_agendamento),
					modifier = Modifier.fillMaxWidth(),
					color = Color.Black,
					fontSize = 28.sp,
					fontWeight = FontWeight.W400,
					textAlign = TextAlign.Center
				)
				OutlinedTextField(
					value = dateState,
					onValueChange = { if (it.length <= 8) dateState = it },
					modifier = Modifier.fillMaxWidth(),
					enabled = false,
					label = { Text(text = stringResource(id = R.string.date_agendamento)) },
					keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
					isError = isErrorDateState,
					trailingIcon = {
						val image = Icons.Filled.CalendarMonth
						val description = "Calendar"

						IconButton(onClick = { datePickerDialog.show() }) {
							val iconColor = if (isErrorDateState) MaterialTheme.colors.error
							else MaterialTheme.colors.onBackground
							Icon(
								imageVector = image, contentDescription = description, tint = iconColor
							)
						}
					},
					singleLine = true,
				)
				Spacer(modifier = Modifier.height(14.dp))
				OutlinedTextField(
//					value = timeFormatDisplay.format(calendar.time),
					value = timeState,
					onValueChange = { },
					modifier = Modifier.fillMaxWidth(),
					enabled = false,
					label = { Text(text = stringResource(id = R.string.time_agendamento)) },
					keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
					isError = isErrorTimeState,
					trailingIcon = {
//						val image = Icons.Default.AccessTime
						val image = Icons.Default.HistoryToggleOff
						val description = "Timer"
						IconButton(onClick = { timePickerDialog.show() }) {
							val iconColor = if (isErrorTimeState) MaterialTheme.colors.error
							else MaterialTheme.colors.onBackground
							Icon(
								imageVector = image, contentDescription = description, tint = iconColor
							)
						}
					},
					singleLine = true
				)
				Spacer(modifier = Modifier.height(12.dp))
				Row(
					modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
				) {
					Button(
						onClick = { expandState = false },
						shape = RoundedCornerShape(32.dp),
						colors = ButtonDefaults.buttonColors(Color(249, 222, 220))
					) {
						Text(
							text = stringResource(id = R.string.cancel_agendamento), color = Color(65, 14, 11)
						)
					}
					Button(
						onClick = { expandState = false },
						shape = RoundedCornerShape(32.dp),
						colors = ButtonDefaults.buttonColors(Color(158, 209, 183))
					) {
						Text(
							text = stringResource(id = R.string.to_mark_agendamento), color = Color(65, 86, 75)
						)
					}
				}
			}
		}
	}
}

@Composable
fun ProfileUser() {
	var expandAboutMe by remember {
		mutableStateOf(false)
	}
	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Row(
			modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
		) {
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp), elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.finished_appointments_profile),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						Text(
							//Inserir dados da API//
							text = "it.finishedAppointments",
							modifier = Modifier.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
			Spacer(modifier = Modifier.width(12.dp))
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp),
				backgroundColor = Color(227, 239, 240),
				elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.score_professional),
							color = Color(9, 115, 138),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						Text(
							//Inserir dados da API//
							text = "it.Score",
							color = Color(9, 115, 138),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
		}
		Spacer(modifier = Modifier.height(16.dp))
		Column(
			modifier = Modifier.fillMaxWidth()
		) {
			Text(
				text = stringResource(id = R.string.about_me_profile),
				modifier = Modifier.fillMaxWidth(),
				fontSize = 18.sp,
				fontWeight = FontWeight.W600,
				textAlign = TextAlign.Start
			)
			Text(
				//Inserir dados da API//
				text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet quam sapien, in porta mi tristique necLorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet quam sapien, in porta mi tristique nec. Se Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed aliquet quam sapien, in porta mi tristique nec. See ",
				overflow = TextOverflow.Ellipsis,
				maxLines = if (expandAboutMe) 50 else 3,
				modifier = Modifier.fillMaxWidth(),
				color = Color(169, 169, 169),
				fontSize = 14.sp,
				fontWeight = FontWeight.W400
			)
			Row(
				modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End
			) {
				Text(
					text = if (expandAboutMe) stringResource(id = R.string.about_me_read_less) else stringResource(
						id = R.string.about_me_read_more
					),
					modifier = Modifier.clickable { expandAboutMe = !expandAboutMe },
					color = Color(9, 115, 138),
					fontSize = 12.sp,
					fontWeight = FontWeight.W500
				)
			}
		}
	}
}

@Composable
fun PetsFromUser() {
	var pets by rememberSaveable() {
		mutableStateOf(listOf<PetsCard>())
	}
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.height(760.dp)
	) {
		Spacer(modifier = Modifier.height(12.dp))
		Text(
			text = stringResource(id = R.string.user_config_pets),
			modifier = Modifier.fillMaxWidth(),
			fontSize = 18.sp,
			fontWeight = FontWeight.W600,
			textAlign = TextAlign.Start
		)
		Spacer(modifier = Modifier.height(2.dp))
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.height(780.dp)
				.verticalScroll(rememberScrollState())
		) {
			LazyColumn(
				modifier = Modifier
					.fillMaxWidth()
					.height(780.dp)
					.background(Color(236, 236, 236))
			) {
//				items(pets) {
//					Card(
//						modifier = Modifier
//							.fillMaxWidth()
//							.wrapContentHeight(),
//						shape = RoundedCornerShape(16.dp),
//						backgroundColor = Color.White,
//						border = BorderStroke(0.8.dp, Color(202, 196, 208))
//					) {
//						Column(
//							modifier = Modifier.fillMaxSize()
//						) {
//							Row(
//								modifier = Modifier
//									.fillMaxWidth()
//									.wrapContentHeight()
//									.padding(16.dp),
//								horizontalArrangement = Arrangement.SpaceBetween,
//								verticalAlignment = Alignment.CenterVertically
//							) {
//								Card(
//									modifier = Modifier
//										.width(55.dp)
//										.height(55.dp),
//									shape = RoundedCornerShape(50),
//									border = BorderStroke(0.7.dp, Color(202, 196, 208)),
//									elevation = 2.dp
//								) {
//									//---------- COLOCAR IMAGEM DE PERFIL DO USUARIO ----------//
//								}
//								Text(
//									//---------- COLOCAR NOME DE USUARIO ----------//
//									text = "it.petName",
//									fontSize = 16.sp,
//									fontWeight = FontWeight.W500,
//									textAlign = TextAlign.Start
//								)
//							}
//							Image(
//								//---------- COLOCAR IMAGEM DA AVALIACAO DO USUARIO ----------//
//								painter = painterResource(id = R.drawable.media),
//								contentDescription = "Image Card",
//								modifier = Modifier
//									.fillMaxWidth(),
//								contentScale = ContentScale.FillWidth
//							)
//						}
//					}
//				}
			}
		}
	}
}

@Composable
fun AvaliationProfessional() {
	var reviews by rememberSaveable() {
		mutableStateOf(listOf<Reviews>())
	}
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.height(760.dp)
	) {
		Spacer(modifier = Modifier.height(12.dp))
		Text(
			text = stringResource(id = R.string.reviews_professional),
			modifier = Modifier.fillMaxWidth(),
			fontSize = 18.sp,
			fontWeight = FontWeight.W600,
			textAlign = TextAlign.Start
		)
		Spacer(modifier = Modifier.height(2.dp))
		Column(
			modifier = Modifier
				.fillMaxWidth()
				.height(780.dp)
				.verticalScroll(rememberScrollState())
		) {
			LazyColumn(
				modifier = Modifier
					.fillMaxWidth()
					.height(780.dp)
					.background(Color(236, 236, 236))
			) {
//			items(reviews){
//				Card(
//					modifier = Modifier
//						.fillMaxWidth()
//						.wrapContentHeight(),
//					shape = RoundedCornerShape(16.dp),
//					backgroundColor = Color.White,
//					border = BorderStroke(0.8.dp, Color(202, 196, 208))
//				) {
//					Column(
//						modifier = Modifier.fillMaxSize()
//					) {
//						Row(
//							modifier = Modifier
//								.fillMaxWidth()
//								.wrapContentHeight()
//								.padding(16.dp),
//							horizontalArrangement = Arrangement.SpaceBetween,
//							verticalAlignment = Alignment.CenterVertically
//						) {
//							Card(
//								modifier = Modifier
//									.width(55.dp)
//									.height(55.dp),
//								shape = RoundedCornerShape(50),
//								border = BorderStroke(0.7.dp, Color(202, 196, 208)),
//								elevation = 2.dp
//							) {
//								//---------- COLOCAR IMAGEM DE PERFIL DO USUARIO ----------//
//							}
//							Text(
//								//---------- COLOCAR NOME DE USUARIO ----------//
//								text = "it.userName",
//								fontSize = 16.sp,
//								fontWeight = FontWeight.W500,
//								textAlign = TextAlign.Start
//							)
//							IconButton(
//								onClick = { /*TODO*/ }
//							) {
//								Icon(
//									imageVector = Icons.Filled.MoreVert,
//									contentDescription = "MoreVert",
//									modifier = Modifier.size(40.dp)
//								)
//							}
//						}
//						Image(
//							//---------- COLOCAR IMAGEM DA AVALIACAO DO USUARIO ----------//
//							painter = painterResource(id = R.drawable.media),
//							contentDescription = "Image Card",
//							modifier = Modifier
//								.fillMaxWidth(),
//							contentScale = ContentScale.FillWidth
//						)
//						Row(
//							modifier = Modifier
//								.fillMaxWidth()
//								.wrapContentHeight()
//								.padding(start = 16.dp, top = 16.dp)
//						) {
//							Text(
//								text = stringResource(id = R.string.review_professional),
//								fontSize = 16.sp,
//								fontWeight = FontWeight.W400
//							)
//							Spacer(modifier = Modifier.width(16.dp))
//							Text(
//								//---------- COLOCAR NOTA DA AVALIACAO DO USUARIO ----------//
//								text = "it.nota(8,5/10)",
//								fontSize = 16.sp,
//								fontWeight = FontWeight.W300
//							)
//						}
//						Spacer(modifier = Modifier.height(16.dp))
//						Text(
//							//---------- COLOCAR DESCRIÇÃO DA AVALIACAO DO USUARIO ----------//
//							text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
//							modifier = Modifier.padding(start = 16.dp, bottom = 16.dp, end = 16.dp),
//							fontSize = 14.sp,
//							fontWeight = FontWeight.Normal
//						)
//					}
//				}
//			}
			}
		}
	}
}

@Composable
fun InformationAcademyProfessional() {
	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Spacer(modifier = Modifier.height(12.dp))
		Text(
			text = stringResource(id = R.string.user_config_academic_information),
			modifier = Modifier.fillMaxWidth(),
			fontSize = 18.sp,
			fontWeight = FontWeight.W600,
			textAlign = TextAlign.Start
		)
		Spacer(modifier = Modifier.height(2.dp))
		Row(
			modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
		) {
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp), elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.formation_professional),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						Text(
							//Inserir dados da API//
							text = "it.formation",
							modifier = Modifier.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
			Spacer(modifier = Modifier.width(12.dp))
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp), elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.formation_date_professional),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						Text(
							//Inserir dados da API//
							text = "it.formationDate",
							modifier = Modifier.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
		}
		Spacer(modifier = Modifier.height(8.dp))
		Row(
			modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
		) {
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp), elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.institution_professional),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						Text(
							//Inserir dados da API//
							text = "it.instituation",
							modifier = Modifier.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
			Spacer(modifier = Modifier.width(12.dp))
			Card(
				modifier = Modifier
					.width(185.dp)
					.height(60.dp), elevation = 2.dp
			) {
				Box(
					contentAlignment = Alignment.Center
				) {
					Column() {
						Text(
							text = stringResource(id = R.string.start_atuating_date_professional),
							modifier = Modifier.fillMaxWidth(),
							fontSize = 11.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
						Spacer(modifier = Modifier.height(4.dp))
						Text(
							//Inserir dados da API//
							text = "it.startAtuatingDate",
							modifier = Modifier.fillMaxWidth(),
							fontSize = 14.sp,
							fontWeight = FontWeight.W600,
							textAlign = TextAlign.Center
						)
					}
				}
			}
		}
	}
}

@Composable
fun LocalizationProfile() {
	Column(
		modifier = Modifier.fillMaxWidth()
	) {
		Spacer(modifier = Modifier.height(12.dp))
		Text(
			text = stringResource(id = R.string.user_config_location),
			modifier = Modifier.fillMaxWidth(),
			fontSize = 18.sp,
			fontWeight = FontWeight.W600,
			textAlign = TextAlign.Start
		)
		Spacer(modifier = Modifier.height(2.dp))
		Card(
			modifier = Modifier
				.fillMaxWidth()
				.height(220.dp),
			shape = RoundedCornerShape(5.dp),
			elevation = 2.dp
		) {
			GoogleMap(
				modifier = Modifier.fillMaxSize(), properties = MapProperties(mapType = MapType.NORMAL)
			)
		}
		Spacer(modifier = Modifier.height(32.dp))
	}
}

