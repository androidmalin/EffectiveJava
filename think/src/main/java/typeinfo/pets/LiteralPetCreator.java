package typeinfo.pets;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LiteralPetCreator extends PetCreator {
    // No try block needed.
    public static final List<Class<? extends Pet>> allTypes =
            Collections.unmodifiableList(
                    Arrays.asList(Pet.class, Dog.class, Cat.class)
            );
    // Types for random creation:
    private static final List<Class<? extends Pet>> types =
            allTypes.subList(allTypes.indexOf(Cat.class), allTypes.size());

    public List<Class<? extends Pet>> types() {
        return types;
    }

    public static void main(String[] args) {
        System.out.println(allTypes);
    }
}
