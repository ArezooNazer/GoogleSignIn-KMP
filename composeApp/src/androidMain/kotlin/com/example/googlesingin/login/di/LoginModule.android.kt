package com.example.googlesingin.login.di

import androidx.credentials.CredentialManager
import androidx.credentials.CredentialManager.Companion.create
import com.example.googlesingin.login.GoogleAuthProvider
import org.koin.android.ext.koin.androidContext
import org.koin.core.module.Module
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module

actual val loinPlatformModule: Module =
    module {
        factory { create(androidContext()) } bind CredentialManager::class
        factoryOf(::GoogleAuthProvider) bind GoogleAuthProvider::class
    }
