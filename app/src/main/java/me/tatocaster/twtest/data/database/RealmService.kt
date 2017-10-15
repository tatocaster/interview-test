package me.tatocaster.twtest.data.database

import io.realm.Realm
import io.realm.RealmResults
import me.tatocaster.twtest.features.users.models.User


/**
 * Created by tatocaster on 15.10.17.
 */
class RealmService {
    private lateinit var mRealm: Realm


    fun closeRealm() {
        mRealm.close()
    }

    fun saveUsers() {}

    fun getAllUsers(): RealmResults<User> {
        mRealm = Realm.getDefaultInstance()
        return mRealm.where(User::class.java).findAll()
    }

}