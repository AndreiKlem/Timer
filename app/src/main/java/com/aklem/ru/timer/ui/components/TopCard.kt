package com.aklem.ru.timer.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.aklem.ru.timer.ui.timer.CountersViewModel
import com.aklem.ru.timer.ui.timer.TimerViewModel

@Composable
fun TopCard(
    timerViewModel: TimerViewModel,
    countersViewModel: CountersViewModel,
    isRunning: Boolean
) {

    val timerValue by timerViewModel.timerValue.collectAsState()
    val leftScore = countersViewModel.leftCounter.collectAsState().value
    val rightScore = countersViewModel.rightCounter.collectAsState().value

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(bottomStart = 32.dp, bottomEnd = 32.dp),
        elevation = 8.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 52.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = getTimerText(timerValue),
                style = MaterialTheme.typography.h2,
                color = if (isRunning) Color.White else Color.Black,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Min),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Counter(score = leftScore)
                Divider(
                    modifier = Modifier
                        .fillMaxHeight(0.4f)
                        .width(2.dp)
                        .align(alignment = Alignment.CenterVertically),
                    color = Color.White
                )
                Counter(score = rightScore)
            }
            Spacer(modifier = Modifier.height(60.dp))
        }
    }
}

@Composable
fun Counter(score: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.height(2.dp).width(100.dp).background(color = Color.White))
        Text(
            text = score.toString(),
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center
        )
    }
}

fun getTimerText(duration: Int): String {
    val min = duration / 60
    val sec = duration % 60
    return "$min:${formattedNumber(sec)}"
}

fun formattedNumber(number: Int): String {
    return number.toString().padStart(2, '0')
}