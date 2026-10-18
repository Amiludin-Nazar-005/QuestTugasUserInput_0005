package com.example.tugas_prak_pam_5

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun BiodataTextField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes hint: Int,
    modifier: Modifier = Modifier,
    keyboardType: KeyboardType = KeyboardType.Text
) {
    OutlinedTextField(
    value = value,
    onValueChange = onValueChange,
    placeholder = {
        Text(stringResource(hint), fontSize = spResource(R.dimen.text_field))
    },
    singleLine = true,
    shape = RoundedCornerShape(dimensionResource(R.dimen.field_corner)),
    keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
    textStyle = LocalTextStyle.current.copy(fontSize = spResource(R.dimen.text_field)),
    colors = biodataFieldColors(),
    modifier = modifier.height(dimensionResource(R.dimen.field_height))
)}