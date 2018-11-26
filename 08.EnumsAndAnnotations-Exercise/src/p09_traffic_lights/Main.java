package p09_traffic_lights;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] lightSignals = reader.readLine().split("\\s+");
        int numberOfLightChange = Integer.parseInt(reader.readLine());

        TrafficLight[] trafficLights = new TrafficLight[lightSignals.length];
        for (int i = 0; i < trafficLights.length; i++) {
            trafficLights[i] = TrafficLight.valueOf(lightSignals[i]);
        }

        for (int i = 1; i <= numberOfLightChange; i++) {

            StringBuilder sb = new StringBuilder();

            for (TrafficLight trafficLight : trafficLights) {
                int index = (trafficLight.ordinal() + i) % TrafficLight.values().length;
                sb.append(TrafficLight.values()[index]).append(" ");
            }

            System.out.println(sb.toString().trim());
        }
    }
}