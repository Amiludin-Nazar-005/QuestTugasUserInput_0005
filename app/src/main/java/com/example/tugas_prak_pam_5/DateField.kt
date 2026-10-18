package com.example.tugas_prak_pam_5

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateField(
    value: String,
    onDateSelected: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var showDialog by remember { mutableStateOf(false) }
    val pickerState = rememberDatePickerState()
    val pattern = stringResource(R.string.date_pattern)

    Box(modifier) {
        OutlinedTextField(
            value = value,
            onValueChange = {},
            readOnly = true,
            placeholder = { Text(stringResource(R.string.hint_birth_date), fontSize = spResource(R.dimen.text_field)) },
            trailingIcon = {
                Icon(
                    painter = painterResource(R.drawable.ic_calendar),
                    contentDescription = stringResource(R.string.cd_calendar)
                )
            },
            shape = RoundedCornerShape(dimensionResource(R.dimen.field_corner)),
            colors = biodataFieldColors(),
            modifier = Modifier.fillMaxWidth().height(dimensionResource(R.dimen.field_height))
        )


