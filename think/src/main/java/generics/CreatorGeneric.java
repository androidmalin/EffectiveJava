package generics;

abstract class GenericWithCreate<T> {
    final T element;

    GenericWithCreate() {
        element = create();
    }

    abstract T create();
}

class Person {
}

class Creator extends GenericWithCreate<Person> {

    @Override
    Person create() {
        return new Person();
    }

    void f() {
        System.out.println(element.getClass().getSimpleName());
    }
}

/**
 * 重点关注
 * https://cread.jd.com/read/startRead.action?bookId=30534990&readType=3
 */
public class CreatorGeneric {
    public static void main(String[] args) {
        Creator c = new Creator();
        c.f();
    }
}
