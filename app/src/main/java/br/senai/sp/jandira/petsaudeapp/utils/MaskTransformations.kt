package br.senai.sp.jandira.petsaudeapp.utils

import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

class ZipCodeTransformation(): VisualTransformation {
	override fun filter(text: AnnotatedString): TransformedText {
		return zipCodeMask(text)
	}
}

class CellPhoneNumberTransformation(): VisualTransformation {
	override fun filter(text: AnnotatedString): TransformedText {
		return cellPhoneNumberMask(text)
	}
}

class PhoneNumberTransformation(): VisualTransformation {
	override fun filter(text: AnnotatedString): TransformedText {
		return phoneNumberMask(text)
	}
}

class DateTransformation(): VisualTransformation {
	override fun filter(text: AnnotatedString): TransformedText {
		return dateMask(text)
	}

	private fun dateMask(text: AnnotatedString): TransformedText {
		val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
		var out = ""
		for (i in trimmed.indices) {
			out += trimmed[i]
			if (i==1) out += "/"
			if (i==3) out += "/"
		}

		val numberOffsetTranslator = object : OffsetMapping {
			override fun originalToTransformed(offset: Int): Int {
				if (offset <= 4) return offset
				if (offset <= 8) return offset +1
				return 9
			}

			override fun transformedToOriginal(offset: Int): Int {
				if (offset <=5) return offset
				if (offset <=9) return offset -1
				return 8
			}
		}

		return TransformedText(AnnotatedString(out), numberOffsetTranslator)
	}
}

// +01 (23) 45678-9012
fun cellPhoneNumberMask(text: AnnotatedString): TransformedText {
	val trimmed = if (text.text.length >= 13) text.text.substring(0..12) else text.text
	var out = "+"
	for (i in trimmed.indices) {
		out += trimmed[i]
		if (i==1) out += " ("
		if (i==3) out += ") "
		if (i==8) out += "-"
	}

	val numberOffsetTranslator = object : OffsetMapping {
		override fun originalToTransformed(offset: Int): Int {
			if (offset <= 4) return offset
			if (offset <= 8) return offset +1
			return 9
		}

		override fun transformedToOriginal(offset: Int): Int {
			if (offset <=5) return offset
			if (offset <=9) return offset -1
			return 8
		}
	}

	return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}

fun phoneNumberMask(text: AnnotatedString): TransformedText {
	val trimmed = if (text.text.length >= 12) text.text.substring(0..11) else text.text
	var out = "+"
	for (i in trimmed.indices) {
		out += trimmed[i]
		if (i==1) out += " ("
		if (i==3) out += ") "
		if (i==7) out += "-"
	}

	val numberOffsetTranslator = object : OffsetMapping {
		override fun originalToTransformed(offset: Int): Int {
			if (offset <= 4) return offset
			if (offset <= 8) return offset +1
			return 9
		}

		override fun transformedToOriginal(offset: Int): Int {
			if (offset <=5) return offset
			if (offset <=9) return offset -1
			return 8
		}
	}

	return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}

fun zipCodeMask(text: AnnotatedString): TransformedText {
	val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
	var out = ""
	for (i in trimmed.indices) {
		out += trimmed[i]
		if (i==4) out += "-"
	}

	val numberOffsetTranslator = object : OffsetMapping {
		override fun originalToTransformed(offset: Int): Int {
			if (offset <= 4) return offset
			if (offset <= 8) return offset +1
			return 9
		}

		override fun transformedToOriginal(offset: Int): Int {
			if (offset <=5) return offset
			if (offset <=9) return offset -1
			return 8
		}
	}

	return TransformedText(AnnotatedString(out), numberOffsetTranslator)
}
