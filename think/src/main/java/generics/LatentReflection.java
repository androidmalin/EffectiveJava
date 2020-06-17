package generics;


import java.lang.reflect.Method;

import static net.mindview.util.Print.print;

// Does not implement Performs:
class Mime {

    @SuppressWarnings("unused")
    public void walkAgainstTheWind() {
    }

    @SuppressWarnings("unused")
    public void sit() {
        print("Pretending to sit");
    }

    @SuppressWarnings("unused")
    public void pushInvisibleWalls() {
    }

    @Override
    public String toString() {
        return "Mime";
    }
}

// Does not implement Performs:
class SmartDog {

    @SuppressWarnings("unused")
    public void speak() {
        print("Woof!");
    }

    @SuppressWarnings("unused")
    public void sit() {
        print("Sitting");
    }

    @SuppressWarnings("unused")
    public void reproduce() {
    }
}

class CommunicateReflectively {
    public static void perform(Object speaker) {
        Class<?> speakerClazz = speaker.getClass();
        try {
            try {
                Method speak = speakerClazz.getMethod("speak");
                speak.invoke(speaker);
            } catch (NoSuchMethodException e) {
                print(speaker + " cannot speak");
            }
            try {
                Method sit = speakerClazz.getMethod("sit");
                sit.invoke(speaker);
            } catch (NoSuchMethodException e) {
                print(speaker + " cannot sit");
            }
        } catch (Exception e) {
            throw new RuntimeException(speaker.toString(), e);
        }
    }
}

// Using Reflection to produce latent typing.
public class LatentReflection {
    public static void main(String[] args) {
        CommunicateReflectively.perform(new SmartDog());
        CommunicateReflectively.perform(new Robot());
        CommunicateReflectively.perform(new Mime());
    }
}