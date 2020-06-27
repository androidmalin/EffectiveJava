package holding;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;


/**
 * 先进先出描述了最典型的队列规则。
 * <p>
 * 队列规则是指在给定一组队列中的元素的情况下，确定下一个弹出队列的元素的规则。
 * <p>
 * 先进先出声明的是下一个元素应该是等待时间最长的元素。
 * <p>
 * 优先级队列声明下一个弹出元素是最需要的元素（具有最高的优先级）。
 * <p>
 * 例如，在飞机场，当飞机临近起飞时，这架飞机的乘客可以在办理登机手续时排到队头。
 * <p>
 * 如果构建了一个消息系统，某些消息比其他消息更重要，
 * 因而应该更快地得到处理，那么它们何时得到处理就与它们何时到达无关。
 * <p>
 * PriorityQueue添加到JavaSE5中，是为了提供这种行为的一种自动实现。
 * <p>
 * 当你在PriorityQueue上调用offer()方法来插入一个对象时，这个对象会在队列中被排序。
 * <p>
 * 默认的排序将使用对象在队列中的自然顺序，
 * 但是你可以通过提供自己的Comparator来修改这个顺序。
 * <p>
 * PriorityQueue可以确保当你调用peek()、poll()和remove()方法时，
 * 获取的元素将是队列中优先级最高的元素。
 * <p>
 * 让PriorityQueue与Integer、String和Character这样的内置类型一起工作易如反掌。
 * <p>
 * 在下面的示例中，第一个值集与前一个示例中的随机值相同，
 * 因此你可以看到它们从PriorityQueue中弹出的顺序与前一个示例不同：
 * <p>
 * <p>
 * 你可以看到，重复是允许的，最小的值拥有最高的优先级
 * （如果是String,空格也可以算作值，并且比字母的优先级高）。
 * <p>
 * 为了展示你可以使用怎样的方法通过提供自己的Comparator对象来改变排序，
 * 第三个对PriorityQueue<Integer>的构造器调用，
 * <p>
 * 和第二个对PriorityQueue<String>的调用使用了由Collection.reverseOrder()
 * （新添加到JavaSE5中的）产生的反序的Comparator
 * <p>
 * 最后一部分添加了一个HashSet来消除重复的Character，这么做只是为了增添点乐趣。
 * <p>
 * Integer、String和Character可以与PriorityQueue—起工作，因为这些类已
 * 经内建了自然排序。
 * <p>
 * 如果你想在PriorityQueue中使用自己的类，就必须包括额外的功能以产生自然排序，
 * <p>
 * 或者必须提供自己的Comparator
 * <p>
 * 在第17章中有一个更加复杂的示例将演示这种情况。
 */
public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        //1.
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            priorityQueue.offer(rand.nextInt(i + 10));
        }
        QueueDemo.printQ(priorityQueue);

        //2.
        List<Integer> ints = Arrays.asList(25, 22, 20, 18, 14, 9, 3, 1, 1, 2, 3, 9, 14, 18, 21, 23, 25);
        priorityQueue = new PriorityQueue<>(ints);
        QueueDemo.printQ(priorityQueue);


        //3.
        priorityQueue = new PriorityQueue<>(ints.size(), Collections.reverseOrder());
        priorityQueue.addAll(ints);
        QueueDemo.printQ(priorityQueue);


        //4.
        String fact = "EDUCATION SHOULD ESCHEW OBFUSCATION";
        List<String> strings = Arrays.asList(fact.split(""));
        PriorityQueue<String> stringPQ = new PriorityQueue<>(strings);
        QueueDemo.printQ(stringPQ);


        //5.
        stringPQ = new PriorityQueue<>(strings.size(), Collections.reverseOrder());
        stringPQ.addAll(strings);
        QueueDemo.printQ(stringPQ);


        //6.
        Set<Character> charSet = new HashSet<>();
        for (char c : fact.toCharArray()) {
            charSet.add(c); // Autoboxing
        }
        PriorityQueue<Character> characterPQ = new PriorityQueue<>(charSet);
        QueueDemo.printQ(characterPQ);
    }
}