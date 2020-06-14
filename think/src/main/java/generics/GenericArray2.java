package generics;

public class GenericArray2<T> {

    /**
     * 在内部将array当做Object[]的优势是:
     * 我们不太可能忘记这个数组的运行时类型,从而意外地陷入缺陷
     */
    private Object[] array;

    public GenericArray2(int sz) {
        array = new Object[sz];
    }

    public void put(int index, T item) {
        array[index] = item;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        return (T) array[index];
    }

    @SuppressWarnings("unchecked")
    public T[] rep() {
        return (T[]) array; // Warning: unchecked cast
    }

    public static void main(String[] args) {
        GenericArray2<Integer> gai = new GenericArray2<>(10);
        for (int i = 0; i < 10; i++) {
            gai.put(i, i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.print(gai.get(i) + " ");
        }

        try {
            Integer[] ia = gai.rep();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}