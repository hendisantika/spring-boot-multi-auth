# Multi-Factor Authentication for Spring Boot

[![Java CI with Maven](https://github.com/hendisantika/spring-boot-multi-auth/actions/workflows/maven.yml/badge.svg)](https://github.com/hendisantika/spring-boot-multi-auth/actions/workflows/maven.yml)
![Java](https://img.shields.io/badge/Java-25-orange?logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot)
![Dependabot](https://img.shields.io/badge/Dependabot-enabled-025E8C?logo=dependabot)

This repository contains a sample Spring Boot application that demonstrates multi-factor authentication techniques for
securing API endpoints. The project showcases the use of two authentication methods:

- **API Key Authentication:** Validates the identity of servers interacting with the API using custom filters and
  authentication mechanisms.
- **Basic Authentication with Centralized Identity Management:** This is the traditional username and password
  authentication for users, handled through a centralized identity provider.

### Tech Stack

- Java 25 (Temurin)
- Spring Boot 4.1.1 (Spring Security, Spring Web)
- Retrofit 3 + Jackson converter (calls to the identity provider)
- Lombok
- Maven (via the bundled Maven Wrapper)

### Requirements

- JDK 25
- No local Maven install needed, use `./mvnw`

### Things to do list:

1. Clone this repository: `git clone https://github.com/hendisantika/spring-boot-multi-auth.git`
2. Navigate to the folder: `cd spring-boot-multi-auth`
3. Build and run the tests: `./mvnw clean package`
4. Run the application: `./mvnw spring-boot:run`
5. Open the Postman Collection file (`Spring Boot Multi Authentication.postman_collection.json`) and try it

### Endpoints

| Endpoint                           | Security filter chain | Authentication                                             |
|------------------------------------|-----------------------|------------------------------------------------------------|
| `GET /api/multi-auth/server/test`  | `@Order(1)`           | `API-KEY` request header (sample key: `12345abc`)          |
| `GET /api/multi-auth/client/test`  | `@Order(2)`           | HTTP Basic, validated against the identity provider (Retrofit) |

Example requests:

```shell
# Server-to-server call using an API key
curl -H "API-KEY: 12345abc" http://localhost:8080/api/multi-auth/server/test

# Client call using HTTP Basic credentials
curl -u user@example.com:password http://localhost:8080/api/multi-auth/client/test
```

> The identity provider base URL is configured in `AuthenticationService` (`http://localhost:8080` by default).
> Point it to your own authentication server for the Basic Auth flow to succeed.

### Continuous Integration

GitHub Actions ([`maven.yml`](.github/workflows/maven.yml)) builds and tests the project on JDK 25 for every push and
pull request to `main`. You can also start it manually (`workflow_dispatch`). On pushes to `main` it also submits the
Maven dependency graph to improve Dependabot alerts.

### Dependency Updates

[Dependabot](.github/dependabot.yml) checks Maven dependencies and GitHub Actions daily at 05:00 (Asia/Jakarta):

- Related updates are grouped into one PR each (Spring, Retrofit, Maven plugins, other minor/patch updates, and
  GitHub Actions)
- PRs are labeled `dependencies` plus `java` or `github_actions`
- Commit messages follow Conventional Commits (`build(deps): ...`, `ci(deps): ...`)
- Major upgrades of the Spring Boot parent are ignored because they need manual migration

### Reference

For a detailed explanation of the implementation and concepts, refer
to [this article](https://medium.com/@LynneMunini/securing-your-spring-boot-3-app-multi-factor-authentication-with-api-key-and-basic-auth-e6835a3687d1).
