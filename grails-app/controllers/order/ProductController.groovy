package order

import com.order.ProductService
import grails.converters.JSON

class ProductController {

    ProductService productService;

    def createProduct(ProductCO productCO) {
        log.info("Creating product")
        if (!productCO.validate()) {
            render([message: "Product validation failed"] as JSON, status: 400)
            return
        }
        Product product = productService.createProduct(productCO)
        if (product.id != null) {
            render([product: product] as JSON, status: 201)
        } else {
            render([message: "Product with the given name already exists"] as JSON, status: 400)
        }
    }

    def productList() {
        log.info("Fetching products")
        def products = productService.productList(params)
        render(products as JSON)
    }
}
