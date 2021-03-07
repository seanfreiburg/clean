package com.sf.login_domain.pub.useCase

interface IsLoggedInUseCase {
    suspend operator fun invoke(): Result<Boolean>
}