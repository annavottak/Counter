
package com.example.first

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
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import org.junit.Before
import org.junit.Rule
import org.junit.Test
class CheckChangeAfterButtonClick {
    @get:Rule
    val composeTestRule= createComposeRule()
    @Test
    fun testClickButtonDecrement(){
        composeTestRule.apply {
            val counter = Counter()
            setContent { CounterScreen(counter)}
            onNode(hasText("Decrement")and hasClickAction()).assertIsDisplayed().assertIsEnabled().performClick()
            onNodeWithText("-1").assertExists()
        }
    }
    @Test
    fun testClickButtonReset(){
        composeTestRule.apply {
            val counter = Counter()
            val count=counter.number.toString()
            setContent { CounterScreen(counter)}
            onNode(hasText("Reset")and hasClickAction()).assertIsDisplayed().assertIsEnabled().performClick()
            onNodeWithTag("counter").assertTextContains("${count}")
        }
    }
    @Test
    fun testClickButtonIncrement(){
        composeTestRule.apply {
            val counter = Counter()
            setContent { CounterScreen(counter)}
            onNode(hasText("Increment")and hasClickAction()).assertIsDisplayed().assertIsEnabled().performClick()
            onNodeWithTag("counter").assertTextContains("1")
        }
    }
}










