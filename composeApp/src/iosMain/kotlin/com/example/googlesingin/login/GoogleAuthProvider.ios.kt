package com.example.googlesingin.login

import androidx.compose.runtime.Composable

actual class GoogleAuthProvider {
    @Composable
    actual fun getUiProvider(): GoogleAuthUiProvider {
        TODO("Not yet implemented")
    }

    actual suspend fun signOut() {
    }

}
