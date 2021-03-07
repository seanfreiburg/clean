package com.sf.login_domain.impl

import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.github.michaelbull.result.Result
import com.sf.login_domain.pub.data.LoginState
import com.sf.login_domain.pub.useCase.IsLoggedInUseCase
import com.sf.login_domain.pub.useCase.LogInUseCase
import com.sf.login_domain.pub.useCase.LogOutUseCase
import javax.inject.Inject

class RealIsLoggedInUseCase @Inject constructor(private val loginRepo: LoginRepo) :
    IsLoggedInUseCase {

    override suspend operator fun invoke(): Result<Boolean, Throwable> {
        return when (val result = loginRepo.fetchLoginState()) {
            is Ok -> when (result.value) {
                LoginState.LOGGED_IN -> Ok(true)
                LoginState.LOGGED_OUT -> Ok(false)
            }
            is Err -> result
        }
    }
}

class RealLogInUseCase @Inject constructor(private val loginRepo: LoginRepo) : LogInUseCase {
    override suspend fun invoke(): Result<Unit, Throwable> {
        return loginRepo.logIn()
    }

}

class RealLogOutUseCase @Inject constructor(private val loginRepo: LoginRepo) : LogOutUseCase {
    override suspend fun invoke(): Result<Unit, Throwable> {
        return loginRepo.logOut()
    }
}