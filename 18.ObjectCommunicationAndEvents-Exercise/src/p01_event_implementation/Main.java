package p01_event_implementation;

import p01_event_implementation.contracts.NameChangeListener;
import p01_event_implementation.core.Dispatcher;
import p01_event_implementation.listener.Handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Dispatcher dispatcher = new Dispatcher();
        NameChangeListener nameChangeListener = new Handler();
        dispatcher.addNameChangeListener(nameChangeListener);

        String name;
        while (true){
            if ("End".equals(name = reader.readLine())){
                break;
            }

            dispatcher.fireEvent(name);
        }
    }
}