package com.aklem.ru.timer.ui.timer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aklem.ru.timer.ui.components.Actuators
import com.aklem.ru.timer.ui.components.TopCard
import org.koin.androidx.compose.viewModel

@Composable
fun TimerScreen() {

    val countersViewModel by viewModel<CountersViewModel>()
    val timerViewModel by viewModel<TimerViewModel>()
    val isRunning = timerViewModel.isRunning.collectAsState().value
    val pauseActive = timerViewModel.pauseActive.collectAsState().value

    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // This composable displays timer and counters
        TopCard(
            timerViewModel = timerViewModel,
            countersViewModel = countersViewModel,
            isRunning = isRunning
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 40.dp)
        ) {

            // This composable is responsible for the score changing
            Actuators(countersViewModel::onEvent)

            // Button that toggles countdown
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 40.dp, bottom = 32.dp),
                shape = RoundedCornerShape(20.dp),
                contentPadding = PaddingValues(vertical = 16.dp),
                enabled = pauseActive,
                onClick = { timerViewModel.toggleStartPause() }) {
                Text(
                    text = if (isRunning) "Stop" else "Start",
                    style = MaterialTheme.typography.h5
                )
            }
        }
    }
}