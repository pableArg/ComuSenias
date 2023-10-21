package com.example.comusenias.presentation.contentCardGame

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.navigation.NavHostController
import com.example.comusenias.R
import com.example.comusenias.constants.TestTag
import com.example.comusenias.domain.models.game.SubLevelModel
import com.example.comusenias.presentation.component.home.ContentCardGame
import com.example.comusenias.presentation.component.home.StatusGame
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class ContentCardGameTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private val mockNavController: NavHostController = Mockito.mock(NavHostController::class.java)
    private val subLevel = SubLevelModel("", "1", R.drawable.letra_a.toString(), "1", "1", "1")

    @Test
    fun testContentCardGameCompleted() {
        composeTestRule.setContent {
            ContentCardGame(
                StatusGame.COMPLETED,
                "",
                subLevel,
                mockNavController
            )
        }
        composeTestRule.onNodeWithTag(TestTag.TAG_CONTENT_CARD_GAME + StatusGame.COMPLETED.name)
            .assertExists()
    }

    @Test
    fun testContentCardGameProgress() {
        composeTestRule.setContent {
            ContentCardGame(
                StatusGame.IN_PROGRESS,
                "",
                subLevel,
                mockNavController
            )
        }
        composeTestRule.onNodeWithTag(TestTag.TAG_CONTENT_CARD_GAME + StatusGame.IN_PROGRESS.name)
            .assertExists()
    }

    @Test
    fun testContentCardGameBlocked() {
        composeTestRule.setContent {
            ContentCardGame(
                StatusGame.BLOCKED,
                "",
                subLevel,
                mockNavController
            )
        }
        composeTestRule.onNodeWithTag(TestTag.TAG_CONTENT_CARD_GAME + StatusGame.BLOCKED.name)
            .assertExists()
    }
}