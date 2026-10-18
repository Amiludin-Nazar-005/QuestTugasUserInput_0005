package com.example.tugas_prak_pam_5

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun BiodataScreen() {
    var firstName by rememberSaveable { mutableStateOf("") }
    var lastName by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var birthDate by rememberSaveable { mutableStateOf("") }
    var experience by rememberSaveable { mutableStateOf("") }
    var android by rememberSaveable { mutableStateOf(false) }
    var uiux by rememberSaveable { mutableStateOf(false) }
    var web by rememberSaveable { mutableStateOf(false) }

    val isFormValid = firstName.isNotBlank() && lastName.isNotBlank() &&
            email.isNotBlank() && birthDate.isNotBlank() &&
            experience.isNotBlank() && (android || uiux || web)

    val context = LocalContext.current
    val successMessage = stringResource(R.string.msg_success)
    val space = dimensionResource(R.dimen.space_medium)

    Scaffold(containerColor = colorResource(R.color.screen_background)) { innerPadding ->
        Box(Modifier.fillMaxSize().padding(innerPadding)) {

            HeaderBackground()
            PagerIndicator(Modifier.align(Alignment.TopStart))

            // BOX yang mengapung di atas Scaffold
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .shadow(
                        dimensionResource(R.dimen.card_elevation),
                        RoundedCornerShape(
                            topStart = dimensionResource(R.dimen.card_corner),
                            topEnd = dimensionResource(R.dimen.card_corner)
                        )
                    )
                    .background(
                        colorResource(R.color.white),
                        RoundedCornerShape(
                            topStart = dimensionResource(R.dimen.card_corner),
                            topEnd = dimensionResource(R.dimen.card_corner)
                        )
                    )
            ) {
                Column(
                    modifier = Modifier
                        .verticalScroll(rememberScrollState())
                        .padding(
                            horizontal = dimensionResource(R.dimen.card_padding_horizontal),
                            vertical = dimensionResource(R.dimen.card_padding_vertical)
                        ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(space)
                ) {
                    Text(
                        stringResource(R.string.form_title),
                        fontSize = spResource(R.dimen.text_title),
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.title_purple)
                    )
                    Text(
                        stringResource(R.string.form_subtitle),
                        fontSize = spResource(R.dimen.text_subtitle),
                        color = colorResource(R.color.text_secondary)
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_small))) {
                        BiodataTextField(firstName, { firstName = it }, R.string.hint_first_name, Modifier.weight(1f))
                        BiodataTextField(lastName, { lastName = it }, R.string.hint_last_name, Modifier.weight(1f))
                    }

                    BiodataTextField(
                        email, { email = it }, R.string.hint_email,
                        Modifier.fillMaxWidth(), KeyboardType.Email
                    )

                    Row(horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.space_small))) {
                        DateField(birthDate, { birthDate = it }, Modifier.weight(1f))
                        ExperienceDropdown(experience, { experience = it }, Modifier.weight(1f))
                    }

                    Text(
                        stringResource(R.string.label_skill),
                        fontSize = spResource(R.dimen.text_label),
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.text_primary),
                        modifier = Modifier.fillMaxWidth()
                    )
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        SkillCheckbox(R.string.skill_android, android, { android = it })
                        SkillCheckbox(R.string.skill_uiux, uiux, { uiux = it })
                        SkillCheckbox(R.string.skill_web, web, { web = it })
                    }

                    ProceedButton(
                        enabled = isFormValid,
                        onClick = { Toast.makeText(context, successMessage, Toast.LENGTH_SHORT).show() }
                    )
                }
            }
        }
    }
}