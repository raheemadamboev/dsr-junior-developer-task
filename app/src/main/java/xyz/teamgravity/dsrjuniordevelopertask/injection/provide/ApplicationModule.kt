@file:Suppress("JSON_FORMAT_REDUNDANT")

package xyz.teamgravity.dsrjuniordevelopertask.injection.provide

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import timber.log.Timber
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.api.ProductApi
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.constant.ProductConst
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.datasource.ProductPagingSource
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.dto.ProductDto
import xyz.teamgravity.dsrjuniordevelopertask.data.repository.MainRepositoryImp
import xyz.teamgravity.dsrjuniordevelopertask.domain.repository.MainRepository
import xyz.teamgravity.dsrjuniordevelopertask.domain.usecase.GetProducts
import xyz.teamgravity.dsrjuniordevelopertask.injection.name.GetProductsPager
import xyz.teamgravity.dsrjuniordevelopertask.injection.name.GetProductsPagingConfig
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApplicationModule {

    @Provides
    @Singleton
    fun provideTimberDebugTree(): Timber.DebugTree = Timber.DebugTree()

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(httpLoggingInterceptor)
        .build()

    @Provides
    @Singleton
    fun provideConverterFactory(): Converter.Factory = Json {
        ignoreUnknownKeys = true
    }.asConverterFactory("application/json".toMediaType())

    @Provides
    @Singleton
    fun provideProductApi(okHttpClient: OkHttpClient, converterFactory: Converter.Factory): ProductApi = Retrofit.Builder()
        .baseUrl(ProductConst.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(converterFactory)
        .build()
        .create(ProductApi::class.java)

    @Provides
    @Singleton
    fun provideProductPagingSource(productApi: ProductApi): ProductPagingSource = ProductPagingSource(productApi)

    @Provides
    @Singleton
    @GetProductsPagingConfig
    fun provideGetProductsPagingConfig(): PagingConfig = PagingConfig(
        pageSize = ProductConst.LIMIT,
        maxSize = ProductConst.MAX_SIZE,
        enablePlaceholders = false
    )

    @Provides
    @Singleton
    @GetProductsPager
    fun provideGetProductsPager(
        @GetProductsPagingConfig getProductsPagingConfig: PagingConfig,
        productsPagingSource: ProductPagingSource,
    ): Pager<Int, ProductDto> = Pager(
        config = getProductsPagingConfig,
        pagingSourceFactory = { productsPagingSource }
    )

    @Provides
    @Singleton
    fun provideMainRepositoryImp(
        @GetProductsPager getProductsPager: Pager<Int, ProductDto>,
    ): MainRepositoryImp = MainRepositoryImp(getProductsPager)

    @Provides
    @Singleton
    fun provideGetProducts(mainRepository: MainRepository): GetProducts = GetProducts(mainRepository)
}