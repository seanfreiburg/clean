package com.sf.login_domain.wiring

import com.sf.login_domain.impl.RealIsLoggedInUseCase
import com.sf.login_domain.pub.useCase.IsLoggedInUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @Binds
    fun bindIsLoggedInUseCase(useCase: RealIsLoggedInUseCase): IsLoggedInUseCase
}