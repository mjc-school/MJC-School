package school.mjc.bitwise;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Flags {

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = Flags.class.getDeclaredMethod("method");

        System.out.println("Method modifiers = " + method.getModifiers());
        System.out.println("Is method static = " + Modifier.isStatic(method.getModifiers()));
    }

    private static void method() {}
}
