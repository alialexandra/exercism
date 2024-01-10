package strings;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RaindropConverter {

    private final static Map<Integer, String> dropDict =
            Map.of(3, "Pling", 5, "Plang", 7, "Plong");

    String convert(int number) {
        String raindrops = "";
        StringBuilder sb = new StringBuilder(raindrops);

        dropDict.forEach((k, v) ->{ if(number % k == 0) {
            sb.append(v);
        }

        });

        if (sb.toString().equals("")) return String.valueOf(number);

        return sb.toString();
    }

}