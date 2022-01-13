package com.aklem.ru.timer.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aklem.ru.timer.R
import com.aklem.ru.timer.models.UserInteractionEvent
import com.aklem.ru.timer.models.UserInteractionEvent.*

@Composable
fun Actuators(onEvent: (UserInteractionEvent) -> Unit) {

    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
            Image(
                modifier = Modifier.clickable(onClick = { onEvent(LeftScoreIncrease) }),
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                modifier = Modifier.clickable(onClick = { onEvent(LeftScoreDecrease) }),
                painter = painterResource(id = R.drawable.ic_remove),
                contentDescription = null
            )
        }
        Column {
            Image(
                modifier = Modifier.clickable(onClick = { onEvent(RightScoreIncrease) }),
                painter = painterResource(id = R.drawable.ic_add),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(32.dp))
            Image(
                modifier = Modifier.clickable(onClick = { onEvent(RightScoreDecrease) }),
                painter = painterResource(id = R.drawable.ic_remove),
                contentDescription = null
            )
        }
    }
}