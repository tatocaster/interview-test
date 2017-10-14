package me.tatocaster.twtest.features.users.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.tatocaster.twtest.features.users.usecases.GetUserList
import javax.inject.Inject

/**
 * Created by tatocaster on 12.10.17.
 */
class UserProfilePresenter @Inject
constructor(
        private val view: UserProfileContract.View,
        private val getUserList: GetUserList) : UserProfileContract.Presenter {

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate() {
        disposables.add(getUserList.call()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { users -> view.loadUserList(users) },
                        { error -> println("$error") }
                ))
    }

    override fun onDestroy() {
        disposables.clear()
    }

}