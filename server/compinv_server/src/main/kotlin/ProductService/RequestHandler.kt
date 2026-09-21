package com.mustafayuumi.ProductService

import com.mustafayuumi.DataService.DatabaseFactory
import io.ktor.server.response.respond
import io.ktor.server.routing.Route
import io.ktor.server.routing.get

fun Route.productService() {
    get("product/getall") {

        call.respond("product/getall, ${DatabaseFactory.testConnection().toString()}")

    }
}