package com.sf.login_domain.wiring

import com.sf.login_domain.impl.RealIsLoggedInUseCase
import com.sf.login_domain.impl.RealLogInUseCase
import com.sf.login_domain.impl.RealLogOutUseCase
import com.sf.login_domain.pub.useCase.IsLoggedInUseCase
import com.sf.login_domain.pub.useCase.LogInUseCase
import com.sf.login_domain.pub.useCase.LogOutUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UseCaseModule {
    @Binds
    fun bindIsLoggedInUseCase(useCase: RealIsLoggedInUseCase): IsLoggedInUseCase

    @Binds
    fun bindLogInUseCase(useCase: RealLogInUseCase): LogInUseCase

    @Binds
    fun bindLogOutUseCase(useCase: RealLogOutUseCase): LogOutUseCase
}