package com.sf.login_data

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.sf.login_domain.pub.data.LoginLocalStore
import com.sf.login_domain.pub.data.LoginState
import javax.inject.Inject

// fetch and store data from local
class FakeLoginLocalStore @Inject constructor(): LoginLocalStore {

    var loginState = LoginState.LOGGED_OUT

    override suspend fun fetchLoginState(): Result<LoginState, Throwable> {
        return Ok(loginState)
    }

    override suspend fun storeLoginState(loginState: LoginState): Result<LoginState, Throwable> {
        this.loginState = loginState
        return Ok(loginState)
    }
}