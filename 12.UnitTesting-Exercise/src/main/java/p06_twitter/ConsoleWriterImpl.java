package p06_twitter;

public class ConsoleWriterImpl implements ConsoleWriter {

    @Override
    public void writeLine(Tweet tweet){
        System.out.println(tweet);
    }
}