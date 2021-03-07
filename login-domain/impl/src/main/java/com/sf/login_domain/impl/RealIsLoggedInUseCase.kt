package com.sf.login_domain.impl

import com.sf.login_domain.pub.useCase.IsLoggedInUseCase
import javax.inject.Inject

class RealIsLoggedInUseCase @Inject constructor(/*private val loginRepo: LoginRepo*/) : IsLoggedInUseCase {

    override suspend operator fun invoke(): Result<Boolean> {
        //return loginRepo.fetchLoginState()
        TODO()
    }
}