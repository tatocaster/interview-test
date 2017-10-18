package me.tatocaster.twtest.features.users.presentation

import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.tatocaster.twtest.features.users.usecase.UserListRepository
import javax.inject.Inject

/**
 * Created by tatocaster on 12.10.17.
 */
class UserProfilePresenter @Inject
constructor(
        private val view: UserProfileContract.View,
        private val repository: UserListRepository) : UserProfileContract.Presenter {


    override fun closeRealm() {
        repository.closeRealm()
    }

    private val disposables: CompositeDisposable = CompositeDisposable()

    override fun onCreate() {
        disposables.add(repository.call()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { users ->
                            view.loadUserList(users)
                            repository.saveUsers(users)
                        },
                        { e ->
                            Log.e("error", e.message, e)
                            view.showMessage("Loading from cache")
                            repository.getAllUsersFromRealm().subscribe({ data -> view.loadUserList(data) })
                        }
                ))
    }

    override fun onDestroy() {
        disposables.clear()
    }

}