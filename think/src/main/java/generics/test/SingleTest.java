package generics.test;


class Book {

}

public class SingleTest {

    private static final Singleton<Book> YY_SINGLETON = new Singleton<Book>() {
        @Override
        protected Book create() {
            return new Book();
        }
    };

    public static void main(String[] args) {
        Book book = YY_SINGLETON.getInstance();
        System.out.println(book);
    }
}
