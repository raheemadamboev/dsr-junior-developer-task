package xyz.teamgravity.dsrjuniordevelopertask.data.repository

import androidx.paging.Pager
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.dto.ProductDto
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.mapper.toModel
import xyz.teamgravity.dsrjuniordevelopertask.domain.model.ProductModel
import xyz.teamgravity.dsrjuniordevelopertask.domain.repository.MainRepository

class MainRepositoryImp(
    private val getProductsPager: Pager<Int, ProductDto>,
) : MainRepository {

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    override fun getProducts(): Flow<PagingData<ProductModel>> {
        return getProductsPager.flow.map { dtos -> dtos.map { dto -> dto.toModel() } }
    }
}