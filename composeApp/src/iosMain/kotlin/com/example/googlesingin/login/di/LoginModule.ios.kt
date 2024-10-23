package com.example.googlesingin.login.di

import com.example.googlesingin.login.GoogleAuthProvider
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val loinPlatformModule: Module =
    module {
        factoryOf(::GoogleAuthProvider) bind GoogleAuthProvider::class
    }
