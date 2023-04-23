# Sakila SOAP API
## Project Overview
The Sakila SOAP API is a web service that provides access to the Sakila database using the SOAP protocol. It allows users to query the database and retrieve information about films, actors, customers, and more.
## Documentation
[SOAP UI](soapui-project.xml)
## Installation
* Clone the project

```
    git clone https://github.com/Dina-Mishahed/Sakila_Soap_API.git
```
### MySQL
* Download the Sakila Database from this link:
```
    https://www.sqliz.com/sakila/installation/ 
```
* Create a database schema and provide the username and password in the persistence.xml

* Go to the project directory
```
    cd Sakila_Soap_API
```
* Change the configuration of Tomcat in pom.xml.
* Run your tomcat apache server and then change the configuration of tomcat in pom.xml.
* Finally, deploy the application using the following maven command.
```
mvn clean package tomcat7:deploy
```
## Technologies Used
* JAX-WS
* Maven
* Lombok
* Tomcat
* Jakarta persistance (Hibernate)
* MySql
* Postman
* JSON-B
* JAX-B
* MapStruct
* PostMan

## Endpoints

* `/sakila/actor`: Actor web service
* `/sakila/category`: Category web service
* `/sakila/payment`: Payment web service
* `/sakila/rental`: Rental web service
* `/sakila/inventory`: Inventory web service
* `/sakila/actor`: Customer web service
* `/sakila/address`: Address web service
* `/sakila/film`: Film web service
* `/sakila/staff`: Staff web service
* `/sakila/store`: Store web service
