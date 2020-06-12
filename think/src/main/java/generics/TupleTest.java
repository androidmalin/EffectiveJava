package generics;

import net.mindview.util.FiveTuple;
import net.mindview.util.FourTuple;
import net.mindview.util.ThreeTuple;
import net.mindview.util.TwoTuple;

class Amphibian {
}

class Vehicle {
}

public class TupleTest {

    static TwoTuple<String, Integer> f() {
        // Autoboxing converts the int to Integer:
        return new TwoTuple<>("hi", 47);
    }

    static ThreeTuple<Amphibian, String, Integer> g() {
        return new ThreeTuple<>(new Amphibian(), "hi", 47);
    }

    static FourTuple<Vehicle, Amphibian, String, Integer> h() {
        return new FourTuple<>(
                new Vehicle(),
                new Amphibian(),
                "hi",
                47
        );
    }

    static FiveTuple<Vehicle, Amphibian, String, Integer, Double> k() {
        return new FiveTuple<>(
                new Vehicle(),
                new Amphibian(),
                "hi"
                , 47,
                11.1
        );
    }

    public static void main(String[] args) {
        TwoTuple<String, Integer> twoTuple = f();
        System.out.println(twoTuple);
        System.out.println(g());
        System.out.println(h());
        System.out.println(k());
    }
}
