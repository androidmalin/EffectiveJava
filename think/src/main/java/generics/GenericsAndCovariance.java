package generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsAndCovariance {

    /**
     * 重点关注
     * 你想在两个类型之间建立某种类型的向上转型的关系, 这是通配符所允许的
     */
    public static void main(String[] args) {
        // Wildcards allow covariance:
        List<? extends Fruit> flist = new ArrayList<Apple>();
        // Compile Error: can't add any type of object:
        // flist.add(new Apple());
        // flist.add(new Fruit());
        // flist.add(new Object());
        flist.add(null); // Legal but uninteresting
        // We know that it returns at least Fruit:
        Fruit f = flist.get(0);
        System.out.println(f);
    }
}
