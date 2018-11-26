package p10_mood_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] tokens = reader.readLine().split(" \\| ");
        String userName = tokens[0];
        String characterType = tokens[1];
        int level = Integer.parseInt(tokens[3]);

        GameObject gameObject = null;
        switch (characterType){
            case "Demon":
                gameObject = new Demon(userName, level, Double.parseDouble(tokens[2]));
                break;
            case "Archangel":
                gameObject = new Archangel(userName, level, Integer.parseInt(tokens[2]));
                break;
        }

        System.out.println(gameObject);
    }
}