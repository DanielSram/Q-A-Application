### Q&A Application

#### Local Development

##### Accesing in memory database

- Start the application
- Visit [H2 Console](http://localhost:8080/h2-console)
- Make sure `jdbc:h2:mem:testdb` is set as JDBC URL
- Login (no password is required)

##### Enabling Lombok support

This application uses project Lombok for boiler-plate code generation. In order to Lombok annotations work properly, enabling annotation processing is required.

#### Build

`mvn clean install`