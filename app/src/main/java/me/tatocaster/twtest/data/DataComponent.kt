package me.tatocaster.twtest.data

import me.tatocaster.twtest.data.api.ApiService



/**
 * Created by tatocaster on 11.10.17.
 */
interface DataComponent {
    fun exposeApiService(): ApiService
}
