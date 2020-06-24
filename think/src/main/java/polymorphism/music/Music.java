package polymorphism.music;

public class Music {

    /**
     * Music.tune()方法接受一个Instrument引用，
     * 同时也接受任何导出自Instrument的类。
     * <p>
     * 在main()方法中，当一个Wind引用传递到tune()方法时，
     * 就会出现这种情况，而不需要任何类型转换。
     * <p>
     * 这样做是允许的,因为Wind从Instrument继承而来，
     * 所以Instrument的接囗必定存在于Wind中。
     * <p>
     * 从Wind向上转型到Instrument可能会“缩小"接囗，
     * 但不会比Instrument的全部接囗更窄。
     */
    public static void tune(Instrument i) {
        i.play(Note.MIDDLE_C);
    }

    /**
     * 重点关注
     */
    public static void main(String[] args) {
        Wind flute = new Wind();
        tune(flute); // UpCasting
    }
}