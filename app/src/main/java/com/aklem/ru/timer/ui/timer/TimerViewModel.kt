package com.aklem.ru.timer.ui.timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aklem.ru.timer.util.INITIAL_TIMER_VALUE
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TimerViewModel : ViewModel() {

    private var job: Job? = null

    private var _timerValue = MutableStateFlow(INITIAL_TIMER_VALUE)
    val timerValue = _timerValue.asStateFlow()

    private var _isRunning = MutableStateFlow(false)
    val isRunning = _isRunning.asStateFlow()

    private var _pauseActive = MutableStateFlow(true)
    val pauseActive = _pauseActive.asStateFlow()

    // Countdown control
    fun toggleStartPause() {
        if (!isRunning.value) {
            _isRunning.value = true
            job = viewModelScope.launch(Dispatchers.Default) {
                while (isActive) {
                    delay(1000L)
                    _timerValue.value--

                    // If timer reaches 00:00 after 3 seconds it's resetting to initial value
                    // During this period it is reasonable to disable Stop button
                    if (_timerValue.value <= 0) {
                        _pauseActive.value = false
                        delay(3000L)
                        resetTimer()
                        _pauseActive.value = true
                    }
                }
            }
        } else {
            pauseTimer()
        }
    }

    private fun pauseTimer() {
        job?.cancel()
        _isRunning.value = false
    }

    private fun resetTimer() {
        pauseTimer()
        _timerValue.value = INITIAL_TIMER_VALUE
    }
}