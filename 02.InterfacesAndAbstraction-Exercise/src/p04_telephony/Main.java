package p04_telephony;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<String> phoneNumbers = Arrays.asList(reader.readLine().split("\\s+"));
        List<String> websites = Arrays.asList(reader.readLine().split("\\s+"));

        Smartphone smartphone = new Smartphone(phoneNumbers, websites);

        for (String phoneNumber : smartphone.getPhoneNumbers()) {
            System.out.println(smartphone.call(phoneNumber));
        }

        for (String website : smartphone.getWebsites()) {
            System.out.println(smartphone.browse(website));
        }
    }
}