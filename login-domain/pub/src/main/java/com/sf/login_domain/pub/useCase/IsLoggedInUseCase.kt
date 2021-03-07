package com.sf.login_domain.pub.useCase

import com.github.michaelbull.result.Result

interface IsLoggedInUseCase {
    suspend operator fun invoke(): Result<Boolean, Throwable>
}

