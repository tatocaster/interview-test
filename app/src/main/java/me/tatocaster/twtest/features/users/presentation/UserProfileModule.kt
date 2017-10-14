package me.tatocaster.twtest.features.users.presentation

import dagger.Module
import dagger.Provides

/**
 * Created by tatocaster on 12.10.17.
 */
@Module
class UserProfileModule(private val view: UserProfileContract.View) {

    @Provides
    fun provideView(): UserProfileContract.View = this.view

    @Provides
    fun providePresenter(presenter: UserProfilePresenter): UserProfileContract.Presenter = presenter
}
