package holding;
// Containers print themselves automatically.

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import static net.mindview.util.Print.print;

public class PrintingContainers {
    static Collection<String> fill(Collection<String> collection) {
        collection.add("rat");
        collection.add("cat");
        collection.add("dog");
        collection.add("dog");
        return collection;
    }

    static Map<String, String> fill(Map<String, String> map) {
        map.put("rat", "Fuzzy");
        map.put("cat", "Rags");
        map.put("dog", "Bosco");
        map.put("dog", "Spot");
        return map;
    }


    /**
     * 本例使用了三种基本风格的Map：HashMap、TreeMap和
     * LinkedHashMap与HashSet—样,
     * <p>
     * HashMap也提供了最快的查找技术，也没有按照任何明显的顺序来保存其元素。
     * TreeMap按照比较结果的升序保存键，
     * LinkedHashMap则按照插入顺序保存键，同时还保留了HashMap的查询速度。
     */
    public static void main(String[] args) {
        print(fill(new ArrayList<String>()));
        print(fill(new LinkedList<String>()));
        print(fill(new HashSet<String>()));
        print(fill(new TreeSet<String>()));
        print(fill(new LinkedHashSet<String>()));
        print(fill(new HashMap<String, String>()));
        print(fill(new TreeMap<String, String>()));
        print(fill(new LinkedHashMap<String, String>()));
    }
}