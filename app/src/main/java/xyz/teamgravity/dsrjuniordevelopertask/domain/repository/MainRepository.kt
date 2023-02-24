package xyz.teamgravity.dsrjuniordevelopertask.domain.repository

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.dsrjuniordevelopertask.domain.model.ProductModel

interface MainRepository {

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    fun getProducts(): Flow<PagingData<ProductModel>>
}