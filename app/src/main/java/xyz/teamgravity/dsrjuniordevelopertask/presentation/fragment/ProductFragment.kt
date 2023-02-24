package xyz.teamgravity.dsrjuniordevelopertask.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.teamgravity.dsrjuniordevelopertask.R
import xyz.teamgravity.dsrjuniordevelopertask.core.extension.fitCenter
import xyz.teamgravity.dsrjuniordevelopertask.databinding.FragmentProductBinding
import xyz.teamgravity.dsrjuniordevelopertask.domain.model.ProductModel
import xyz.teamgravity.dsrjuniordevelopertask.presentation.viewmodel.ProductViewModel

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    private val viewmodel by viewModels<ProductViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observe()
        button()
    }

    private fun observe() {
        observeProduct()
    }

    private fun button() {
        onBack()
    }

    private fun updateProduct(product: ProductModel) {
        binding.apply {
            product.images.firstOrNull()?.let(imageI::fitCenter)
            titleT.text = product.title
            brandT.text = product.brand
            ratingT.text = getString(R.string.your_rating, product.rating)
            stockT.text = getString(R.string.your_product_left, product.stock)
            priceT.text = getString(R.string.your_price, product.price)
            descriptionT.text = product.description
        }
    }

    private fun observeProduct() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewmodel.product.collectLatest { product ->
                updateProduct(product)
            }
        }
    }

    private fun onBack() {
        binding.toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}