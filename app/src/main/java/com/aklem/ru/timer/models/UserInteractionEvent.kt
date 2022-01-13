package com.aklem.ru.timer.models

// Handling user touching image buttons
sealed class UserInteractionEvent {
    object LeftScoreIncrease: UserInteractionEvent()
    object LeftScoreDecrease: UserInteractionEvent()
    object RightScoreIncrease: UserInteractionEvent()
    object RightScoreDecrease: UserInteractionEvent()
}