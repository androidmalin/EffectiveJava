package generics.test;

public class Tuple<K, V> {

    public final K k;
    public final V v;

    public Tuple(K k, V v) {
        this.k = k;
        this.v = v;
    }


    public static void main(String[] args) {
        Tuple<String, String> tuple = new Tuple<>("hello", "world");
        String k = tuple.k;
        String v = tuple.v;
        System.out.println("k:" + k);
        System.out.println("v:" + v);
    }
}
