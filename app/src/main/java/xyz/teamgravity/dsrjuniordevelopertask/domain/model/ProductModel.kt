package xyz.teamgravity.dsrjuniordevelopertask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProductModel(
    val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val images: List<String>,
) : Parcelable
