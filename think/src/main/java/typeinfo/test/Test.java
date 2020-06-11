package typeinfo.test;

public class Test {
    public static void main(String[] args) {

        Cat cat = new Cat();
        CatGenerator<Cat> catCatGenerator = new CatGenerator<>(cat);
        Cat cat2 = catCatGenerator.next();
        if (cat == cat2) {
            System.out.println("==");
        } else {
            System.out.println("!=");
        }
    }
}
