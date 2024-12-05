package order

import com.order.ProductService
import grails.converters.JSON

class ProductController {

    ProductService productService;

    def createProduct(ProductCO productCO) {
        log.info("Creating product")
        if (!productCO.validate()) {
            renderErrorMessages(productCO)
            return
        }
        Product product = productService.createProduct(productCO)
        if (product.getId()) {
            render([product: product] as JSON, status: 201)
        } else {
            render([message: "Product with the given name already exists"] as JSON, status: 409)
        }
    }

    def productList() {
        log.info("Fetching products")
        def products = productService.productList(params)
        render(products as JSON)
    }

    private void renderErrorMessages(ProductCO productCO) {
        def errorMessages = productCO.errors.allErrors.collect { it.defaultMessage }
        render([message: "Product validation failed", errors: errorMessages] as JSON, status: 400)
    }
}
