# Shopping Cart - Java Web Application

A small Spring Boot application for practicing Maven builds and deployment to an AWS EC2 Linux instance.

## Requirements

- Java 17
- Maven 3.6.3 or newer

## Build

```bash
mvn clean package
```

The executable JAR will be created at:

```text
target/shopping-cart.jar
```

## Run locally

```bash
java -jar target/shopping-cart.jar
```

Open:

- Web page: http://localhost:8080/
- Products API: http://localhost:8080/api/products

## Add a product

```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Monitor","price":12000.00}'
```

Then refresh `/` or request `/api/products`.

## EC2 deployment outline

1. Launch an EC2 Linux instance.
2. Allow inbound TCP port 8080 in its security group (for practice; restrict the source to your IP).
3. Install Java 17 on the instance.
4. Copy `target/shopping-cart.jar` to the instance using SCP.
5. Run `java -jar shopping-cart.jar`.
6. Browse to `http://EC2_PUBLIC_IP:8080/`.

For a production-style setup, put Nginx in front of the application, use HTTPS, run the app as a systemd service, and avoid exposing port 8080 publicly.
