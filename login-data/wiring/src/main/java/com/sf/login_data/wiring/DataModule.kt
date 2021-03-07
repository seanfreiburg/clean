package com.sf.login_data.wiring

import com.sf.login_data.FakeLoginLocalStore
import com.sf.login_data.FakeLoginNetwork
import com.sf.login_domain.pub.data.LoginLocalStore
import com.sf.login_domain.pub.data.LoginNetwork
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {
    @Binds
    fun bindLoginLocalStore(useCase: FakeLoginLocalStore): LoginLocalStore

    @Binds
    fun bindLoginNetwork(useCase: FakeLoginNetwork): LoginNetwork
}