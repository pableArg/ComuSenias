package com.example.comusenias.presentation.screen.profile

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.comusenias.presentation.component.bottomBar.ShowBottomBar
import com.example.comusenias.presentation.component.profile.ChildrenProfileFooterContent
import com.example.comusenias.presentation.component.profile.SpecialistProfileContent
import com.example.comusenias.presentation.view_model.specialist.SpecialistProfileViewModel

@Composable
fun SpecialistProfileScreen(
    navController: NavHostController,
    modifier: Modifier,
    viewModel: SpecialistProfileViewModel = hiltViewModel()
) {
    Scaffold(
        bottomBar = {
            ShowBottomBar(navController = navController)
        }

    ) { paddingValues ->
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                SpecialistProfileContent(
                    viewModel = viewModel
                )
                val onClick: () -> Unit =
                    {
                        viewModel.saveImage()
                    }
                ChildrenProfileFooterContent(
                    onClickChangeProfile = onClick
                )
            }
        }
    }
}

