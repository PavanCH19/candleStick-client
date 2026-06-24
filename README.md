# Candlestick Client

A simple Java client application that fetches candlestick data from a REST API using command-line arguments.

## Features

* Accepts user input through command-line arguments
* Sends HTTP GET requests to the server
* Parses JSON responses using Jackson
* Displays candlestick data in a readable format

## Prerequisites

* Java 21 or later
* Maven (optional, if using Maven dependencies)
* Running backend API server

## Project Structure

```text
src
└── main
    └── java
        └── assignment
            ├── Main.java
            └── dto
                ├── CandleDto.java
                └── CandleResponseDto.java
```

## Command Line Arguments

The application expects four arguments:

```text
java Main <symbol> <timeFrame> <startDate> <endDate>
```

### Parameters

| Parameter | Description         | Example             |
| --------- | ------------------- | ------------------- |
| symbol    | Stock symbol        | TCS                 |
| timeFrame | Candle interval     | 5m                  |
| startDate | Start date and time | 2026-01-01T09:15:00 |
| endDate   | End date and time   | 2026-01-01T10:15:00 |

## Example

```bash
java Main TCS 5m 2026-01-01T09:15:00 2026-01-01T10:15:00
```

## Sample Output

```text
===== Candle Data =====
Symbol    : TCS
TimeFrame : 5m
Count     : 12

1. 2026-01-01T09:15:00Z | O: 3215.00 H: 3225.30 L: 3208.30 C: 3223.30 V: 156747
2. 2026-01-01T09:20:00Z | O: 3223.90 H: 3224.80 L: 3208.70 C: 3210.50 V: 30061
...
```

## API Endpoint

The client connects to:

```text
http://localhost:8080/api/v1/candles
```

Example request:

```text
http://localhost:8080/api/v1/candles?symbol=TCS&timeFrame=5m&startDate=2026-01-01T09:15:00&endDate=2026-01-01T10:15:00
```

## Technologies Used

* Java 21
* Java HttpClient
* Jackson Databind
* REST API

## Author

Pavan C H
