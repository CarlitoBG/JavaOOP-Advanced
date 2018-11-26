package p02_warning_levels;

import java.util.ArrayList;
import java.util.List;

public class Logger {

    private Importance importance;
    private List<Message> messages;

    public Logger(Importance importance) {
        this.importance = importance;
        this.messages = new ArrayList<>();
    }

    public void addMessage(Message message){
        if (this.importance.compareTo(message.getImportance()) <= 0){
            this.messages.add(message);
        }
    }

    public Iterable<Message> getMessages(){
        return this.messages;
    }
}