import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_KEY = "a528d113c6380ec8ba7367e6";
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese la moneda de origen (por ejemplo, USD): ");
        String fromCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la moneda de destino (por ejemplo, EUR): ");
        String toCurrency = scanner.nextLine().toUpperCase();

        System.out.print("Ingrese la cantidad: ");
        double amount = scanner.nextDouble();

        try {
            double rate = getExchangeRate(fromCurrency, toCurrency);
            double convertedAmount = amount * rate;
            System.out.printf("%.2f %s es igual a %.2f %s%n", amount, fromCurrency, convertedAmount, toCurrency);
        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrió un error al obtener las tasas de cambio.");
            e.printStackTrace();
        }
    }

    private static double getExchangeRate(String fromCurrency, String toCurrency) throws IOException, InterruptedException {
        String url = BASE_URL + "/latest/" + fromCurrency;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        JsonObject jsonResponse = JsonParser.parseString(response.body()).getAsJsonObject();

        if (jsonResponse.get("result").getAsString().equals("success")) {
            JsonObject conversionRates = jsonResponse.getAsJsonObject("conversion_rates");
            return conversionRates.get(toCurrency).getAsDouble();
        } else {
            throw new IOException("No se pudo obtener la tasa de cambio.");
        }
    }
}
