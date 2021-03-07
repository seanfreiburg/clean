package com.sf.login_domain.impl

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.sf.login_domain.pub.data.LoginLocalStore
import com.sf.login_domain.pub.data.LoginNetwork
import com.sf.login_domain.pub.data.LoginState
import javax.inject.Inject

// fetch and store data, thats all
class RealLoginRepo  @Inject constructor(
    private val network: LoginNetwork,
    private val localStore: LoginLocalStore
) : LoginRepo {
    override suspend fun fetchLoginState(): Result<LoginState, Throwable> {
        return localStore.fetchLoginState()
    }

    override suspend fun logIn(): Result<Unit, Throwable> {
        val localLoginState = localStore.fetchLoginState()

        return when (localLoginState) {
            is Ok -> {
                when (localLoginState.value) {
                    LoginState.LOGGED_IN -> {
                        return Ok(Unit)
                    }
                    else -> {

                        return when (val loginResult = network.logIn()) {
                            is Ok -> {
                                localStore.storeLoginState(LoginState.LOGGED_IN)
                                Ok(Unit)
                            }
                            is Err -> {
                                loginResult
                            }
                        }
                    }
                }

            }
            is Err -> localLoginState
        }
    }

    override suspend fun logOut(): Result<Unit, Throwable> {
        val localLoginState = localStore.fetchLoginState()

        return when (localLoginState) {
            is Ok -> {
                when (localLoginState.value) {
                    LoginState.LOGGED_OUT -> {
                        return Ok(Unit)
                    }
                    else -> {

                        return when (val loginResult = network.logOut()) {
                            is Ok -> {
                                localStore.storeLoginState(LoginState.LOGGED_OUT)
                                Ok(Unit)
                            }
                            is Err -> {
                                loginResult
                            }
                        }
                    }
                }

            }
            is Err -> localLoginState
        }
    }
}