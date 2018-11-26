package p03_stack_iterator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Stack<Integer> stack = new Stack<>();

        while (true){
            String[] commands = reader.readLine().split("[ ,]+");
            if ("END".equals(commands[0])){
                break;
            }

            switch (commands[0]){
                case "Push":
                    List<Integer> elements = Arrays.stream(commands).skip(1).map(Integer::parseInt).collect(Collectors.toList());
                    stack.push(elements);
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
        }

        stack.forEach(System.out::println);
        stack.forEach(System.out::println);
    }
}