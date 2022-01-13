package com.aklem.ru.timer.ui.timer

import androidx.lifecycle.ViewModel
import com.aklem.ru.timer.models.UserInteractionEvent
import com.aklem.ru.timer.models.UserInteractionEvent.*
import com.aklem.ru.timer.util.INITIAL_LEFT_SCORE
import com.aklem.ru.timer.util.INITIAL_RIGHT_SCORE
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountersViewModel : ViewModel() {

    private var _leftCounter = MutableStateFlow(INITIAL_LEFT_SCORE)
    val leftCounter = _leftCounter.asStateFlow()

    private var _rightCounter = MutableStateFlow(INITIAL_RIGHT_SCORE)
    val rightCounter = _rightCounter.asStateFlow()

    fun onEvent(event: UserInteractionEvent) {
        when (event) {
            is LeftScoreIncrease -> _leftCounter.value++
            is LeftScoreDecrease -> if (_leftCounter.value > 0) _leftCounter.value--
            is RightScoreIncrease -> _rightCounter.value++
            is RightScoreDecrease -> if (_rightCounter.value > 0) _rightCounter.value--
        }
    }

}