package xyz.teamgravity.dsrjuniordevelopertask.domain.usecase

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.dsrjuniordevelopertask.domain.model.ProductModel
import xyz.teamgravity.dsrjuniordevelopertask.domain.repository.MainRepository

class GetProducts(
    private val repository: MainRepository,
) {

    operator fun invoke(): Flow<PagingData<ProductModel>> {
        return repository.getProducts()
    }
}