package hw3.task4;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
public class UrlController {

    @GetMapping("/uuid")
    public String uuid() {
        return UUID.randomUUID().toString();
    }

    @GetMapping("/currency")
    public Map<String, Double> currency() {
        Map<String, Double> map = new HashMap<>();
        map.put("USD", Math.random() * 100);
        map.put("EUR", Math.random() * 100);

        return map;
    }

    @GetMapping("/exchange/{currency}")
    public Map<String, Object> exchangeCurrency(@PathVariable("currency") String currency) {
        Map<String, Object> result = new HashMap<>();

        result.put("currency", currency);
        result.put("rate", Math.random() * 100);

        return result;
    }

    @GetMapping("/exchange/test")
    public int test() {
        return 200;
    }

}
