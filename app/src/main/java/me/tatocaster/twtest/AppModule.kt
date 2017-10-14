package me.tatocaster.twtest

import android.app.Application
import android.content.Context
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Singleton


/**
 * Created by tatocaster on 11.10.17.
 */
@Module
class AppModule(application: Application) {

    private var appContext: Context = application.baseContext

    @Provides
    @Singleton
    fun provideApplication(): Context = appContext

    @Provides
    @Singleton
    fun provideAppResources(): Resources = appContext.resources

    @Provides
    @Singleton
    fun provideLocale(): Locale = Locale.getDefault()

}
