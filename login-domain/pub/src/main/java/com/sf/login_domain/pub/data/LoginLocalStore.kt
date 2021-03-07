package com.sf.login_domain.pub.data

import com.github.michaelbull.result.Result

enum class LoginState {
    LOGGED_IN,
    LOGGED_OUT
}

interface LoginLocalStore {
    suspend fun fetchLoginState(): Result<LoginState, Throwable>
    suspend fun storeLoginState(loginState: LoginState): Result<LoginState, Throwable>
}