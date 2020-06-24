package polymorphism.shape;

import static net.mindview.util.Print.print;

public class Square extends Shape {

    @Override
    public void draw() {
        print("Square.draw()");
    }

    @Override
    public void erase() {
        print("Square.erase()");
    }
}
