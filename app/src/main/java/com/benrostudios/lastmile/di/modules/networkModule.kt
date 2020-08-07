package com.benrostudios.lastmile.di.modules

import com.benrostudios.lastmile.data.network.service.AuthService
import com.benrostudios.lastmile.data.network.service.ClientService
import com.benrostudios.lastmile.data.network.service.DeliveryService
import org.koin.dsl.module

val networkModule = module {
    single { AuthService() }
    single { DeliveryService() }
    single { ClientService() }
}