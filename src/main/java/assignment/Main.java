package assignment;

import assignment.dto.CandleDto;
import assignment.dto.CandleResponseDto;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {

    public static void main(String[] args) throws Exception {

        if (args.length != 4) {
            System.out.println("Usage: java Main <symbol> <timeFrame> <startDate> <endDate>");
            return;
        }

        String symbol = args[0];
        String timeFrame = args[1];
        String startDate = args[2];
        String endDate = args[3];

        String url = "http://localhost:8080/api/v1/candles" +
                "?symbol=" + symbol +
                "&timeFrame=" + timeFrame +
                "&startDate=" + startDate +
                "&endDate=" + endDate;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI(url))
                .GET()
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        ObjectMapper objectMapper = new ObjectMapper();

        CandleResponseDto candleResponse =
                objectMapper.readValue(response.body(), CandleResponseDto.class);

        System.out.println("\n===== Candle Data =====");
        System.out.println("Symbol    : " + candleResponse.getSymbol());
        System.out.println("TimeFrame : " + candleResponse.getTimeframe());
        System.out.println("Count     : " + candleResponse.getCount());
        System.out.println();

        int i = 1;
        for (CandleDto candle : candleResponse.getCandles()) {
            System.out.printf(
                    "%2d. %s | O: %.2f H: %.2f L: %.2f C: %.2f V: %d%n",
                    i++,
                    candle.getDatetime(),
                    candle.getOpen(),
                    candle.getHigh(),
                    candle.getLow(),
                    candle.getClose(),
                    candle.getVolume()
            );
        }
    }
}
