package holding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

// UpCasting to a Queue from a LinkedList.
public class QueueDemo {


    /**
     * 队列是一个典型的先进先出(FIFO)的容器。
     * <p>
     * 即从容器的一端放入事物，从另一端取出，并且事物放入容器的顺序与取出的顺序是相同的。
     * <p>
     * 队列常被当作一种可靠的将对象从程序的某个区域传输到另一个区域的途径。
     * <p>
     * 队列在并发编程中特别重要，就像你将在第21章中所看到的，
     * 因为它们可以安全地将对象从一个任务传输给另一个任务。
     * <p>
     * LinkedList提供了方法以支持队列的行为，并且它实现了Queue接囗，
     * <p>
     * 因此LinkedList可以用作Queue的一种实现。
     * <p>
     * 通过将LinkedList向上转型为Queue,下面的示例使用了在Queue接囗中与Queue相关的方法：
     * <p>
     * <p>
     * <p>
     * offer()方法是与Queue相关的方法之一，它在允许的情况下，
     * 将一个元素插入到队尾，或者返回false。
     * <p>
     * peek()和element()都将在不移除的情况下返回队头，
     * <p>
     * 但是peek()方法在队列为空时返回null
     * 而element()会抛出NoSuchElementException异常。
     * <p>
     * poll()和remove()方法将移除并返回队头，
     * 但是poll()在队列为空时返回null
     * 而remove()会抛出NOSuchElementException异常。
     * <p>
     * 自动包装机制会自动地将nextInt()方法的int结果转换为queue所需的
     * Integer对象，将char转换为qc所需的Character对象。
     * <p>
     * Queue接囗窄化了对LinkedList的方法的访问权限，以使得只有恰当的方法才可以使用，
     * 因此，你能够访问的LinkedList的方法会变少
     * （这里你实际上可以将queue转型回LinkedList,但是至少我们不鼓励这么做）。
     * <p>
     * 注意，与Queue相关的方法提供了完整而独立的功能。
     * <p>
     * 即，对于Queue所继承的Collection，在不需要使用它的任何方法的情况下，
     * 就可以拥有一个可用的Queue
     */
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Random rand = new Random(47);
        for (int i = 0; i < 10; i++) {
            queue.offer(rand.nextInt(i + 10));
        }
        printQ(queue);

        Queue<Character> qc = new LinkedList<>();
        for (char c : "Brontosaurus".toCharArray()) {
            qc.offer(c);
        }
        printQ(qc);
    }

    public static void printQ(Queue<?> queue) {
        while (queue.peek() != null) {
            System.out.print(queue.remove() + " ");
        }
        System.out.println();
    }
}
