package com.benrostudios.lastmile.di.modules

import com.benrostudios.lastmile.data.repository.AuthRepo
import com.benrostudios.lastmile.data.repository.AuthRepoImpl
import com.benrostudios.lastmile.ui.auth.signin.SignInViewModel
import com.benrostudios.lastmile.ui.auth.signup.SignUpViewModel
import com.benrostudios.lastmile.ui.client.dashboard.DashboardViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { SignInViewModel(get()) }
    viewModel { SignUpViewModel(get()) }
    viewModel { DashboardViewModel(get()) }
}