package xyz.teamgravity.dsrjuniordevelopertask.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import xyz.teamgravity.dsrjuniordevelopertask.R
import xyz.teamgravity.dsrjuniordevelopertask.core.extension.centerCrop
import xyz.teamgravity.dsrjuniordevelopertask.databinding.CardProductBinding
import xyz.teamgravity.dsrjuniordevelopertask.domain.model.ProductModel

class ProductAdapter(
    diff: ProductDiff,
) : PagingDataAdapter<ProductModel, ProductAdapter.ProductViewHolder>(diff) {

    var listener: ProductListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(CardProductBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        getItem(position)?.let(holder::bind)
    }

    ///////////////////////////////////////////////////////////////////////////
    // MISC
    ///////////////////////////////////////////////////////////////////////////

    inner class ProductViewHolder(private val binding: CardProductBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.root.setOnClickListener {
                val position = bindingAdapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val product = getItem(position)
                    if (product != null) listener?.onProductClick(product)
                }
            }
        }

        fun bind(model: ProductModel) {
            binding.apply {
                model.images.firstOrNull()?.let(imageI::centerCrop)
                titleT.text = model.title
                priceT.text = root.context.getString(R.string.your_price, model.price)
            }
        }
    }

    class ProductDiff : DiffUtil.ItemCallback<ProductModel>() {
        override fun areItemsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: ProductModel, newItem: ProductModel): Boolean {
            return oldItem == newItem
        }
    }

    fun interface ProductListener {
        fun onProductClick(product: ProductModel)
    }
}