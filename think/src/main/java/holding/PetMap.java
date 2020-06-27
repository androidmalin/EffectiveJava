package holding;

import java.util.HashMap;
import java.util.Map;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.Pet;

import static net.mindview.util.Print.print;

public class PetMap {
    public static void main(String[] args) {
        Map<String, Pet> petMap = new HashMap<>();
        petMap.put("My Cat", new Cat("Molly"));
        petMap.put("My Dog", new Dog("Ginger"));
        print(petMap);

        Pet dog = petMap.get("My Dog");
        print(dog);
        print(petMap.containsKey("My Dog"));
        print(petMap.containsValue(dog));
    }
}
