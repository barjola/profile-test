# 1 - Profile Technical Test

This repository contains code for solving the technical test for Profile Technical Test.
Please check out [this document](TestJava2023.txt) for more info.

# 2 - Run instructions

> For running this application we use Gradle in version `8.5` and its wrapper (Java 17 its needed).

1. We can easily run the application on port `8080` (if needed to change the port it can be
   done [here](src/main/resources/application.yml)) with the following command:
    ```
    ./gradlew clean bootRun
    ```

2. To stop the application you can use this command (or simply close the cmd):
    ```
    ./gradlew -stop
    ```

# 3 - Test execution

The tests can be executed using the following command:

   ```
   ./gradlew clean test
   ```

The tests are executed in the GitHub pipelines as well:

[GitHub Actions](https://github.com/barjola/profile-test/actions)

# 4 - Endpoints

On the top of the application I put [Springdoc Open API UI](https://github.com/springdoc/springdoc-openapi) to provide
a user-friendly UI for testing our endpoints.

Once the application is up and running, we can access the Open API
UI [here](http://localhost:8080/swagger-ui/index.html)
and test our endpoints in a super easy way

# 5 - Contact

- [Email - Daniel Barjola](mailto:danibarjola@gmail.com)
- [LinkedIn](https://www.linkedin.com/in/daniel-barjola/)
