package org.javase.genericsexamples.test;

public class GenericMethods {

    public static void main(String[] args) {
        Util.Pair<Integer, String> p1 = new Util.Pair<>(1, "apple");
        Util.Pair<Integer, String> p2 = new Util.Pair<>(2, "pear");
        //Util.<Integer, String>,类型已被明确提供。一般来说，<Integer, String>这个可以不写，编译器会推断出需要的类型。
        //这个特性被称为类型推理，它允许你像普通方法一样调用一个通用方法，而不需要在角括号之间指定类型。
        boolean same = Util.compare(p1, p2);
        System.out.println(same);
    }

    /**
     * 一个泛型方法的语法包括一个类型参数列表，放在角括号内，它出现在方法的返回类型之前。
     * 对于静态泛型方法，类型参数部分必须出现在方法的返回类型之前。
     */
    public static class Util {
        public static <K, V> boolean compare(Pair<K, V> p1, Pair<K, V> p2) {
            return p1.getKey().equals(p2.getKey()) && p1.getValue().equals(p2.getValue());
        }

        public static class Pair<K, V> {
            private K key;
            private V value;

            public Pair(K key, V value) {
                this.key = key;
                this.value = value;
            }

            public void setKey(K key) {
                this.key = key;
            }

            public void setValue(V value) {
                this.value = value;
            }

            public K getKey() {
                return key;
            }

            public V getValue() {
                return value;
            }
        }
    }
}
