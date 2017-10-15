package me.tatocaster.twtest.data

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import me.tatocaster.twtest.data.api.ApiService
import me.tatocaster.twtest.data.database.RealmService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Created by tatocaster on 11.10.17.
 */
@Module
class DataModule {

    @Provides
    @Singleton
    fun provideApi(retrofit: Retrofit): ApiService = retrofit.create(ApiService::class.java)

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .client(OkHttpClient.Builder()
                        .addInterceptor(loggingInterceptor)
                        .build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    /*@Provides
    fun provideRealm(): Realm = Realm.getDefaultInstance()*/

    @Provides
    fun provideRealmService(): RealmService = RealmService()
}
