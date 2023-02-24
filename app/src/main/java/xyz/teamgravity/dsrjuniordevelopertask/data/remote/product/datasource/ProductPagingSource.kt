package xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.datasource

import androidx.paging.PagingSource
import androidx.paging.PagingState
import timber.log.Timber
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.api.ProductApi
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.constant.ProductConst
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.dto.ProductDto

class ProductPagingSource(
    private val api: ProductApi,
) : PagingSource<Int, ProductDto>() {

    override fun getRefreshKey(state: PagingState<Int, ProductDto>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductDto> {
        val skip = params.key ?: ProductConst.INITIAL_SKIP

        return try {
            val products = api.getProducts(
                skip = skip,
                limit = params.loadSize
            ).products

            LoadResult.Page(
                data = products,
                prevKey = if (skip == ProductConst.INITIAL_SKIP) null else skip - ProductConst.LIMIT,
                nextKey = if (products.isEmpty()) null else skip + ProductConst.LIMIT
            )
        } catch (e: Exception) {
            Timber.e(e)
            LoadResult.Error(e)
        }
    }
}