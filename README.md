# Loan Microservice
  * Microservice project for getting loan information and quotes based on types of loans
---
This projects consists of following springboot application
1. loan-service 
2. quote-serice
3. api-gateway
4. naming-servier
5. config-server
---
## loan-service
* It accept direct call from client and internally calls quote-service
* It can fetche its configuration properties from config-server
* It exposes following api-calls
  * _loan/products_ : Returns all the products available for loan to client
  * _/loan/product/{productId}_ : Returns product based on productId to client
  * _/loan/quote_: Accepts the customer request and returns quote for loan
  * _loan/properties_ : Return the properties for loan-service application saved on config-server
---

## quote-service
* It provides data to loan-service 
* It uses in-memory databse h2 for database operations.
* It exposes following api-calls:
  * _quote/products_ : Returns all the products available to loan-service
  * _/quote/product/{productId}_ : Returns product based on productId to loan-service
  * _/quote/interestRate/{productId}_: Returns interestRate based on productId to loan-service
  * _loan/properties_ : Return the properties for loan-service application saved on config-server
  
## api-gateway
* Its receives the calls from client and forwards them to loan-service or quote service based on url pattern.
* It logs all the incoming requests

## naming-servier
* Spring Eureka server is used as naming server which serves as sevice registry
* It also peroform load balancing in the behind

## config-server
* Provides the configuration properties to loan-service and quote-service
* Fetches the properties from a local git repo


      
