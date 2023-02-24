package xyz.teamgravity.dsrjuniordevelopertask.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import xyz.teamgravity.dsrjuniordevelopertask.core.extension.gone
import xyz.teamgravity.dsrjuniordevelopertask.core.extension.visible
import xyz.teamgravity.dsrjuniordevelopertask.databinding.CardProductLoadStateBinding

class ProductLoadStateAdapter : LoadStateAdapter<ProductLoadStateAdapter.ProductLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: ProductLoadStateViewHolder, loadState: LoadState) {
        holder.bind(loadState)
    }

    override fun onCreateViewHolder(parent: ViewGroup, loadState: LoadState): ProductLoadStateViewHolder {
        return ProductLoadStateViewHolder(CardProductLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    ///////////////////////////////////////////////////////////////////////////
    // MISC
    ///////////////////////////////////////////////////////////////////////////

    class ProductLoadStateViewHolder(private val binding: CardProductLoadStateBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: LoadState) {
            binding.apply {
                when (model) {
                    is LoadState.NotLoading -> {
                        progressBar.gone()
                    }

                    LoadState.Loading -> {
                        progressBar.visible()
                        errorT.gone()
                    }

                    is LoadState.Error -> {
                        progressBar.gone()
                        errorT.text = model.error.message
                        errorT.visible()
                    }
                }
            }
        }
    }
}