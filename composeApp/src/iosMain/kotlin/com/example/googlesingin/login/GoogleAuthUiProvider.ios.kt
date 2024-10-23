package com.example.googlesingin.login

import cocoapods.GoogleSignIn.GIDSignIn
import kotlinx.cinterop.ExperimentalForeignApi
import platform.UIKit.UIApplication
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

actual class GoogleAuthUiProvider {
    @OptIn(ExperimentalForeignApi::class)
    actual suspend fun signIn(): GoogleAccount? =
        suspendCoroutine { continutation ->


            val rootViewController =
                UIApplication.sharedApplication.keyWindow?.rootViewController


            if (rootViewController == null) {
                continutation.resume(null)
            } else {
                GIDSignIn.sharedInstance
                    .signInWithPresentingViewController(rootViewController) { gidSignInResult, nsError ->
                        nsError?.let { println("Error While signing: $nsError") }
                        val idToken = gidSignInResult?.user?.idToken?.tokenString
                        val profile = gidSignInResult?.user?.profile
                        if (idToken != null) {
                            val googleUser =
                                GoogleAccount(
                                    token = idToken,
                                    displayName = profile?.name ?: "",
                                    profileImageUrl = profile?.imageURLWithDimension(320u)?.absoluteString,
                                )
                            continutation.resume(googleUser)
                        } else {
                            continutation.resume(null)
                        }
                    }
            }
        }
}
