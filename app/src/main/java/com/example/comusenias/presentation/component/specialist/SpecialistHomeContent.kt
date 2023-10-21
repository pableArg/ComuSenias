package com.example.comusenias.presentation.component.specialist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.comusenias.domain.models.users.ChildrenModel
import com.example.comusenias.domain.models.users.SpecialistModel
import com.example.comusenias.presentation.component.home.TopBarHome
import com.example.comusenias.presentation.navigation.AppScreen
import com.example.comusenias.presentation.ui.theme.DONT_YOU_HAVE_PATIENTS
import com.example.comusenias.presentation.ui.theme.PATIENTS
import com.example.comusenias.presentation.ui.theme.SIZE16
import com.example.comusenias.presentation.ui.theme.SIZE220
import com.example.comusenias.presentation.ui.theme.SIZE24
import com.example.comusenias.presentation.ui.theme.blackColorApp
import com.example.comusenias.presentation.ui.theme.size15
import com.example.comusenias.presentation.ui.theme.size3

@Composable
fun SpecialistHomeContent(
    navController: NavHostController,
    specialist: SpecialistModel
) {

    Scaffold(
        topBar = {
            Surface(shadowElevation = size3.dp) {
                TopBarHome(
                    name = specialist.userModel.userName,
                    image = specialist.userModel.image
                ) { navController.navigate(AppScreen.NotificationScreen.route) }
            }
        },
        floatingActionButton = {
            MyFloatingButton()
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            PatientContainer(
                patients = specialist.childrenInCharge,
                onClickCard = { navController.navigate(AppScreen.ProfilePatientScreen.route) }
            )
        }
    }
}

@Composable
fun PatientContainer(
    patients: List<ChildrenModel>?,
    onClickCard: () -> Unit = {}
) {
    val getPatients = remember { patients }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(size15.dp)
    ) {
        item {
            Title()
        }
        getPatients.let {
            if (it != null) {
                if (it.isNotEmpty()) {
                    items(it) { patient ->
                        CardProfileUser(
                            user = patient,
                            onClickCard = onClickCard
                        )
                    }
                }
            } else {
                item {
                    DontYouHavePatients()
                }
            }
        }
    }
}

@Composable
fun Title() {
    Text(
        modifier = Modifier.fillMaxSize(),
        text = PATIENTS,
        style = TextStyle(
            fontSize = SIZE24.sp,
            fontWeight = FontWeight.Bold,
            color = blackColorApp,
            textAlign = TextAlign.Start
        )
    )
}

@Composable
fun DontYouHavePatients() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = SIZE220.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = DONT_YOU_HAVE_PATIENTS,
            style = TextStyle(
                fontSize = SIZE16.sp,
                fontWeight = FontWeight.Normal,
                color = blackColorApp
            )
        )
    }
}