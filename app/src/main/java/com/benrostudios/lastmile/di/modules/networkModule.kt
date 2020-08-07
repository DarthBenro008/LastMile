package com.benrostudios.lastmile.di.modules

import com.benrostudios.lastmile.data.network.service.AuthService
import org.koin.dsl.module

val networkModule = module {
    single { AuthService() }
}