package com.example.tugas_prak_pam_5

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource

@Composable
fun HeaderBackground(modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(R.drawable.bg_itachi),
        contentDescription = stringResource(R.string.cd_background),
        contentScale = ContentScale.Crop,
        modifier = modifier.fillMaxSize()
    )
}