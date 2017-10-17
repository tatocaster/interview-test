package me.tatocaster.twtest.features.users.presentation

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import me.tatocaster.twtest.features.users.usecases.UserListRepository
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
                .onErrorResumeNext({ repository.getAllUsersFromRealm() })
                .mergeWith({ repository.getAllUsersFromRealm() })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        { users ->
                            view.loadUserList(users)
                            repository.saveUsers(users)
                            repository.getAllUsersFromRealm()
                                    .observeOn(AndroidSchedulers.mainThread()).subscribe({ u -> println("size: ${u.size}") })
                        }, { e -> view.showError(e as Exception) }
                ))
    }

    override fun onDestroy() {
        disposables.clear()
    }

}