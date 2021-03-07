package com.sf.login_domain.pub.data

import com.github.michaelbull.result.Result

interface LoginNetwork {
    suspend fun logIn(): Result<Unit, Throwable>
    suspend fun logOut(): Result<Unit, Throwable>
}