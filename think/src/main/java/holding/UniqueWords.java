package holding;

import net.mindview.util.TextFile;

import java.util.Set;
import java.util.TreeSet;

public class UniqueWords {
    public static void main(String[] args) {
        //\W 表示[^A-Za-z0-9_]
        //+ 表示匹配一个或多个字符（至少一个，不匹配零个字符的情况）
        Set<String> words = new TreeSet<>(new TextFile("think/src/main/java/holding/SetOperations.java", "\\W+"));
        System.out.println(words);

        //[
        // A, B, C, Collections, D, E, F, G, H,
        // HashSet, I, J, K, L, M, N, Print, Set,
        // SetOperations, String, X, Y, Z, add,
        // addAll, added, args, class, contains,
        // containsAll, from, holding, import, in,
        // java, main, mindview, net,
        // new, package, print, public, remove,
        // removeAll, removed, set1, set2,
        // split, static, to, util, void
        // ]
    }
}
