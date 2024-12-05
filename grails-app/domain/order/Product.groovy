package order

import grails.validation.Validateable

class Product implements Validateable {

    Long id
    String name;
    Long price;

    static constraints = {
        name nullable: false, blank: false, minSize: 3, unique: true
        price nullable: false, min: 1L
    }

    Product(String name, Long price) {
        this.name = name;
        this.price = price;
    }

}
