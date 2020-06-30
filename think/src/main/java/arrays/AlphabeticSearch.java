package arrays;

import net.mindview.util.Generated;
import net.mindview.util.RandomGenerator;

import java.util.Arrays;

// Searching with a Comparator.
public class AlphabeticSearch {

    /**
     * 在本章中，你看到了Java对尺寸固定的低级数组提供了适度的支持。
     * 这种数组强调的是性能而不是灵活性，并且与C和C++的数组模型类似。
     * <p>
     * 在Java的初始版本中，尺寸固定的低级数组绝对是必需的，不仅是因为Java的设计者选择在Java
     * 中要包含基本类型（也是出于性能方面的考虑），而且还因为那个版本中对容器的支持非常少。
     * <p>
     * 因此，在Java的早期版本中，选择包含数组总是合理的。
     * <p>
     * 其后的Java版本对容器的支持得到了明显的改进，并且现在的容器在除了性
     * 能之外的各个方面都使得数组相形见绌。
     * <p>
     * 就像在本书其他多处地方所叙述的那样，对你来说，性能出问题的地方通常是无论如何你都无法想象得到的。
     * <p>
     * 有了额外的自动包装机制和泛型，在容器中持有基本类型就变得易如反掌了，而这也进一步促使你用容器来替换数组。
     * <p>
     * 因为泛型可以产生类型安全的容器，因此数组面对这一变化，已经变得毫无优势了。
     * <p>
     * 就像在本章中描述的，而且当你尝试着使用它们时也会看到，泛型对数组是极大的威胁。
     * <p>
     * 通常，即使当你可以让泛型与数组以某种方式一起工作时
     * （在下一章你将会看到），在编译期你最终也会得到"不受检查"的警告信息。
     * <p>
     * 曾经在多个场合，当我和Java语言的设计者们讨论某些特定的示例时，我直
     * 接告诉他们：我应该使用容器而不是数组
     * （在这些示例中，我使用数组是为了演示某些具体的技术，因此我没有选择的余地）。
     * <p>
     * 所有这些话题都表示,当你使用最近的Java版本编程时，应该"优选容器而不是数组"。
     * <p>
     * 只有在已证明性能成为问题（并且切换到数组对性能提高有所帮助）时，你才应该将程序重构为使用数组。
     * <p>
     * 这是一个相当清晰的陈述，但是有些语言根本就没有尺寸固定的低级数组，
     * 它们只有尺寸可调的容器，这些容器与C/C++/Java风格的数组相比，明显具有更多的功能.
     */
    public static void main(String[] args) {
        String[] sa = Generated.array(new String[30], new RandomGenerator.String(5));

        Arrays.sort(sa, String.CASE_INSENSITIVE_ORDER);
        System.out.println(Arrays.toString(sa));

        int index = Arrays.binarySearch(sa, sa[10], String.CASE_INSENSITIVE_ORDER);
        System.out.println("Index: " + index + "\n" + sa[index]);
    }
}