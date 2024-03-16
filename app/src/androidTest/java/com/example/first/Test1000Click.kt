package com.example.first


import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsActions
import androidx.compose.ui.semantics.SemanticsProperties
import androidx.compose.ui.semantics.getOrNull
import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.assertIsNotEnabled
import androidx.compose.ui.text.TextLayoutResult

fun SemanticsNodeInteraction.assertTextColor(
    color: Color
): SemanticsNodeInteraction = assert(isOfColor(color))

private fun isOfColor(color: Color): SemanticsMatcher = SemanticsMatcher(
    "${SemanticsProperties.Text.name} is of color '$color'"
) {
    val textLayoutResults = mutableListOf<TextLayoutResult>()
    it.config.getOrNull(SemanticsActions.GetTextLayoutResult)
        ?.action
        ?.invoke(textLayoutResults)
    return@SemanticsMatcher if (textLayoutResults.isEmpty()) {
        false
    } else {
        textLayoutResults.first().layoutInput.style.color == color
    }
}
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
            onNodeWithTag("counter").assertTextColor(Color.Blue)
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
            onNodeWithTag("counter").assertTextColor(Color.Red)
        }
    }
}

