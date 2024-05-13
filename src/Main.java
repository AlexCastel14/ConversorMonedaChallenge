import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputCurrency = "";
        String outputCurrency = "";
        double outputCurrencyAmount = 0;
        double inputCurrencyAmount = 0;
        double conversionRate = 0;
        int inputInt = 0;
        Scanner keyboardInput = new Scanner(System.in);

        String input = "";
        while(input != "7"){
            System.out.println("""
            ***************************************************************
            Sea bienvenid/a al conversor de moneda :]
            
            1) Dolar ==> Peso argentino
            2) Peso argentino ==> Dolar
            3) Dolar ==> Real brasileño
            4) Real brasileño ==> Dolar
            5) Dolar ==> Peso colombiano
            6) Peso colombiano ==> Dolar
            7) Salir
            Elija una opcion valida:
            ***************************************************************
            """);
            input = keyboardInput.nextLine();
            switch (input){
                case "1":
                    inputCurrency = "USD";
                    outputCurrency = "ARS";
                    break;
                case "2":
                    inputCurrency = "ARS";
                    outputCurrency = "USD";
                    break;
                case "3":
                    inputCurrency = "USD";
                    outputCurrency = "BRL";
                    break;
                case "4":
                    inputCurrency = "BRL";
                    outputCurrency = "USD";
                    break;
                case "5":
                    inputCurrency = "USD";
                    outputCurrency = "COP";
                    break;
                case "6":
                    inputCurrency = "COP";
                    outputCurrency = "USD";
                    break;
                case "7":
                    break;
                default:
                    System.out.println("Por favor ingresa una opcion valida...\n\n");
                    continue;
            }

            inputInt = Integer.valueOf(input);
            if (inputInt != 7){
                try{
                    System.out.println("Por favor ingresa el monto a convertir:");
                    String amountInput = keyboardInput.nextLine();
                    inputCurrencyAmount = Double.valueOf(amountInput);
                    String uri = "https://v6.exchangerate-api.com/v6/f04ed2bdbe90d161d1eed9b2/latest/" + inputCurrency;
                    APIConnection apiConnection = new APIConnection();
                    String apiResponse = apiConnection.connect(uri);
                    JSONDecodifier decoder = new JSONDecodifier();
                    HashMap<String, Double> rates = decoder.decodeResponse(apiResponse,outputCurrency);
                    conversionRate = rates.get(outputCurrency);
                    outputCurrencyAmount = inputCurrencyAmount * conversionRate;
                    System.out.println("\n\n\n" + inputCurrencyAmount + " " + inputCurrency + " equivale a " + outputCurrencyAmount +
                                        " " + outputCurrency + "\n\n");
                } catch (NumberFormatException e){
                    System.out.println("Por favor ingresa un monto adecuado...\nEl programa se reiniciara.");
                    continue;
                } catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}