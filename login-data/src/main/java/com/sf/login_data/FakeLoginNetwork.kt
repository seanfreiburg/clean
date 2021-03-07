package com.sf.login_data

import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.sf.login_domain.pub.data.LoginNetwork
import javax.inject.Inject

// fetch and store data from network
class FakeLoginNetwork @Inject constructor(): LoginNetwork {
    override suspend fun logIn(): Result<Unit, Throwable> {
        return Ok(Unit)
    }

    override suspend fun logOut(): Result<Unit, Throwable> {
        return Ok(Unit)
    }
}