package generics;

import net.mindview.util.New;

import java.util.List;
import java.util.Map;

import typeinfo.pets.Person;
import typeinfo.pets.Pet;

public class LimitsOfInference {

    //在
    private static void f(Map<Person, List<? extends Pet>> petPeople) {
        System.out.println(petPeople);
    }

    public static void main(String[] args) {
        f(New.map()); // Does not compile
    }
}
