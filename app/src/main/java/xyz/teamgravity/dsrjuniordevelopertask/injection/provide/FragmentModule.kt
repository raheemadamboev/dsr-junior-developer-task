package xyz.teamgravity.dsrjuniordevelopertask.injection.provide

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import xyz.teamgravity.dsrjuniordevelopertask.presentation.adapter.ProductAdapter
import xyz.teamgravity.dsrjuniordevelopertask.presentation.adapter.ProductLoadStateAdapter

@Module
@InstallIn(FragmentComponent::class)
object FragmentModule {

    @Provides
    @FragmentScoped
    fun provideProductDiff(): ProductAdapter.ProductDiff = ProductAdapter.ProductDiff()

    @Provides
    @FragmentScoped
    fun provideProductAdapter(productDiff: ProductAdapter.ProductDiff): ProductAdapter = ProductAdapter(productDiff)

    @Provides
    fun provideProductLoadStateAdapter(): ProductLoadStateAdapter = ProductLoadStateAdapter()
}