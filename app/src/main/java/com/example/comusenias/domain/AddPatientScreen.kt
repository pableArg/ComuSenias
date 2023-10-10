package com.example.comusenias.domain

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.comusenias.R
import com.example.comusenias.domain.models.model.Paciente
import com.example.comusenias.presentation.component.addPatient.FieldWithIcon
import com.example.comusenias.presentation.component.addPatient.UserProfileContent
import com.example.comusenias.presentation.component.defaults.app.ButtonApp
import com.example.comusenias.presentation.ui.theme.AgregaPaciente
import com.example.comusenias.presentation.ui.theme.SIZE12
import com.example.comusenias.presentation.ui.theme.SIZE48


@Composable
fun AddPatientScreen() {
    val paciente = remember {
        mutableStateOf(
            Paciente(
                nombre = "Jose Augusto",
                edad = 6,
                tel = 1158548647,
                email = "12345@gmail.com",
                ubicacion = "Moreno"
            )
        )
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.padding(top = SIZE48.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            UserProfileContent(
                imageResId = R.drawable.profile_avatar,
                contentDescription = "User Profile",
                name = paciente.value.nombre
            )

            Spacer(modifier = Modifier.height(SIZE48.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(SIZE12.dp)
            ) {
                FieldWithIcon(
                    icon = painterResource(R.drawable.baseline_calendar_month_24),
                    text = "${paciente.value.edad} años"
                )
                FieldWithIcon(
                    icon = painterResource(R.drawable.phone_icon),
                    text = "${paciente.value.tel}"
                )
                FieldWithIcon(
                    icon = painterResource(R.drawable.mail_icon),
                    text = paciente.value.email
                )
                FieldWithIcon(
                    icon = painterResource(R.drawable.lugar_icon),
                    text = paciente.value.ubicacion
                )
            }

            Spacer(modifier = Modifier.weight(1f))

            ButtonApp(titleButton = AgregaPaciente)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AddPatientScreen()
}