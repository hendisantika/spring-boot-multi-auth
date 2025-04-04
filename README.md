# Multi-Factor Authentication for Spring Boot

This repository contains a sample Spring Boot application that demonstrates multi-factor authentication techniques for
securing API endpoints. The project showcases the use of two authentication methods:

- **API Key Authentication:** Validates the identity of servers interacting with the API using custom filters and
  authentication mechanisms.
- **Basic Authentication with Centralized Identity Management:** This is the traditional username and password
  authentication for users, handled through a centralized identity provider.

### Things to do list:

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-multi-auth.git`
2. Navigate to the folder: `cd spring-boot-multi-auth`
3. Run the application: `mvn clean spring-boot:run`
4. Open Postman Collection file then try it

### Reference

For a detailed explanation of the implementation and concepts, refer
to [this article](https://medium.com/@LynneMunini/securing-your-spring-boot-3-app-multi-factor-authentication-with-api-key-and-basic-auth-e6835a3687d1).
