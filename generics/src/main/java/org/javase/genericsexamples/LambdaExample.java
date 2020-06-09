package org.javase.genericsexamples;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * 在 Java SE 8 构造中使用泛型
 * <p>
 * 我们已经看到了泛型的用法和重要性。
 * 现在，我们来看看泛型在 Java SE 8 中的新构造 lambda 表达式的用例。
 * Lambda 表达式表示一个匿名函数，它实现函数接口的单一抽象方法。
 * 有许多函数接口可供使用，其中许多利用了泛型。
 * 我们来看一个示例。
 * <p>
 * 假设我们要遍历书名 (String) 列表，比较书名，这样我们可以返回包含指定搜索词的所有书名。
 * 为此，我们可以开发一个方法，它有两个参数：书名列表和用于执行比较的谓词。
 * Predicate 函数接口可用于比较，返回一个 boolean，指示给定对象是否满足测试要求。
 * Predicate 接口可用于所有类型的对象，因为它有以下泛型签名：
 *
 * @FunctionalInterface public interface Predicate<T>{
 * ...
 * }
 */
public class LambdaExample {

    public static void main(String[] args) {
        List<String> bookList = new ArrayList<>();
        bookList.add("Java 8 Recipes");
        bookList.add("Java EE 7 Recipes");
        bookList.add("Introducing Java EE 7");
        bookList.add("JavaFX 8:  Introduction By Example");
        compareStrings(bookList, (n) -> n.contains("Java EE"));
    }

    /**
     * 如果我们要遍历每个书名，查找包含文本“Java EE”的书名，可以传递 contains("Java EE") 作为谓词参数。
     * 以下所示方法可用于遍历给定的书名列表，并应用这样的谓词打印那些匹配的书名。
     * 在这种情况下，接受的参数使用泛型指示 String 的 List，并使用一个谓词测试每个 String。
     */
    public static void compareStrings(List<String> list, Predicate<String> predicate) {
        list.stream().filter((n) -> (predicate.test(n))).forEach((n) -> {
            System.out.println(n + " ");
        });
    }

}
