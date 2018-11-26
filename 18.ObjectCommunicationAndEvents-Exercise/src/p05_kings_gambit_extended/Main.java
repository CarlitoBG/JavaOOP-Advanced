package p05_kings_gambit_extended;

import p05_kings_gambit_extended.contracts.Lord;
import p05_kings_gambit_extended.contracts.Observer;
import p05_kings_gambit_extended.models.Footman;
import p05_kings_gambit_extended.models.King;
import p05_kings_gambit_extended.models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Lord king = new King(reader.readLine());
        king.attachObserver(king);

        String[] royalGuardsNames = reader.readLine().split("\\s+");
        for (String royalGuardsName : royalGuardsNames) {
            Observer guard = new RoyalGuard(royalGuardsName);
            king.attachObserver(guard);
        }

        String[] footmanNames = reader.readLine().split("\\s+");
        for (String footmanName : footmanNames) {
            Observer footman = new Footman(footmanName);
            king.attachObserver(footman);
        }

        String line;
        while (true){
            if ("End".equalsIgnoreCase(line = reader.readLine())){
                break;
            }

            String[] commandTokens = line.split("\\s+");
            String command = commandTokens[0];
            String servantName = commandTokens[1];

            switch (command){
                case "Attack":
                    king.attack();
                    break;
                case "Kill":
                    king.kill(servantName);
                    break;
            }
        }
    }
}