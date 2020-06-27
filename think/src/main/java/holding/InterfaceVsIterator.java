package holding;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

/**
 * Collection是描述所有序列容器的共性的根接囗，它可能会被认为是一个
 * "附属接囗"，即因为要表示其他若干个接囗的共性而出现的接囗。
 * <p>
 * 另外，
 * java.util.AbstractCollection类提供了Collection的默认实现，使得你可以创建
 * AbstractCollection的子类型，而其中没有不必要的代码重复。
 * <p>
 * <p>
 * 使用接囗描述的一个理由是它可以使我们能够创建更通用的代码。
 * 通过针对接囗而非具体实现来编写代码，我们的代码可以应用于更多的对象类型。
 *
 * <p>
 * 因此，如果我编写的方法将接受一个Collection，那么该方法就可以应用于任何实现
 * 了Collection的类, 这也就使得一个新类可以选择去实现Collection接囗，以便
 * 我的方法可以使用它。
 * <p>
 * 但是，有一点很有趣，就是我们注意到标准C++类库中并
 * 没有其容器的任何公共基类一容器之间的所有共性都是通过迭代器达成的。
 * <p>
 * 在Java中，遵循C++的方式看起来似乎很明智，即用迭代器而不是Collection来表示
 * 容器之间的共性。
 * <p>
 * 但是，这两种方法绑定到了一起，因为实现Collection就意味着
 * 需要提供iterator()方法：
 */
public class InterfaceVsIterator {
    public static void display(Iterator<Pet> it) {
        while (it.hasNext()) {
            Pet p = it.next();
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void display(Collection<Pet> pets) {
        for (Pet p : pets) {
            System.out.print(p.id() + ":" + p + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        List<Pet> petList = Pets.arrayList(8);
        Set<Pet> petSet = new HashSet<>(petList);
        Map<String, Pet> petMap = new LinkedHashMap<>();
        String[] names = ("Ralph, Eric, Robin, Lacey, Britney, Sam, Spot, Fluffy").split(", ");
        for (int i = 0; i < names.length; i++) {
            petMap.put(names[i], petList.get(i));
        }
        display(petList);
        display(petSet);
        display(petList.iterator());
        display(petSet.iterator());
        System.out.println(petMap);
        System.out.println(petMap.keySet());
        display(petMap.values());
        display(petMap.values().iterator());
    }
}