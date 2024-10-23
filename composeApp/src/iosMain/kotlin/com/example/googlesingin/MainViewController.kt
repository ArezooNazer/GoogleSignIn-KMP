package com.example.googlesingin

import androidx.compose.ui.window.ComposeUIViewController
import com.example.googlesingin.login.di.initKoin

fun MainViewController() =
    ComposeUIViewController(
        configure = {
            initKoin()
        },
    ) {
        App()
    }
