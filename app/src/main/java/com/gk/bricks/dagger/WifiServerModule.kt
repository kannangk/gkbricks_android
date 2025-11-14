package com.gk.bricks.dagger

import android.app.Application
import com.gk.bricks.datasource.SharedPrefDelegate
import com.gk.bricks.datasource.firebase.FirebaseInterface
import com.gk.bricks.datasource.firebase.FirebaseInterfaceImpl
import com.gk.bricks.service.UdpReceiver
import com.gk.bricks.wifi.WifiLopInterface
import com.gk.bricks.wifi.WifiLopInterfaceImpl
import com.gk.bricks.wifi.WifiServerInterface
import com.gk.bricks.wifi.WifiServerInterfaceImpl
import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class WifiServerModule {

    @Provides
    @Singleton
    fun provideWifiServerModule(
        app : Application,
    ) : WifiServerInterface{
        return WifiServerInterfaceImpl(app)
    }

    @Provides
    @Singleton
    fun provideWifiLopModule(
        app : Application,
    ) : WifiLopInterface{
        return WifiLopInterfaceImpl(app)
    }

    @Provides
    @Singleton
    fun provideFirebaseDatabase(): FirebaseDatabase {
        return FirebaseDatabase.getInstance()
    }

    @Provides
    @Singleton
    fun provideFirebaseInterface(
        database: FirebaseDatabase,
        dataSource: SharedPrefDelegate,
    ): FirebaseInterface {
        return FirebaseInterfaceImpl(database, dataSource)
    }


}