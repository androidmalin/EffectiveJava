package holding;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

// Simple demonstration of HashMap.
public class Statistics {
    public static void main(String[] args) {
        Random rand = new Random(47);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10_000; i++) {
            // Produce a number between 0 and 20:
            int r = rand.nextInt(20);
            Integer freq = map.get(r);
            map.put(r, freq == null ? 1 : freq + 1);
        }
        System.out.println(map);
    }
}
