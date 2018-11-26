package p07_1984.factories;

import p07_1984.contracts.Subject;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class SubjectFactory {

    private static final String MODELS_PATH = "p07_1984.models.";

    public SubjectFactory() { }

    public static Subject createSubject(String... tokens){
        Subject subject = null;
        try {
            Class<?> className = Class.forName(MODELS_PATH + tokens[0]);
            Constructor constructor = className.getDeclaredConstructor();
            subject = (Subject) constructor.newInstance();

            Field[] fields = subject.getClass().getDeclaredFields();
            int counter = 0;
            for (int i = 1; i < tokens.length ; i++) {
                Field field = fields[counter++];
                field.setAccessible(true);
                Class type = field.getType();
                Object value = tokens[i];

                if (type.getSimpleName().equals("int")){
                    value = Integer.parseInt(tokens[i]);
                }
                field.set(subject, value);
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException |
                InvocationTargetException e) {
            e.printStackTrace();
        }

        return subject;
    }
}