package com.sf.login_ui

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel

data class LoginState(val count: Int = 0) : MavericksState

class LoginViewModel(initialState: LoginState) : MavericksViewModel<LoginState>(initialState) {

    fun incrementCount() {
        setState { copy(count = count + 1) }
    }

}