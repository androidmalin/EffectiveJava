package holding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import typeinfo.pets.Cymric;
import typeinfo.pets.Hamster;
import typeinfo.pets.Mouse;
import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

import static net.mindview.util.Print.print;


/**
 * List承诺可以将元素维护在特定的序列中。
 * <p>
 * List接囗在Collection的基础上添
 * 加了大量的方法，使得可以在List的中间插入和移除元素。
 * <p>
 * 有两种类型的List：
 * 基本的ArrayList,它长于随机访问元素，但是在List的中间插入和移除元素
 * 时较慢。
 * <p>
 * LinkedList，它通过代价较低的在List中间进行的插入和删除操作，提供了
 * 优化的顺序访问。
 * <p>
 * LinkedList在随机访问方面相对比较慢，但是它的特性集较ArrayList更大。
 */
public class ListFeatures {
    public static void main(String[] args) {
        Random rand = new Random(47);
        List<Pet> pets = Pets.arrayList(7);
        print("1: " + pets);

        Hamster h = new Hamster();
        pets.add(h); // Automatically ReSizes
        print("2: " + pets);
        print("3: " + pets.contains(h));

        pets.remove(h); // Remove by object
        Pet p = pets.get(2);
        print("4: " + p + " " + pets.indexOf(p));

        Pet cymric = new Cymric();
        print("5: " + pets.indexOf(cymric));
        print("6: " + pets.remove(cymric));

        // Must be the exact object:
        print("7: " + pets.remove(p));
        print("8: " + pets);

        pets.add(3, new Mouse()); // Insert at an index
        print("9: " + pets);

        List<Pet> sub = pets.subList(1, 4);
        print("subList: " + sub);
        print("10: " + pets.containsAll(sub));

        Collections.sort(sub); // In-place sort
        print("sorted subList: " + sub);


        // Order is not important in containsAll():
        print("11: " + pets.containsAll(sub));

        Collections.shuffle(sub, rand); // Mix it up
        print("shuffled subList: " + sub);
        print("12: " + pets.containsAll(sub));

        List<Pet> copy = new ArrayList<Pet>(pets);
        sub = Arrays.asList(pets.get(1), pets.get(4));
        print("sub: " + sub);

        copy.retainAll(sub);
        print("13: " + copy);

        copy = new ArrayList<Pet>(pets); // Get a fresh copy
        copy.remove(2); // Remove by index
        print("14: " + copy);

        copy.removeAll(sub); // Only removes exact objects
        print("15: " + copy);

        copy.set(1, new Mouse()); // Replace an element
        print("16: " + copy);

        copy.addAll(2, sub); // Insert a list in the middle
        print("17: " + copy);
        print("18: " + pets.isEmpty());

        pets.clear(); // Remove all elements
        print("19: " + pets);
        print("20: " + pets.isEmpty());

        pets.addAll(Pets.arrayList(4));
        print("21: " + pets);

        Object[] o = pets.toArray();
        print("22: " + o[3]);

        Pet[] pa = pets.toArray(new Pet[0]);
        print("23: " + pa[3].id());
    }
}
