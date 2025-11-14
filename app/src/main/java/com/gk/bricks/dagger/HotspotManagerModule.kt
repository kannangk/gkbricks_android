package com.gk.bricks.dagger

import android.app.Application
import com.gk.bricks.managers.HotspotManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class HotspotManagerModule {

    @Provides
    @Singleton
    fun provideHotspotManagerModule(
        app : Application,
    ) : HotspotManager{
        return HotspotManager(app.applicationContext)
    }
}