# SpringBoot Camunda Loan Application
This project is to support SpringBoot Camunda Loan Processing Project service UI, by providing the required API to render the required details on UI.   

# URL's to access the application from OpenAPI documentation
http://localhost:9090/camunda/swagger-ui/index.html#/

# URL to access the camunda dashboard
http://localhost:9090/camunda/camunda/app/welcome/default/#!/welcome


# URL to access the H2 Database Console
http://localhost:9090/camunda/h2-console


# Developer Guide:

For developer point of view the requried softwares to start with this project is 
Java 11
Maven 3.3.9
Spring Boot 2.6.4
Camunda 7.17.0
H2 DB (InMemory DB)
Lombok 1.18.24
Spring OpenAPI 1.6.4

# Exposed API's:

loan-controller : POST method : /loan/apply
RequestBody : {
  "firstName": "FirstName",
  "lastName": "LastName",
  "mobile": "999999999",
  "dob": "12-03-1998",
  "age": "27",
  "address": "Hyderabad",
  "employer": "Organization",
  "salary": "your CTC",
  "requestedAmount": "3000000"
}

Response Body :
{
  "firstName": "Ramanaiah",
  "lastName": "Pirla",
  "applicationId": "a7aaadb7-1e01-4ed3-b1a7-8fd2e075e518",
  "requestedAmount": 3000000,
  "processInstanceId": "4b775f91-47cf-11ed-b995-0a0027000004"
}



