package p05_card_compareTo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String firstCardRank = reader.readLine().toUpperCase();
        String firstCardSuit = reader.readLine().toUpperCase();
        String secondCardRank = reader.readLine().toUpperCase();
        String secondCardSuit = reader.readLine().toUpperCase();

        CardDeck firstCardDeck = new CardDeck(RankPowers.valueOf(firstCardRank), SuitPowers.valueOf(firstCardSuit));
        CardDeck secondCardDeck = new CardDeck(RankPowers.valueOf(secondCardRank), SuitPowers.valueOf(secondCardSuit));

        if (firstCardDeck.compareTo(secondCardDeck) < 0){
            System.out.println(secondCardDeck.toString());
        }else {
            System.out.println(firstCardDeck.toString());
        }
    }
}