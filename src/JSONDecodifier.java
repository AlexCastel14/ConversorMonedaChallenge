import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;

public class JSONDecodifier {
    double outputCurrencyAmount = 0;
    public HashMap<String, Double> decodeResponse(String response, String outputCurrency){
        try{
            Gson gson = new GsonBuilder()
                    .setPrettyPrinting()
                    .create();
            Currency currencyResponse = gson.fromJson(response,Currency.class);
            HashMap<String, Double> rates = currencyResponse.conversion_rates();
            return rates;
        } catch (Exception e){
            System.out.println("Ocurrio un error al decodificar la respuesta.");
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
