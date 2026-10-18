package com.example.tugas_prak_pam_5

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.integerResource

@Composable
fun PagerIndicator(modifier: Modifier = Modifier) {
    val count = integerResource(R.integer.indicator_count)
    val activeIndex = integerResource(R.integer.indicator_active_index)
    Row(
        modifier = modifier.padding(dimensionResource(R.dimen.indicator_padding)),
        horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.indicator_spacing))
    ) {
        repeat(count) { index ->
            Box(
                Modifier
                    .size(dimensionResource(R.dimen.indicator_size))
                    .clip(CircleShape)
                    .background(
                        colorResource(
                            if (index == activeIndex) R.color.indicator_active
                            else R.color.indicator_inactive
                        )
                    )
            )
        }
    }
}