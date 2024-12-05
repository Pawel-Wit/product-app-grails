package myAppGrails

@SuppressWarnings('GrailsDomainReservedSqlKeywordName')
class Vehicle {

    Long id  // Możesz jawnie zdefiniować identyfikator, ale Grails stworzy go automatycznie
    String name

    static constraints = {
        name maxSize: 255  // Możesz określić maksymalną długość dla nazwy
    }
}
