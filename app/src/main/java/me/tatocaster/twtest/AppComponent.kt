package me.tatocaster.twtest

import android.content.Context
import android.content.res.Resources
import dagger.Component
import me.tatocaster.twtest.data.DataComponent
import me.tatocaster.twtest.data.DataModule
import java.util.*
import javax.inject.Singleton


/**
 * Created by tatocaster on 11.10.17.
 */
@Singleton
@Component(modules = arrayOf(AppModule::class, DataModule::class))
interface AppComponent : DataComponent {

    fun inject(app: App)

    // expose dependencies to scope graph
    fun exposeAppContext(): Context

    fun exposeResources(): Resources

    fun exposeLocale(): Locale

}
