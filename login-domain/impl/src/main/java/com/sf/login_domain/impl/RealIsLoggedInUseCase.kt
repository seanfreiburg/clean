package com.sf.login_domain.impl

import com.sf.login_domain.pub.useCase.IsLoggedInUseCase

class RealIsLoggedInUseCase constructor(private val loginRepo: LoginRepo) : IsLoggedInUseCase {

    override suspend operator fun invoke(): Result<Boolean> {
        return loginRepo.fetchLoginState()
    }
}