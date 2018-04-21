# Payment Service

## Pre-requisites
* Java >=1.8

## Endpoints

Health check <br/> `GET /health`

To make a payment for an order given its orderId, use <br/> `GET /payments/orders/{orderId}`

## Build

To build the application, run `./gradlew build`

## Test

To run tests, run `./gradlew test`

## Run

Required evironment variables:

SERVER_PORT - port the appliation will run on

ORDER_SERVICE_HOST - host running OrderService

ORDER_SERVICE_PORT - port running OrderService

Run the app using `./gradlew bootRun`

Verify the app is running using `curl -i localhost:<SERVER_PORT>/health` from a terminal (replace <SERVER_PORT> with the port
the app is running on)
or
navigating to `localhost:<SERVER_PORT>/health` from a web browser.

If the response is "OK", the app is succesfully running.

## Tasks

To see list of available tasks, run `./gradlew tasks`
