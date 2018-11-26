package p01_harvesting_fields;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String modifier;
		while (true){
			if ("HARVEST".equals(modifier = reader.readLine())){
				break;
			}

			printFieldsByModifier(modifier);
		}
	}

	private static void printFieldsByModifier(String modifier) {
		Field[] fields = getAllFieldsByModifier(modifier);

		if (fields != null) {
			Arrays.stream(fields).forEach(f -> System.out.println(String.format("%s %s %s",
                    Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName())));
		}
	}

	private static Field[] getAllFieldsByModifier(String modifier) {
		Field[] fields = RichSoilLand.class.getDeclaredFields();

		switch (modifier){
			case "private":
				return Arrays.stream(fields).filter(f -> Modifier.isPrivate(f.getModifiers())).toArray(Field[]::new);
			case "protected":
				return Arrays.stream(fields).filter(f -> Modifier.isProtected(f.getModifiers())).toArray(Field[]::new);
			case "public":
				return Arrays.stream(fields).filter(f -> Modifier.isPublic(f.getModifiers())).toArray(Field[]::new);
			case "all":
				return fields;
		}
		return null;
	}
}