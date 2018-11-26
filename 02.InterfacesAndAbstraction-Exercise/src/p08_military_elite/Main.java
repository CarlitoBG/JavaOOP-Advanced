package p08_military_elite;

import p08_military_elite.implementations.*;
import p08_military_elite.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<Integer, Soldier> army = new LinkedHashMap<>();

        String line;
        while (true){
            if ("End".equals(line = reader.readLine())){
                break;
            }

            String[] tokens = line.split("\\s+");

            String type = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (type){
                case "Private":
                    army.putIfAbsent(id, new PrivateImpl(id, firstName, lastName, Double.parseDouble(tokens[4])));
                    break;
                case "LeutenantGeneral":
                    Collection<Private> somePrivates = new ArrayList<>();
                    Stream.of(tokens).skip(5).map(Integer::parseInt)
                            .collect(Collectors.toList()).forEach(e -> somePrivates.add((Private) army.get(e)));

                    army.putIfAbsent(id, new LeutenantGeneralImpl(id, firstName, lastName, Double.parseDouble(tokens[4]), somePrivates));
                    break;
                case "Engineer":
                    SpecialisedSoldier engineer = new EngineerImpl(id, firstName, lastName, Double.valueOf(tokens[4]), tokens[5], parseRepairs(tokens));
                    if (engineer.getCorps() != null){
                        army.putIfAbsent(id, engineer);
                    }
                    break;
                case "Commando":
                    SpecialisedSoldier soldier = new CommandoImpl(id, firstName, lastName, Double.valueOf(tokens[4]), tokens[5], parseMissions(tokens));
                    if (soldier.getCorps() != null){
                        army.putIfAbsent(id, soldier);
                    }
                    break;
                case "Spy":
                    army.putIfAbsent(id, new SpyImpl(id, firstName, lastName, Integer.valueOf(tokens[4])));
                    break;
            }
        }

        for (Soldier soldier : army.values()) {
            System.out.println(soldier.toString().trim());
        }
    }

    private static Collection<Repair> parseRepairs(String[] args) {
        Collection<Repair> repairs = new ArrayList<>();
        for (int i = 6; i < args.length; i+=2) {
            repairs.add(new RepairImpl(args[i], Integer.valueOf(args[i + 1])));
        }
        return repairs;
    }

    private static Collection<Mission> parseMissions(String[] tokens) {
        Collection<Mission> repairs = new ArrayList<>();
        for (int i = 6; i < tokens.length; i += 2) {
            Mission mission = new MissionImpl(tokens[i], tokens[i + 1]);
            if (mission.getState() != null){
                repairs.add(mission);
            }
        }
        return repairs;
    }
}