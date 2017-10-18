package me.tatocaster.twtest.features.users.usecase

import io.reactivex.Flowable
import me.tatocaster.twtest.data.api.ApiService
import me.tatocaster.twtest.data.database.RealmService
import me.tatocaster.twtest.features.users.models.User
import javax.inject.Inject

/**
 * Created by tatocaster on 12.10.17.
 */
interface UserListRepository {
    fun call(): Flowable<List<User>>
    fun getAllUsersFromRealm(): Flowable<List<User>>
    fun saveUsers(users: List<User>)
    fun closeRealm()
}

class UserListRepositoryImpl @Inject constructor(private val mApiService: ApiService, private val mRealmService: RealmService) : UserListRepository {

    override fun call(): Flowable<List<User>> = mApiService.getUsers()


    override fun getAllUsersFromRealm(): Flowable<List<User>> = mRealmService.getAllUsers()

    override fun saveUsers(users: List<User>) {
        mRealmService.saveUsers(users)
    }

    override fun closeRealm() {
        mRealmService.closeRealm()
    }
}