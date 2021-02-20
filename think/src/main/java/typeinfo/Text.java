package typeinfo;

public class Text {

    public static void main(String[] args) {
        double f = 1.23;
        double f1 = 1;
        double f2 = 1.0;
        double f3 = 1.1;
        double f4 = 0;
        double f5 = 0.0;
        double f6 = 0.00;
        System.out.println(String.format("%.2f", f));
        System.out.println(String.format("%.2f", f1));
        System.out.println(String.format("%.2f", f2));
        System.out.println(String.format("%.2f", f3));
        System.out.println(String.format("%.2f", f4));
        System.out.println(String.format("%.2f", f5));
        System.out.println(String.format("%.2f", f6));
    }
}
