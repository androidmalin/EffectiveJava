package generics.test;

//ma lin
//5.
class Animal<T> {
    T t;
    public <F extends FactoryIII<T>> Animal(F factory) {
        t = factory.create();
    }
}

class Dog {

}

class Cat {

}

//1.factory Interface
interface FactoryIII<T> {
    T create();
}


class AnimalFactory {

    //2.instance of factory
    static class Factory<T> implements FactoryIII<T> {
        private T t;

        //4.
        public Factory(T t) {
            this.t = t;
        }

        //3.
        @Override
        public T create() {
            return t;
        }
    }

    public static void main(String[] args) {
        Animal<Dog> dogAnimal = new Animal<>(new Factory<>(new Dog()));
        Dog t = dogAnimal.t;

        Animal<Cat> catAnimal = new Animal<>(new Factory<>(new Cat()));
        Cat t1 = catAnimal.t;
    }
}