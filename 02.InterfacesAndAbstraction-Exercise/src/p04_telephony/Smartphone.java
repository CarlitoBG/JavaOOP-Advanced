package p04_telephony;

import java.util.Collections;
import java.util.List;

public class Smartphone implements Calling, Browsing{

    private List<String> phoneNumbers;
    private List<String> websites;

    Smartphone(List<String> phoneNumbers, List<String> websites) {
        this.phoneNumbers = phoneNumbers;
        this.websites = websites;
    }

    public List<String> getPhoneNumbers() {
        return Collections.unmodifiableList(this.phoneNumbers);
    }

    public List<String> getWebsites() {
        return Collections.unmodifiableList(this.websites);
    }

    @Override
    public String browse(String website) {
        if (website.matches("^[^\\d]+$")){
            return String.format("Browsing: %s!", website);
        }
        return "Invalid URl!";
    }

    @Override
    public String call(String phoneNumber) {
        if (phoneNumber.matches("^\\d+$")){
            return String.format("Calling... %s!", phoneNumber);
        }
        return "Invalid number!";
    }
}