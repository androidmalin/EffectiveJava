package innerclasses;

// Returning a reference to an inner class.
public class Parcel2 {
    class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        Destination(String whereTo) {
            label = whereTo;
        }

        String readLabel() {
            return label;
        }
    }


    public Contents contents() {
        return new Contents();
    }

    public Destination to(String s) {
        return new Destination(s);
    }

    public void ship(String dest) {
        Contents c = contents();
        System.out.println(c.value());
        Destination d = to(dest);
        System.out.println(d.readLabel());
    }

    public static void main(String[] args) {

        Parcel2 p = new Parcel2();
        p.ship("Tasmania");
        Parcel2 q = new Parcel2();

        // Defining references to inner classes:
        Parcel2.Contents c = q.contents();
        System.out.println(c.value());
        Parcel2.Destination d = q.to("Borneo");
        System.out.println(d.readLabel());
    }
}