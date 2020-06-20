package interfaces;

import java.nio.CharBuffer;
import java.util.Scanner;


/**
 * 我们再次使用了适配器模式，但是在本例中，被适配的类可以通过继承和实
 * 现Readable接囗来创建。
 * <p>
 * 因此，通过使用implements关键字提供的伪多重继承机制，
 * 我们可以生成既是Random-Doubles又是Readable的新类
 * <p>
 * 因为在这种方式中，我们可以在任何现有类之上添加新的接囗，所以这意味着
 * 让方法接受接囗类型，是一种让任何类都可以对该方法进行适配的方式。
 * <p>
 * 这就是使用接囗而不是类的强大之处。
 */
public class AdaptedRandomDoubles extends RandomDoubles implements Readable {
    private int count;

    public AdaptedRandomDoubles(int count) {
        this.count = count;
    }

    @Override
    public int read(CharBuffer cb) {
        if (count-- == 0) {
            return -1;
        }
        String result = next() + " ";
        cb.append(result);
        return result.length();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptedRandomDoubles(7));
        while (s.hasNextDouble()) {
            System.out.print(s.nextDouble() + " ");
        }
    }
}