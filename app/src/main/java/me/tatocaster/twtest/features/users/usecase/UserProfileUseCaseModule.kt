package me.tatocaster.twtest.features.users.usecase

import dagger.Module
import dagger.Provides

/**
 * Created by tatocaster on 12.10.17.
 */
@Module
class UserProfileUseCaseModule {
    @Provides
    fun provideGetAllAvailableProviders(usecase: UserListRepositoryImpl): UserListRepository = usecase
}