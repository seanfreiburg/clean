package com.sf.login_domain.pub.useCase

import com.github.michaelbull.result.Result

interface LogOutUseCase {
    suspend operator fun invoke(): Result<Unit, Throwable>
}