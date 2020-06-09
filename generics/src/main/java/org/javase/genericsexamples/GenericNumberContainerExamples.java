package org.javase.genericsexamples;

/**
 * 该类可以很好地将其字段类型限制为 Number，但如果您尝试指定一个不在边界内的类型，将引发编译器错误。
 *
 * @author Juneau
 */
public class GenericNumberContainerExamples {

    @SuppressWarnings({"rawtypes", "unchecked"})
    public static void main(String[] args) {

        //right
        GenericNumberContainer<Integer> gn = new GenericNumberContainer<>();
        gn.setObj(3);
        int num = gn.getObj();
        System.out.println("GenericNumberContainer num:" + num);

        GenericNumberContainer gn1 = new GenericNumberContainer(10);
        System.out.println("gn1:" + gn1.getObj());

        // Type argument String is not within the upper bounds of type-variable T
        // GenericNumberContainer<String> gn2 = new GenericNumberContainer<String>();

    }

}
