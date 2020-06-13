//: generics/InstantiateGenericType.java
package generics;

import static net.mindview.util.Print.print;

class ClassAsFactory<T> {
    T x;

    public ClassAsFactory(Class<T> kind) {
        try {
            //类型标签
            x = kind.newInstance();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

class Employee {
}

public class InstantiateGenericType {
    public static void main(String[] args) {
        ClassAsFactory<Employee> fe = new ClassAsFactory<>(Employee.class);
        print("ClassAsFactory<Employee> succeeded");
        try {
            ClassAsFactory<Integer> fi = new ClassAsFactory<>(Integer.class);
        } catch (Exception e) {
            print("ClassAsFactory<Integer> failed");
        }
    }
}
