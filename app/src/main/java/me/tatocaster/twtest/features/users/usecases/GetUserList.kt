package me.tatocaster.twtest.features.users.usecases

import io.reactivex.Single
import me.tatocaster.twtest.data.api.ApiService
import me.tatocaster.twtest.features.users.models.User
import javax.inject.Inject

/**
 * Created by tatocaster on 12.10.17.
 */
interface GetUserList {
    fun call(): Single<List<User>>
}

class GetUserListImpl @Inject constructor(private val mApiService: ApiService) : GetUserList {

    override fun call(): Single<List<User>> {
        return mApiService.getUsers()
                .flatMapIterable({ users -> users })
                .toList()
    }

}