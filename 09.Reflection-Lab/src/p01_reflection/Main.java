package p01_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, NoSuchMethodException,
            InvocationTargetException {

        Class aClass = Reflection.class;
        System.out.println("class " + aClass.getSimpleName());
        System.out.println(aClass.getSuperclass());
        Class[] interfaces = aClass.getInterfaces();
        for (Class anInterface : interfaces) {
            System.out.println(anInterface);
        }
        Constructor constructor = Reflection.class.getConstructor();
        Reflection reflection = (Reflection) constructor.newInstance();
        System.out.println(reflection);
    }
}