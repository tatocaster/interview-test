package me.tatocaster.twtest.data

import me.tatocaster.twtest.data.api.ApiService
import me.tatocaster.twtest.data.database.RealmService


/**
 * Created by tatocaster on 11.10.17.
 */
interface DataComponent {
    fun exposeApiService(): ApiService

    fun exposeRealmService(): RealmService
}
