package generics.test;

public class ThreeTuple<K, V, U> extends Tuple<K, V> {

    private final U u;

    public ThreeTuple(K k, V v, U u) {
        super(k, v);
        this.u = u;
    }

    public static void main(String[] args) {
        ThreeTuple<String, Integer, Double> threeTuple = new ThreeTuple<>("hello", 1, 1.0d);
        System.out.println("k:" + threeTuple.k);
        System.out.println("v:" + threeTuple.v);
        System.out.println("u:" + threeTuple.u);
    }
}
