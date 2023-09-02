package com.example.comusenias.presentation.component.defaults

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.comusenias.presentation.ui.theme.ComuSeniasTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DefaultTopBar(
    title: String,
    upAvailable: Boolean = false,
    navHostController: NavHostController? = null
) {

    TopAppBar(
        title = {
            Text(text = title, fontSize = 19.sp)
        },
        colors = TopAppBarDefaults.smallTopAppBarColors(titleContentColor=MaterialTheme.colorScheme.primary , containerColor =MaterialTheme.colorScheme.primaryContainer),
        navigationIcon = {
            if (upAvailable) {
                IconButton(onClick = { navHostController?.popBackStack() }) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Arrow Back" , tint = MaterialTheme.colorScheme.primary)

                }
            }
        }
    )

}


@Composable
@Preview(showBackground = true)
fun DefaultTopBarPreview() {
    ComuSeniasTheme {
        DefaultTopBar(title = "Title", upAvailable = true)

    }
}