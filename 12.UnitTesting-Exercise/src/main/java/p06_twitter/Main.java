package p06_twitter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ConsoleWriter writer = new ConsoleWriterImpl();
        Server server = new ServerImpl();
        Tweet tweet = new Message();
        Client client = new MicrowaveOven(writer, server);

        String message;
        while (true){
            if ("END".equals(message = reader.readLine())){
                break;
            }

            tweet.retrieveMessage(message);
            client.sendTweetToServer(tweet);
        }
    }
}