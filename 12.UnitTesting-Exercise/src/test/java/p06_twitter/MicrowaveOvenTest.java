package p06_twitter;

import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.util.List;

import static org.junit.Assert.*;

public class MicrowaveOvenTest {
    private final ByteArrayOutputStream OUTPUT_CONTENT = new ByteArrayOutputStream();
    private static final String MESSAGE = "Some text";

    @Test
    public void testSendTweetToServerMethodShouldWriteTweetOnTheConsoleSuccessfully() {
        System.setOut(new PrintStream(OUTPUT_CONTENT));

        ConsoleWriter consoleWriter = new ConsoleWriterImpl();
        Server server = Mockito.mock(Server.class);
        Client client = new MicrowaveOven(consoleWriter, server);
        Tweet tweet = new Message();

        tweet.retrieveMessage(MESSAGE);
        client.sendTweetToServer(tweet);

        String expectedMessage = MESSAGE + System.lineSeparator();

        assertEquals(expectedMessage, OUTPUT_CONTENT.toString());

        System.setOut(System.out);
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testSendTweetToServerMethodShouldSendTweetToServerSuccessfully() throws NoSuchFieldException, IllegalAccessException {
        ConsoleWriter consoleWriter = Mockito.mock(ConsoleWriter.class);
        Server server = new ServerImpl();
        Client client = new MicrowaveOven(consoleWriter, server);
        Tweet tweet = Mockito.mock(Tweet.class);

        tweet.retrieveMessage(MESSAGE);
        client.sendTweetToServer(tweet);

        Field serverField = server.getClass().getDeclaredField("server");
        serverField.setAccessible(true);
        List<Tweet> serverList = (List<Tweet>) serverField.get(server);

        int expectedNumberOfTweetsOnServer = 1;

        assertEquals(expectedNumberOfTweetsOnServer, serverList.size());
    }

    @Test
    public void testSendTweetToServerMethodShouldInvokeMethodOneTimeSuccessfully(){
        Tweet tweet = Mockito.mock(Tweet.class);
        Client client = Mockito.mock(Client.class);
        client.sendTweetToServer(tweet);

        Mockito.verify(client, Mockito.times(1)).sendTweetToServer(tweet);
    }
}