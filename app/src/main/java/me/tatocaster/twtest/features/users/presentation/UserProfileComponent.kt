package me.tatocaster.twtest.features.users.presentation

import dagger.Component
import me.tatocaster.twtest.AppComponent
import me.tatocaster.twtest.di.scope.ViewScope
import me.tatocaster.twtest.features.users.usecase.UserProfileUseCaseModule

/**
 * Created by tatocaster on 12.10.17.
 */
@ViewScope
@Component(dependencies = arrayOf(AppComponent::class), modules = arrayOf(UserProfileModule::class, UserProfileUseCaseModule::class))
interface UserProfileComponent {

    fun inject(view: UserProfileView)

}
