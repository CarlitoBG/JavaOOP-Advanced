package p06_twitter;

public class Message implements Tweet {

    private String message;

    @Override
    public void retrieveMessage(String message){
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}