package p06_custom_enum_annotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final String ENUM_PATH_PACKAGE = "p06_custom_enum_annotations.enums.";
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String token = reader.readLine();

        Class<?> enumClass = Class.forName(ENUM_PATH_PACKAGE + token);
        CustomAnnotation customAnnotation = enumClass.getAnnotation(CustomAnnotation.class);

        System.out.println(String.format("Type = %s, Description = %s", customAnnotation.type(), customAnnotation.description()));
    }
}