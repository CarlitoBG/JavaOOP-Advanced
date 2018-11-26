package p03_cards_with_power;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String cardRank = reader.readLine().toUpperCase();
        String cardSuit = reader.readLine().toUpperCase();

        CardDeck cardDeck = new CardDeck(RankPowers.valueOf(cardRank), SuitPowers.valueOf(cardSuit));

        System.out.println(cardDeck.toString());
    }
}