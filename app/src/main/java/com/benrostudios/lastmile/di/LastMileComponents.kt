package com.benrostudios.lastmile.di

import com.benrostudios.lastmile.di.modules.networkModule
import com.benrostudios.lastmile.di.modules.repositoryModule
import com.benrostudios.lastmile.di.modules.viewModelModule

val appComponent = listOf(
    networkModule,
    repositoryModule,
    viewModelModule
)