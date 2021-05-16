# API Gateway

This is a sample project to implement API gateway for microservice architecture. Built using *Spring Cloud Gateway*.

- **Author** *[Dinesh Rajasekar](https://www.linkedin.com/in/dineshbabu-rajasekar)*
- **Last Updated** *2021-05-16*
 
## Properties

Routes and request matching predicates have been configured in *application.yml* file and are being injected to the spring container much similar to other several other application properties.

## Configurations
#### 1. Global CORS
A spring bean has been initialized and configured for Cross-origin-resource-sharing. Only clients (could be either web application or mobile apps) from the particular origins are allowed to access the allowed methods.
