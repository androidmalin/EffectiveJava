package org.javase.genericsexamples;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juneau
 */
public class ObjectExample {
    public static void main(String[] args) {
        testObject();
        testGenerics();
        collectionsTests();
    }

    @SuppressWarnings({"rawtypes", "unchecked", "MismatchedQueryAndUpdateOfCollection"})
    public static void testObject() {
        ObjectContainer myObj = new ObjectContainer();

        // store a string
        myObj.setObj("Test");
        System.out.println("Value of myObj:" + myObj.getObj());

        // store an int
        myObj.setObj(3);
        System.out.println("Value of myObj:" + myObj.getObj());

        List objectList = new ArrayList();
        objectList.add(myObj);
        // We have to cast...and we must be sure to cast the correct type!
        //String myStr = (String) ((ObjectContainer)objectList.get(0)).getObj(); // ClassCastException

    }

    /**
     * Utilizing a container that uses generics allows us to store any type
     * of data within the object in a type-safe manner
     */
    public static void testGenerics() {
        GenericContainer<String> stringContainer = new GenericContainer<>();
        stringContainer.setObj("Test");
        //stringContainer.setObj(3); // will not compile...type error
        System.out.println("Value of stringContainer :" + stringContainer.getObj());
        GenericContainer<Integer> intContainer = new GenericContainer<>();
        intContainer.setObj(3);
        intContainer.setObj(5);
        //intContainer.setObj("Int");  // will not compile
        System.out.println("Value of intContainer: " + intContainer.getObj());
    }


    /**
     * 将 Object 容器实例存储到集合中与存储 GenericContainer 实例之间的差异。
     */
    @SuppressWarnings({"rawtypes", "unchecked", "MismatchedQueryAndUpdateOfCollection"})
    public static void collectionsTests() {

        //1.
        List myObjList = new ArrayList();
        for (int x = 0; x <= 10; x++) {
            ObjectContainer myObj = new ObjectContainer();
            myObj.setObj("Test" + x);
            myObjList.add(myObj);
        }
        // Get the objects, we need to cast
        for (int x = 0; x <= myObjList.size() - 1; x++) {
            ObjectContainer obj = (ObjectContainer) myObjList.get(x);
            System.out.println("Object Value: " + obj.getObj());
        }

        //2.
        List<GenericContainer<String>> genericList = new ArrayList<>();
        for (int x = 0; x <= 10; x++) {
            GenericContainer<String> myGeneric = new GenericContainer<>();
            myGeneric.setObj(" Generic Test" + x);
            genericList.add(myGeneric);
        }
        // Get the objects, no need to cast
        for (int x = 0; x <= myObjList.size() - 1; x++) {
            GenericContainer<String> obj = genericList.get(x);
            String objectString = obj.getObj();
            // Do something with the string...here we will print it
            System.out.println(objectString);
        }

        //注意，未分配类型的泛型称为原始类型。例如，要创建原始类型的 GenericContainer，可以使用以下代码：
        //GenericContainer rawContainer = new GenericContainer();
        //原始类型有时对于实现向后兼容很有用，但并不适用于日常代码。原始类型在编译时无需执行类型检查，导致代码在运行时易于出错。
        GenericContainer genericContainer = new GenericContainer();
    }
}
