package com.sf.login_domain.impl

import com.sf.login_domain.pub.data.LoginLocalStore
import com.sf.login_domain.pub.data.LoginNetwork

// fetch and store data, thats all
class RealLoginRepo constructor(
    private val network: LoginNetwork,
    private val localStore: LoginLocalStore
) : LoginRepo {
    override suspend fun fetchLoginState(): Result<Boolean> {
        TODO("Not yet implemented")
    }

}