package xyz.teamgravity.dsrjuniordevelopertask.presentation.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import xyz.teamgravity.dsrjuniordevelopertask.domain.model.ProductModel
import xyz.teamgravity.dsrjuniordevelopertask.presentation.fragment.ProductFragmentArgs
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    handle: SavedStateHandle,
) : ViewModel() {

    private val args = ProductFragmentArgs.fromSavedStateHandle(handle)

    private val _product = MutableStateFlow(args.product)
    val product: StateFlow<ProductModel> = _product.asStateFlow()
}