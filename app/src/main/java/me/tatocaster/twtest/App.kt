package me.tatocaster.twtest

import android.app.Application
import android.content.Context
import com.facebook.soloader.SoLoader
import io.realm.Realm
import io.realm.RealmConfiguration


/**
 * Created by tatocaster on 11.10.17.
 */
class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        SoLoader.init(this, false)
        Realm.init(this)
        val config = RealmConfiguration.Builder().name("twtest.realm").build()
        Realm.setDefaultConfiguration(config)
        initComponents()
    }

    private fun initComponents() {
        appComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
        appComponent.inject(this)
    }

    companion object {
        @JvmStatic
        fun getAppContext(context: Context): App = context.applicationContext as App
    }
}

