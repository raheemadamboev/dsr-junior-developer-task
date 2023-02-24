package xyz.teamgravity.dsrjuniordevelopertask.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import xyz.teamgravity.dsrjuniordevelopertask.domain.model.ProductModel
import xyz.teamgravity.dsrjuniordevelopertask.domain.usecase.GetProducts
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    getProducts: GetProducts,
) : ViewModel() {

    val products: Flow<PagingData<ProductModel>> = getProducts().cachedIn(viewModelScope)
}