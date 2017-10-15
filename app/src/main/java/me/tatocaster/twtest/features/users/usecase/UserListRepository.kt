package me.tatocaster.twtest.features.users.usecases

import io.reactivex.Single
import me.tatocaster.twtest.data.api.ApiService
import me.tatocaster.twtest.data.database.RealmService
import me.tatocaster.twtest.features.users.models.User
import javax.inject.Inject

/**
 * Created by tatocaster on 12.10.17.
 */
interface GetUserList {
    fun call(): Single<List<User>>
    fun getAllUsersFromRealm(): Single<List<User>>
    fun closeRealm()
}

class GetUserListImpl @Inject constructor(private val mApiService: ApiService, private val mRealmService: RealmService) : GetUserList {

    override fun call(): Single<List<User>> {
        return mApiService.getUsers()
                .flatMapIterable({ users -> users })
                .toList()
    }

    override fun getAllUsersFromRealm(): Single<List<User>> =
            mRealmService.getAllUsers().flatMapIterable({ users -> users }).toList()

    override fun closeRealm() {
        mRealmService.closeRealm()
    }
}