package p08_card_game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, List<Card>> playerHand = new HashMap<>();
        List<String> drawnCards = new ArrayList<>();

        String firstPlayerName = reader.readLine();
        String secondPlayerName = reader.readLine();

        playerHand.put(firstPlayerName, new ArrayList<>());
        playerHand.put(secondPlayerName, new ArrayList<>());

        getCardHand(reader, playerHand, drawnCards, firstPlayerName);
        getCardHand(reader, playerHand, drawnCards, secondPlayerName);

        playerHand.get(firstPlayerName).sort(Comparator.reverseOrder());
        playerHand.get(secondPlayerName).sort(Comparator.reverseOrder());
        int firstPlayerHighestHand = playerHand.get(firstPlayerName).get(0).getPower();
        int secondPlayerHighestHand = playerHand.get(secondPlayerName).get(0).getPower();

        String winner = firstPlayerHighestHand > secondPlayerHighestHand ? firstPlayerName : secondPlayerName;
        Card winingCard = playerHand.get(winner).get(0);

        System.out.printf("%s wins with %s.", winner, winingCard.toString());
    }

    private static void getCardHand(BufferedReader reader, Map<String, List<Card>> playerHand, List<String> drawnCards,
                                    String player) throws IOException {
        while (true){
            if (playerHand.get(player).size() == 5){
                break;
            }

            try {
                String[] card = reader.readLine().split(" of ");

                CardRank cardRank = CardRank.valueOf(card[0]);
                CardSuit cardSuit = CardSuit.valueOf(card[1]);

                Card currentCard = new Card(cardRank, cardSuit);

                if (drawnCards.contains(currentCard.toString())){
                    System.out.println("Card is not in the deck.");
                }else {
                    playerHand.get(player).add(currentCard);
                    drawnCards.add(currentCard.toString());
                }
            }catch (IllegalArgumentException iae){
                System.out.println("No such card exists.");
            }
        }
    }
}