This project implement a small REST API that provides a service that checks the Add-on availability for a given postcode 
(either all add-ons are available for that postcode or none are).

Rest Service Address (POST) http://localhost:8080/shopping-basket/service/showBasket

Method GET - Examples:

SERVICE_AVAILABLE
http://localhost:8080/shopping-basket/service/showBasket?postcode=1111

SERVICE_UNAVAILABLE
http://localhost:8080/shopping-basket/service/showBasket?postcode=2222

SERVICE_PLANNED
http://localhost:8080/shopping-basket/service/showBasket?postcode=3333

POSTCODE_INVALID
http://localhost:8080/shopping-basket/service/showBasket?postcode=4444

Maven Project External Dependencies:
JUnit 4.4
Jersey 1.9
Application Server: Apache Tomcat 8.0

Java Version: 8
