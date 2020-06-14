package generics;

public class CaptureConversion {

    static <T> void f1(Holder<T> holder) {
        T t = holder.get();
        System.out.println(t.getClass().getSimpleName());
    }

    static void f2(Holder<?> holder) {
        f1(holder); // Call with captured type
    }

    /**
     * 捕获转换
     */
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        Holder raw = new Holder<>(1);
        // f1(raw); // Produces warnings
        f2(raw); // No warnings

        Holder rawBasic = new Holder();
        rawBasic.set(new Object()); // Warning
        f2(rawBasic); // No warnings

        // UpCast to Holder<?>, still figures it out:
        Holder<?> wildCarded = new Holder<>(1.0);
        f2(wildCarded);
    }
}