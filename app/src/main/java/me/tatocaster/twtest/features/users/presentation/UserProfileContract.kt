package me.tatocaster.twtest.features.users.presentation

import me.tatocaster.twtest.features.users.models.User

/**
 * Created by tatocaster on 12.10.17.
 */
interface UserProfileContract {

    interface View {
        fun loadUserList(users: List<User>)

        fun closeRealm()

        fun showError(e: Exception)
    }

    interface Presenter {
        fun onCreate()

        fun onDestroy()

        fun closeRealm()
    }
}
