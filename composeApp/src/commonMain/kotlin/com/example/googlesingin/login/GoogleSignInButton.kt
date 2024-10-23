package com.example.googlesingin.login

import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import org.koin.compose.koinInject

interface GoogleButtonClick {
    fun onSignInClicked()

    fun onSignOutClicked()
}

@Composable
fun GoogleSignInButton(
    modifier: Modifier = Modifier,
    onGoogleSignInResult: (GoogleAccount?) -> Unit,
) {
    val googleAuthProvider = koinInject<GoogleAuthProvider>()
    val googleAuthUiProvider = googleAuthProvider.getUiProvider()
    val coroutineScope = rememberCoroutineScope()
    val uiContainerScope =
        remember {
            object : GoogleButtonClick {
                override fun onSignInClicked() {
                    coroutineScope.launch {
                        val googleUser = googleAuthUiProvider.signIn()
                        onGoogleSignInResult(googleUser)
                    }
                }


                override fun onSignOutClicked() {
                    coroutineScope.launch {
                        googleAuthProvider.signOut()
                    }
                }
            }
        }
    OutlinedButton(
        modifier = modifier,
        onClick = {uiContainerScope.onSignInClicked()},
        content = {
            Text("Login")
        }
    )
}
