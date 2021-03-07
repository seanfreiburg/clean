package com.sf.login_ui

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.github.michaelbull.result.Err
import com.github.michaelbull.result.Ok
import com.sf.login_domain.pub.useCase.IsLoggedInUseCase
import com.sf.login_domain.pub.useCase.LogInUseCase
import com.sf.login_domain.pub.useCase.LogOutUseCase
import dagger.Binds
import dagger.Module
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap
import javax.annotation.meta.Exhaustive
import kotlinx.coroutines.launch

data class LoginState(val count: Int = 0, val loggedIn: Boolean= false) : MavericksState

class LoginViewModel @AssistedInject constructor(
    @Assisted initialState: LoginState,
    private val isLoggedInUseCase: IsLoggedInUseCase,
    private val logInUseCase: LogInUseCase,
    private val logOutUseCase: LogOutUseCase
) : MavericksViewModel<LoginState>(initialState) {

    init {
        viewModelScope.launch {
            val isLoggedIn = isLoggedInUseCase.invoke()
            @Exhaustive
            when (isLoggedIn) {
                is Ok -> setState { copy(loggedIn = isLoggedIn.value) }
                is Err -> TODO()
            }
        }

    }

    fun incrementCount() {
        setState { copy(count = count + 1) }
    }

    fun logIn(){
        viewModelScope.launch {
            when (logInUseCase()) {
                is Ok -> setState { copy(loggedIn = true) }
                is Err -> TODO()
            }
        }
    }

    fun logOut() {
        viewModelScope.launch {
            when (logOutUseCase()) {
                is Ok -> setState { copy(loggedIn = false) }
                is Err -> TODO()
            }
        }
    }

    @AssistedFactory
    interface Factory : AssistedViewModelFactory<LoginViewModel, LoginState> {
        override fun create(state: LoginState): LoginViewModel
    }

    companion object :
        MavericksViewModelFactory<LoginViewModel, LoginState> by hiltMavericksViewModelFactory()

}

@Module
@InstallIn(MavericksViewModelComponent::class)
interface ViewModelsModule {
    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun loginViewModelFactory(factory: LoginViewModel.Factory): AssistedViewModelFactory<*, *>
}