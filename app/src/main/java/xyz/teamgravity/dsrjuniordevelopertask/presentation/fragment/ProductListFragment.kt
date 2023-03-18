package xyz.teamgravity.dsrjuniordevelopertask.presentation.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import xyz.teamgravity.dsrjuniordevelopertask.core.extension.navigateSafely
import xyz.teamgravity.dsrjuniordevelopertask.databinding.FragmentProductListBinding
import xyz.teamgravity.dsrjuniordevelopertask.domain.model.ProductModel
import xyz.teamgravity.dsrjuniordevelopertask.presentation.adapter.ProductAdapter
import xyz.teamgravity.dsrjuniordevelopertask.presentation.adapter.ProductLoadStateAdapter
import xyz.teamgravity.dsrjuniordevelopertask.presentation.viewmodel.ProductListViewModel
import javax.inject.Inject

@AndroidEntryPoint
class ProductListFragment : Fragment(), ProductAdapter.ProductListener {

    companion object {
        private const val SPAN_COUNT = 2
    }

    private var _binding: FragmentProductListBinding? = null
    private val binding get() = _binding!!

    private val viewmodel by viewModels<ProductListViewModel>()

    @Inject
    lateinit var adapter: ProductAdapter

    @Inject
    lateinit var headerAdapter: ProductLoadStateAdapter

    @Inject
    lateinit var footerAdapter: ProductLoadStateAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentProductListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateUI()
        observe()
    }

    private fun updateUI() {
        recyclerview()
    }

    private fun observe() {
        observeProducts()
    }

    private fun recyclerview() {
        binding.apply {
            adapter.listener = this@ProductListFragment
            val gridLayoutManager = GridLayoutManager(requireContext(), SPAN_COUNT)
            gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
                override fun getSpanSize(position: Int): Int {
                    return if ((position == adapter.itemCount && footerAdapter.itemCount > 0) || (position == 0 && headerAdapter.itemCount > 0)) 2 else 1
                }
            }
            recyclerview.layoutManager = gridLayoutManager
            recyclerview.adapter = adapter.withLoadStateHeaderAndFooter(
                header = headerAdapter,
                footer = footerAdapter,
            )
        }
    }

    private fun observeProducts() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewmodel.products.collectLatest { data ->
                adapter.submitData(data)
            }
        }
    }

    override fun onProductClick(product: ProductModel) {
        findNavController().navigateSafely(ProductListFragmentDirections.actionProductListFragmentToProductFragment(product))
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}