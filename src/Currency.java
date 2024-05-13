import java.util.HashMap;

public record Currency(String result, String base_code, HashMap<String, Double> conversion_rates) {
}
