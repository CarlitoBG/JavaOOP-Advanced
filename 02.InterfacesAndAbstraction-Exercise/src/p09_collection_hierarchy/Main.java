package p09_collection_hierarchy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        AddCollection<String> addCollection = new AddCollectionImpl<>();
        AddRemoveCollection<String> addRemoveCollection = new AddRemoveCollectionImpl<>();
        MyList<String> myList = new MyListImpl<>();

        String[] tokens = reader.readLine().split("\\s+");
        int countOfRemovedElements = Integer.parseInt(reader.readLine());

        List<String> firstCollection = new ArrayList<>();
        List<String> secondCollection = new ArrayList<>();
        List<String> thirdCollection = new ArrayList<>();

        for (String token : tokens) {
            firstCollection.add(String.valueOf(addCollection.add(token)));
            secondCollection.add(String.valueOf(addRemoveCollection.add(token)));
            thirdCollection.add(String.valueOf(myList.add(token)));
        }

        System.out.println(String.join(" ", firstCollection));
        System.out.println(String.join(" ", secondCollection));
        System.out.println(String.join(" ", thirdCollection));

        secondCollection.clear();
        thirdCollection.clear();

        for (int i = 0; i < countOfRemovedElements; i++) {
           secondCollection.add(addRemoveCollection.remove());
           thirdCollection.add(myList.remove());
        }

        System.out.println(String.join(" ", secondCollection));
        System.out.println(String.join(" ", thirdCollection));
    }
}