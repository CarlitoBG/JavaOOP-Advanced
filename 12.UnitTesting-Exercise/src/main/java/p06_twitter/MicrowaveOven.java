package p06_twitter;

public class MicrowaveOven implements Client {

    private ConsoleWriter writer;
    private Server server;

    MicrowaveOven(ConsoleWriter writer, Server server) {
        this.writer = writer;
        this.server = server;
    }

    @Override
    public void sendTweetToServer(Tweet tweet){
        this.writer.writeLine(tweet);
        this.server.saveTweet(tweet);
    }
}