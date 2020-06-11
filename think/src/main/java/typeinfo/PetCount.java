package typeinfo;

import java.util.HashMap;

import typeinfo.pets.Cat;
import typeinfo.pets.Dog;
import typeinfo.pets.ForNameCreator;
import typeinfo.pets.Pet;
import typeinfo.pets.PetCreator;

public class PetCount {
    static class PetCounter extends HashMap<String, Integer> {
        public void count(String type) {
            Integer quantity = get(type);
            if (quantity == null)
                put(type, 1);
            else
                put(type, quantity + 1);
        }
    }

    public static void countPets(PetCreator creator) {
        PetCounter counter = new PetCounter();
        for (Pet pet : creator.createArray(2)) {
            // List each individual pet:
            System.out.println(pet.getClass().getSimpleName() + " ");
            if (pet instanceof Cat)
                counter.count("Cat");
            if (pet instanceof Dog)
                counter.count("Dog");
        }
        // Show the counts:
        System.out.println(counter);
    }

    public static void main(String[] args) {
        countPets(new ForNameCreator());
    }
}