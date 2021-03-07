package com.sf.login_domain.wiring

import com.sf.login_domain.impl.LoginRepo
import com.sf.login_domain.impl.RealLoginRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepoModule {
    @Binds
    fun bindLoginRepo(repo: RealLoginRepo): LoginRepo
}