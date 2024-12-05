package order

import grails.validation.Validateable

class ProductCO implements Validateable {

    String name;
    Long price;

    static constraints = {
        name nullable: false, blank: false, minSize: 3
        price nullable: false, min: 1L
    }
}
