package com.sf.login_domain.pub.useCase

import com.github.michaelbull.result.Result

interface LogInUseCase {
    suspend operator fun invoke(): Result<Unit, Throwable>
}