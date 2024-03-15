package com.example.first

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertCountEquals
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsEnabled
import androidx.compose.ui.test.assertIsFocused
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.test.assertTextContains
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.hasClickAction
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog


class Test1000Click {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testClickButtonDecrement() {
        composeTestRule.apply {
            val counter = Counter()
            setContent { CounterScreen(counter) }
            var minCounter = 0
            do {
             onNodeWithTag("remove").performClick()
                minCounter++
            } while (minCounter < 1000)
            onNodeWithTag("remove").assertIsNotEnabled()
        }
    }

    @Test
    fun testClickButtonIncrement() {
        composeTestRule.apply {
            val counter = Counter()
            setContent { CounterScreen(counter) }
            var minCounter = 0
            do {
                onNodeWithTag("add").performClick()
                minCounter++
            } while (minCounter < 1000)
            onNodeWithTag("add").assertIsNotEnabled()
        }
    }
}