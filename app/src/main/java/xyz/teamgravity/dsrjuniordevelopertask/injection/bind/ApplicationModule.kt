package xyz.teamgravity.dsrjuniordevelopertask.injection.bind

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import xyz.teamgravity.dsrjuniordevelopertask.data.repository.MainRepositoryImp
import xyz.teamgravity.dsrjuniordevelopertask.domain.repository.MainRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ApplicationModule {

    @Binds
    @Singleton
    abstract fun bindTimberTree(timberDebugTree: Timber.DebugTree): Timber.Tree

    @Binds
    @Singleton
    abstract fun bindMainRepository(mainRepositoryImp: MainRepositoryImp): MainRepository
}