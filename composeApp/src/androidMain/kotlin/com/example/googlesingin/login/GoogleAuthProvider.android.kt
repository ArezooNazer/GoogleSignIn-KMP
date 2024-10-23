package com.example.googlesingin.login

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.credentials.ClearCredentialStateRequest
import androidx.credentials.CredentialManager

actual class GoogleAuthProvider(
    private val credentialManager: CredentialManager
) {
    @Composable
    actual fun getUiProvider(): GoogleAuthUiProvider {
        val activityContext = LocalContext.current
        return GoogleAuthUiProvider(activityContext, credentialManager)
    }

    actual suspend fun signOut() {
        credentialManager.clearCredentialState(ClearCredentialStateRequest())
    }
}
