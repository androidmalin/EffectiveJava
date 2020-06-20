package interfaces.classprocessor;

import java.util.Arrays;

import static net.mindview.util.Print.print;

class Processor {
    public String name() {
        return getClass().getSimpleName();
    }

    Object process(Object input) {
        return input;
    }
}

class UpCase extends Processor {

    @Override
    String process(Object input) { // Covariant return
        return ((String) input).toUpperCase();
    }
}

class DownCase extends Processor {

    @Override
    String process(Object input) {
        return ((String) input).toLowerCase();
    }
}

class Splitter extends Processor {

    @Override
    String process(Object input) {
        // The split() argument divides a String into pieces:
        return Arrays.toString(((String) input).split(" "));
    }
}

public class Apply {
    public static void process(Processor p, Object s) {
        print("Using Processor " + p.name());
        print(p.process(s));
    }

    public static final String s = "Disagreement with beliefs is by definition incorrect";

    public static void main(String[] args) {
        process(new UpCase(), s);
        process(new DownCase(), s);
        process(new Splitter(), s);
    }
}
