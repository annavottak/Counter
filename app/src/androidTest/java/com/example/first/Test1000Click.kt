package com.example.first


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.assertIsNotEnabled

class Test1000Click {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testClickButtonDecrement() {
        composeTestRule.apply {
            val counter = Counter()
            setContent { CounterScreen(counter) }
            for (n in 1..1000) {
                onNodeWithTag("remove").performClick()
            }
            onNodeWithTag("remove").assertIsNotEnabled()
            onNodeWithTag("counter").assertTextColor(Color.Blue)
        }
    }

    @Test
    fun testClickButtonIncrement() {
        composeTestRule.apply {
            val counter = Counter()
            setContent { CounterScreen(counter) }
            for (n in 1..1000) {
                onNodeWithTag("add").performClick()
            }

            onNodeWithTag("add").assertIsNotEnabled()
            onNodeWithTag("counter").assertTextColor(Color.Red)
        }
    }
}

