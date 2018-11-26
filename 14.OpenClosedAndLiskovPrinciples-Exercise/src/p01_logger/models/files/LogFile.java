package p01_logger.models.files;

import p01_logger.interfaces.File;

public class LogFile implements File{

    private StringBuilder messages;

    public LogFile() {
        this.messages = new StringBuilder();
    }

    @Override
    public void write(String message){
        this.messages.append(message).append("\n");
    }

    @Override
    public int size(){
        int result = 0;

        for (int i = 0; i < this.messages.length(); i++) {
            if (Character.isAlphabetic(this.messages.charAt(i))){
                result += this.messages.charAt(i);
            }
        }

        return result;
    }
}