package com.benrostudios.lastmile.di.modules

import com.benrostudios.lastmile.data.repository.AuthRepo
import com.benrostudios.lastmile.data.repository.AuthRepoImpl
import com.benrostudios.lastmile.utils.SharedPreferenceUtils
import org.koin.dsl.module

val repositoryModule = module {
    single<AuthRepo> { AuthRepoImpl(get()) }
    single { SharedPreferenceUtils(get()) }
}