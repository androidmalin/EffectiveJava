package generics;

import java.util.ArrayList;
import java.util.List;

public class SuperTypeWildcards {
    public static void writeTo(List<? super Apple> apples) {
        apples.add(new Apple());
        apples.add(new Jonathan());
        //apples.add(new Fruit()); // Error
    }


    public static void main(String[] args) {

        List<Fruit> fruitList = new ArrayList<>();
        SuperTypeWildcards.writeTo(fruitList);

        List<Apple> appleList = new ArrayList<>();
        SuperTypeWildcards.writeTo(appleList);

    }
}
