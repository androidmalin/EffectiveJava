package generics.test;

public class Tuple2 {

    public static <K, V> Tuple<K, V> getTuple(K k, V v) {
        return new Tuple<K, V>(k, v);
    }


    public static void main(String[] args) {
        Tuple<String, String> tuple = Tuple2.getTuple("hello", "world");
        String k = tuple.k;
        String v = tuple.v;
        System.out.println(k + v);

    }
}
