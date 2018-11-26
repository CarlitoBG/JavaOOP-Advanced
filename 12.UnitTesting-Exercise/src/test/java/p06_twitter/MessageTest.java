package p06_twitter;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

public class MessageTest {

    private static final String MESSAGE = "Some text";

    @Test
    public void testRetrieveMessageShouldInvokeMethodOneTimeSuccessfully() throws Exception {
        Tweet tweet = Mockito.mock(Tweet.class);
        tweet.retrieveMessage(MESSAGE);

        Mockito.verify(tweet, Mockito.times(1)).retrieveMessage(MESSAGE);
    }

    @Test
    public void testRetrieveMessageWithGivenStringShouldRetrieveAndSaveParamCorrectly() throws NoSuchFieldException, IllegalAccessException {
        Class<Message> messageClass = Message.class;
        Field messageField = messageClass.getDeclaredField("message");
        messageField.setAccessible(true);

        Tweet tweet = new Message();
        tweet.retrieveMessage(MESSAGE);

        Assert.assertEquals(MESSAGE, messageField.get(tweet));
    }
}