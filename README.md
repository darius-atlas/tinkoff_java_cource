## Structure
PostgreSQL <----->  Scrapper <br>
Scrapper   <--HTTP--> Bot <br>
Scrapper   <-----> RabbitMQ <br>
Bot        <-----> RabbitMQ <br>

## Usage
Swagger UI is available at http://localhost:8080/swagger-ui

## Docker Compose desc

This Docker Compose file consists of the following services:


bot: This service is built using the bot/ directory and depends on rabbitmq. It uses the environment variable SPRING_RABBITMQ_HOST to connect to the RabbitMQ server.

link-parser: This service is built using the link-parser/ directory and depends on rabbitmq.

scrapper: This service is built using the scrapper/ directory and depends on both rabbitmq and postgres. It uses the environment variables SPRING_DATASOURCE_URL, SPRING_DATASOURCE_USERNAME, and SPRING_DATASOURCE_PASSWORD to connect to the PostgreSQL database.

rabbitmq: This service uses the official RabbitMQ image and is accessible on ports 15672 and 5672. The management plugin is also enabled, allowing you to access the RabbitMQ management console at http://localhost:15672 after starting the containers.

postgres: This service uses the latest version of the PostgreSQL image and creates a database named "scrapper" with a user named "postgres" and password "postgres". The data directory for the PostgreSQL container is mounted to a Docker volume named postgres-data.