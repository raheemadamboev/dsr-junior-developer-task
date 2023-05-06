package xyz.teamgravity.dsrjuniordevelopertask.data.mapper

import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.dto.ProductDto
import xyz.teamgravity.dsrjuniordevelopertask.domain.model.ProductModel

fun ProductDto.toModel(): ProductModel {
    return ProductModel(
        id = id,
        title = title,
        description = description,
        price = price,
        rating = rating,
        stock = stock,
        brand = brand,
        images = images
    )
}