package com.example.tugas_prak_pam_5

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight

@Composable
fun ProceedButton(
    enabled: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        shape = RoundedCornerShape(dimensionResource(R.dimen.button_corner)),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(R.color.button_enabled),
            contentColor = colorResource(R.color.white),
            disabledContainerColor = colorResource(R.color.button_disabled),
            disabledContentColor = colorResource(R.color.button_text_disabled)
        ),
        modifier = modifier.fillMaxWidth().height(dimensionResource(R.dimen.button_height))
    ) {
        Text(stringResource(R.string.btn_proceed), fontWeight = FontWeight.Bold)
    }
}