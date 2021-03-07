package com.sf.login_domain.impl

interface LoginRepo {
    suspend fun fetchLoginState(): Result<Boolean>
}