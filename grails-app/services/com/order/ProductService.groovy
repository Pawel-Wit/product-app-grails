package com.order

import grails.gorm.transactions.Transactional
import order.Product
import order.ProductCO

class ProductService {

    @Transactional
    def createProduct(ProductCO productCO) {
        Product product = mapToDomain(productCO)
        if (product.validate()) {
            saveProduct(product)
            return product
        }
    }

    def productList(Map params) {
        def products = Product.list(params)
        def totalProducts = Product.count()
        return [
                products: products,
                total   : totalProducts,
                offset  : params.int('offset') ?: 0,
                max     : params.int('max') ?: 10
        ]
    }

    private void saveProduct(Product product) {
        if (!product.save(flush: true)) {
            println product.errors
        }
    }

    private Product mapToDomain(ProductCO productCO) {
        return new Product(productCO.getName(), productCO.getPrice())
    }
}
