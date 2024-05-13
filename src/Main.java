import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String inputCurrency = "";
        String outputCurrency = "";
        Scanner keyboardInput = new Scanner(System.in);

        int input = 0;
        while(input != 7){
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
            input = keyboardInput.nextInt();
            switch (input){
                case 1:
                    inputCurrency = "USD";
                    outputCurrency = "ARS";
                    break;
                case 2:
                    inputCurrency = "ARS";
                    outputCurrency = "USD";
                    break;
                case 3:
                    inputCurrency = "USD";
                    outputCurrency = "BRL";
                    break;
                case 4:
                    inputCurrency = "BRL";
                    outputCurrency = "USD";
                    break;
                case 5:
                    inputCurrency = "USD";
                    outputCurrency = "COP";
                    break;
                case 6:
                    inputCurrency = "COP";
                    outputCurrency = "USD";
                    break;
                case 7:
                    break;
                default:
                    System.out.println("Por favor ingresa una opcion valida...");
            }
            if (input != 7){
                String uri = "https://v6.exchangerate-api.com/v6/f04ed2bdbe90d161d1eed9b2/latest/" + inputCurrency;
                APIConnection apiConnection = new APIConnection();
                System.out.println(apiConnection.connect(uri));
            }
        }
    }
}