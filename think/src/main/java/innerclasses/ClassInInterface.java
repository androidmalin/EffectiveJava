package innerclasses;
// {main: ClassInInterface$Test}

/**
 * 不能运行.
 * 在jdk1.5也是.书上错了
 */
public interface ClassInInterface {
    void howdy();


    class Test implements ClassInInterface {
        public void howdy() {
            System.out.println("Howdy!");
        }

        public static void main(String[] args) {
            new Test().howdy();
        }
    }
}
