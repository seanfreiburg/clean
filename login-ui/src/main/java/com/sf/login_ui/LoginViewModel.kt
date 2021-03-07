package com.sf.login_ui

import com.airbnb.mvrx.MavericksState
import com.airbnb.mvrx.MavericksViewModel
import com.airbnb.mvrx.MavericksViewModelFactory
import com.sf.login_domain.pub.useCase.IsLoggedInUseCase
import dagger.Binds
import dagger.Module
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.InstallIn
import dagger.multibindings.IntoMap

data class LoginState(val count: Int = 0) : MavericksState

class LoginViewModel @AssistedInject constructor(
    @Assisted initialState: LoginState,
    private val isLoggedInUseCase: IsLoggedInUseCase
) : MavericksViewModel<LoginState>(initialState) {

    fun incrementCount() {
        setState { copy(count = count + 1) }
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