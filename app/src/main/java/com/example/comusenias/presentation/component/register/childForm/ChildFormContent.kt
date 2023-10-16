package com.example.comusenias.presentation.component.register.childForm

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.comusenias.presentation.component.defaults.app.TextFieldApp
import com.example.comusenias.presentation.component.defaults.app.TextFieldDate
import com.example.comusenias.presentation.component.register.TermsAndConditions
import com.example.comusenias.presentation.ui.theme.BIRTHDAY
import com.example.comusenias.presentation.ui.theme.NAME
import com.example.comusenias.presentation.ui.theme.NUMBER_PHONE
import com.example.comusenias.presentation.ui.theme.size10

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ChildFormContent() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(size10.dp)
    ) {
        TextFieldApp(
            value = "",
            onValueChange = {},
            label = NAME,
            icon = Icons.Default.Person
        )
        TextFieldDate(
            label = BIRTHDAY
        ){

        }
        TextFieldApp(
            value = "",
            onValueChange = {},
            label = NUMBER_PHONE,
            icon = Icons.Default.Phone
        )

        TermsAndConditions()
    }
}
