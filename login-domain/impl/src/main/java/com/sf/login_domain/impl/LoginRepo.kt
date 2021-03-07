package com.sf.login_domain.impl

import com.github.michaelbull.result.Result
import com.sf.login_domain.pub.data.LoginState

interface LoginRepo {
    suspend fun fetchLoginState(): Result<LoginState, Throwable>
    suspend fun logIn():  Result<Unit, Throwable>
    suspend fun logOut():  Result<Unit, Throwable>
}