package p07_custom_list;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        CustomList<String> customList = new CustomList<>();

        while (true){
            String[] line = reader.readLine().split("\\s+");
            if ("END".equals(line[0])){
                break;
            }

            switch (line[0]){
                case "Add":
                    customList.add(line[1]);
                    break;
                case "Remove":
                    customList.remove(Integer.parseInt(line[1]));
                    break;
                case "Contains":
                    System.out.println(customList.contains(line[1]));
                    break;
                case "Swap":
                    customList.swap(Integer.parseInt(line[1]), Integer.parseInt(line[2]));
                    break;
                case "Greater":
                    System.out.println(customList.countGreaterThan(line[1]));
                    break;
                case "Max":
                    System.out.println(customList.getMax());
                    break;
                case "Min":
                    System.out.println(customList.getMin());
                    break;
                case "Print":
                    for (String element : customList.getCustomList()) {
                        System.out.println(element);
                    }
                    break;
            }
        }
    }
}