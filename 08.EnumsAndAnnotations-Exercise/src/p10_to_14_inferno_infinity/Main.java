package p10_to_14_inferno_infinity;

import p10_to_14_inferno_infinity.contracts.api.Weapon;
import p10_to_14_inferno_infinity.engine.Engine;
import p10_to_14_inferno_infinity.io.ConsoleInputReader;
import p10_to_14_inferno_infinity.io.ConsoleOutputWriter;
import p10_to_14_inferno_infinity.repositories.Repository;
import p10_to_14_inferno_infinity.repositories.WeaponRepository;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args){
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Repository<Weapon> weaponRepository = new WeaponRepository<>();
        ConsoleInputReader reader = new ConsoleInputReader(bufferedReader);
        ConsoleOutputWriter writer = new ConsoleOutputWriter();

        Runnable engine = new Engine(weaponRepository, reader, writer);

        engine.run();
    }
}