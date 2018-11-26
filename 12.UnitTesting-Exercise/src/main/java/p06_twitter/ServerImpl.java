package p06_twitter;

import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements Server {

    private List<Tweet> server;

    ServerImpl() {
        this.server = new ArrayList<>();
    }

    @Override
    public void saveTweet(Tweet tweet){
        this.server.add(tweet);
    }
}