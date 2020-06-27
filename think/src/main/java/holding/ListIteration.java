package holding;

import java.util.List;
import java.util.ListIterator;

import typeinfo.pets.Pet;
import typeinfo.pets.Pets;

public class ListIteration {

    /**
     * ListIterator是一个更加强大的Iterator的子类型，它只能用于各种List类的访问。
     * <p>
     * 尽管Iterator只能向前移动，但是ListIterator可以双向移动。
     * <p>
     * 它还可以产生相对于迭代器在列表中指向的当前位置的前一个和后一个元素的索引，
     * <p>
     * 并且可以使用set()方法替换它访问过的最后一个元素。
     * <p>
     * 你可以通过调用listIterator()方法产生一个指向List开始处的ListIterator,
     * <p>
     * 并且还可以通过调用listIterator(n)方法创建一个一开始就指向列表索引为n的元素处的ListIterator。
     * <p>
     * 下面的示例演示了所有这些能力
     */
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(8);

        ListIterator<Pet> it = pets.listIterator();
        while (it.hasNext()) {
            System.out.print(it.next() + ", " + it.nextIndex() + ", " + it.previousIndex() + "; ");
        }

        System.out.println();

        // Backwards:
        while (it.hasPrevious()) {
            System.out.print(it.previous().id() + " ");
        }

        System.out.println();
        System.out.println(pets);


        it = pets.listIterator(3);
        while (it.hasNext()) {
            it.next();
            it.set(Pets.randomPet());
        }

        System.out.println(pets);
    }
}
