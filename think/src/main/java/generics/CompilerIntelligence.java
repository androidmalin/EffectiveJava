package generics;

import java.util.Collections;
import java.util.List;

public class CompilerIntelligence {
    public static void main(String[] args) {
        List<? extends Fruit> fList = Collections.singletonList(new Apple());
        Apple a = (Apple) fList.get(0); // No warning
        boolean contains = fList.contains(new Apple());// Argument is 'Object'
        fList.indexOf(new Apple()); // Argument is 'Object'
    }
}