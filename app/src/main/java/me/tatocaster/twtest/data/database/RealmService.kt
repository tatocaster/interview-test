package me.tatocaster.twtest.data.database

import io.reactivex.Flowable
import io.realm.Realm
import io.realm.RealmResults
import me.tatocaster.twtest.features.users.models.User


/**
 * Created by tatocaster on 15.10.17.
 */
class RealmService {
    private var mRealm: Realm = Realm.getDefaultInstance()

    fun closeRealm() {
        mRealm.close()
    }

    fun saveUsers(users: List<User>) {
        mRealm.executeTransactionAsync({ realm ->
            realm.insertOrUpdate(users)
        }, {
            // Transaction was a success.
            println("INSERT SUCCESSFUL")
        }, { e ->
            // Transaction failed and was automatically canceled.
            println(e)
        })
    }

    fun getAllUsers(): Flowable<RealmResults<User>> = mRealm.where(User::class.java).findAll().asFlowable()

}