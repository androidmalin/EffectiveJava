package interfaces;


import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;


/**
 * 适配接囗
 * 接囗最吸引人的原因之一就是允许同一个接囗具有多个不同的具体实现。
 * <p>
 * 在简单的情况中，它的体现形式通常是一个接受接囗类型的方法，而该接囗的实现
 * 和向该方法传递的对象则取决于方法的使用者。
 * <p>
 * 因此，接囗的一种常见用法就是前面提到的策略设计模式，此时你编写一个
 * 执行某些操作的方法，而该方法将接受一个同样是你指定的接囗。
 * <p>
 * 你主要就是要声明："你可以用任何你想要的对象来调用我的方法，只要你的对象遵循我的接囗。"
 * <p>
 * 这使得你的方法更加灵活、通用，并更具可复用性。
 * <p>
 * 例如，JavaSE5的Scanner类（在第13章中就更多地了解它）的构造器接受
 * 的就是一个Readable接囗。
 * <p>
 * 你会发现Readable没有用作Java标准类库中其他任何方法的参数，
 * 它是单独为Scanner创建的，以使得Scanner不必将其参数限制为某个特定类。
 * <p>
 * 通过这种方式，Scanner可以作用于更多的类型。
 * 如果你创建了一个新的类，并且想让Scanner可以作用于它，那么你就应该让它成为Readable，
 * 就像下面这样：
 */
public class RandomWords implements Readable {
    private static Random rand = new Random(47);
    private static final char[] capitals = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] lowers = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] vowels = "aeiou".toCharArray();
    private int count;

    public RandomWords(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1; // Indicates end of input
        }
        cb.append(capitals[rand.nextInt(capitals.length)]);
        for (int i = 0; i < 4; i++) {
            cb.append(vowels[rand.nextInt(vowels.length)]);
            cb.append(lowers[rand.nextInt(lowers.length)]);
        }
        cb.append(" ");
        return 10; // Number of characters appended
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(new RandomWords(10));
        while (s.hasNext()) {
            System.out.println(s.next());
        }
    }

}