package me.tatocaster.twtest.data.api

import io.reactivex.Observable
import me.tatocaster.twtest.features.users.models.User
import retrofit2.http.GET


/**
 * Created by tatocaster on 11.10.17.
 */
interface ApiService {

    @GET("/users")
    fun getUsers(): Observable<List<User>>

}
