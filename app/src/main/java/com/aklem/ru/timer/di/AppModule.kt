package com.aklem.ru.timer.di

import com.aklem.ru.timer.ui.timer.CountersViewModel
import com.aklem.ru.timer.ui.timer.TimerViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel {
        TimerViewModel()
    }

    viewModel {
        CountersViewModel()
    }
}