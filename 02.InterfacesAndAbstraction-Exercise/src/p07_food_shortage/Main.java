package p07_food_shortage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Buyer> buyers = new HashMap<>();

        int numberOfPeople = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfPeople; i++) {
            String[] tokens = reader.readLine().split("\\s+");

            Buyer buyer;
            if (tokens.length == 4){
                buyer = new Citizen(tokens[0], Integer.parseInt(tokens[1]), tokens[2], tokens[3]);
            }else {
                buyer = new Rebel(tokens[0], Integer.parseInt(tokens[1]), tokens[2]);
            }

            buyers.putIfAbsent(tokens[0], buyer);
        }

        while (true){
            String name;
            if ("End".equals(name = reader.readLine())){
                break;
            }

            if (buyers.containsKey(name)){
                buyers.get(name).buyFood();
            }
        }

        System.out.println(buyers.values().stream().mapToInt(Buyer::getFood).sum());
    }
}