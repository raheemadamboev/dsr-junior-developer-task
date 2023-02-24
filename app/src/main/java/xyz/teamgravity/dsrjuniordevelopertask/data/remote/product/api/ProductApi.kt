package xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.api

import retrofit2.http.GET
import retrofit2.http.Query
import xyz.teamgravity.dsrjuniordevelopertask.data.remote.product.dto.ProductResponseDto

interface ProductApi {

    ///////////////////////////////////////////////////////////////////////////
    // GET
    ///////////////////////////////////////////////////////////////////////////

    @GET("/products")
    suspend fun getProducts(
        @Query("skip") skip: Int,
        @Query("limit") limit: Int,
    ): ProductResponseDto
}