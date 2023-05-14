package com.example.kimziapplication.di


import com.example.kimziapplication.di.qualifire.SiteName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {
    @Provides
    @Singleton
    fun ProvideUserName()="Kimiya BazgirFard"
    //یه شکل دیگه تابع بالا میشه اینجوری
    /*fun ProvidesUserName():String{
        return "Kimiya BazgirFard"
    }*/

    @Provides
    @SiteName
    fun ProvideSiteName()="kimiyaBazgir@hc.com"

}