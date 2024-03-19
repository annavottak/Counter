package com.example.first

import androidx.compose.runtime.Composable
import androidx.compose.material3.Text
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.platform.testTag


@Composable
fun CounterScreen(counter: Counter) {
    Box(
        contentAlignment = Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "COUNTER",
                fontSize = 32.sp,
                fontWeight = FontWeight.Medium,
                fontStyle = FontStyle.Italic
            )
            when (counter.number) {
                -1000 -> {
                    Text(
                        modifier = Modifier.testTag("counter"),
                        text = "${counter.number}",
                        fontSize = 60.sp,
                        color = Color.Blue,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }

                1000 -> {
                    Text(
                        modifier = Modifier.testTag("counter"),
                        text = "${counter.number}",
                        fontSize = 60.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }

                else -> {
                    Text(
                        modifier = Modifier.testTag("counter"),
                        text = "${counter.number}",
                        fontSize = 60.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic
                    )
                }
            }
            Row(modifier = Modifier.padding(8.dp)) {
                Button(
                    enabled = counter.number > -1000,
                    onClick = { counter.remove() },
                    shape = RoundedCornerShape(11.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(255, 165, 0),
                        contentColor = Color.White
                    ),
                    border = BorderStroke(2.5.dp, Color.Black),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("remove")
                ) {
                    Text(
                        "Decrement",
                        fontSize = 25.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    onClick = { counter.reset() },
                    shape = RoundedCornerShape(11.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(255, 0, 0),
                        contentColor = Color.White
                    ),
                    border = BorderStroke(2.5.dp, Color.Black),
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Reset", fontSize = 25.sp, maxLines = 1, overflow = TextOverflow.Ellipsis)
                }
                Spacer(modifier = Modifier.width(8.dp))
                Button(
                    enabled = counter.number < 1000,
                    onClick = { counter.add() },
                    shape = RoundedCornerShape(11.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0, 128, 0),
                        contentColor = Color.White
                    ),
                    border = BorderStroke(2.5.dp, Color.Black),
                    modifier = Modifier
                        .weight(1f)
                        .testTag("add")
                ) {
                    Text(
                        "Increment",
                        fontSize = 25.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
            }
        }

    }
}