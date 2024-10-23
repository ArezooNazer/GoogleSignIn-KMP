package com.example.googlesingin.login

expect class GoogleAuthUiProvider {
    suspend fun signIn(): GoogleAccount?
}
