package holding;

import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetOfInteger {
    public static void main(String[] args) {
        Random rand = new Random(47);
        SortedSet<Integer> intSortedSet = new TreeSet<>();
        for (int i = 0; i < 10_000; i++) {
            intSortedSet.add(rand.nextInt(30));
        }
        System.out.println(intSortedSet);
    }
}
