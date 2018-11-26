package p07_deck_of_cards;

public class Main {
    public static void main(String[] args) {

        for (CardSuit cardSuit : CardSuit.values()) {
            for (CardRank cardRank : CardRank.values()) {
                System.out.println(String.format("%s of %s", cardRank.name(), cardSuit.name()));
            }
        }
    }
}