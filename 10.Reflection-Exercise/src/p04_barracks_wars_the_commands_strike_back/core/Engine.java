package p04_barracks_wars_the_commands_strike_back.core;

import p04_barracks_wars_the_commands_strike_back.contracts.Repository;
import p04_barracks_wars_the_commands_strike_back.contracts.Runnable;
import p04_barracks_wars_the_commands_strike_back.contracts.UnitFactory;
import p04_barracks_wars_the_commands_strike_back.contracts.CommandInterpreter;
import p04_barracks_wars_the_commands_strike_back.contracts.Executable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;
	private CommandInterpreter interpreter;

	public Engine(Repository repository, UnitFactory unitFactory, CommandInterpreter interpreter) {
		this.repository = repository;
		this.unitFactory = unitFactory;
		this.interpreter = interpreter;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		while (true) {
			try {
				String input = reader.readLine();
				if ("fight".equals(input)) {
					break;
				}

				String[] data = input.split("\\s+");
				String commandName = data[0];

				Executable command = this.interpreter.interpretCommand(data, commandName);
				String result = command.execute();
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | InstantiationException | InvocationTargetException | NoSuchMethodException |
					IllegalAccessException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
}