package com.example.comusenias.presentation.gameAction

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import com.example.comusenias.R
import com.example.comusenias.constants.TestTag
import com.example.comusenias.presentation.component.gameAction.MatchSign
import com.example.comusenias.presentation.screen.gameAction.Sign
import org.junit.Rule
import org.junit.Test

class MatchSignComposableTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testWhenMatchSignIsIncorrect() {
        var isCorrect = true
        val sign = Sign(imageResource = R.drawable.letra_a_solo, letter = "a")
        val randomSign = Sign(imageResource = R.drawable.sign_o, letter = "o")

        composeTestRule.setContent {
            MatchSign(
                sign = sign,
                randomSign = randomSign,
                letterCompare = sign.letter
            ) {
                isCorrect = it
            }
        }
        composeTestRule.onNodeWithTag(TestTag.TAG_MATCH_SIGN + "o").assertExists()
        composeTestRule.onNodeWithTag(TestTag.TAG_MATCH_SIGN + "a").assertExists()
        composeTestRule.onNodeWithTag(TestTag.TAG_MATCH_SIGN + "o").performClick()
        assert(!isCorrect)
    }

    @Test
    fun testWhenMatchSignCorrect() {
        var isCorrect = false
        val sign = Sign(imageResource = R.drawable.letra_a_solo, letter = "a")
        val randomSign = Sign(imageResource = R.drawable.sign_o, letter = "o")

        composeTestRule.setContent {
            MatchSign(
                sign = sign,
                randomSign = randomSign,
                letterCompare = sign.letter
            ) {
                isCorrect = it
            }
        }
        composeTestRule.onNodeWithTag(TestTag.TAG_MATCH_SIGN + "o").assertExists()
        composeTestRule.onNodeWithTag(TestTag.TAG_MATCH_SIGN + "a").assertExists()
        composeTestRule.onNodeWithTag(TestTag.TAG_MATCH_SIGN + "a").performClick()
        assert(isCorrect)
    }
}