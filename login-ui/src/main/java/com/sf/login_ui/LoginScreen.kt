package com.sf.login_ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.airbnb.mvrx.compose.collectAsState
import com.airbnb.mvrx.compose.mavericksViewModel
import com.sf.app_ui.CleanTheme

@Composable
fun LoginScreen() {
    val viewModel: LoginViewModel = mavericksViewModel()
    val count = viewModel.collectAsState(LoginState::count)
    LoginScreenStateless(count.value, { viewModel.incrementCount() })
}

@Composable
fun LoginScreenStateless(
    count: Int,
    onIncrementClick: () -> Unit
) {
    CleanTheme {
        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Column {
                Greeting("Android")
                Text(text = "Count $count")
                Button(onClick = onIncrementClick) {
                    Text(text = "Increment Count")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}