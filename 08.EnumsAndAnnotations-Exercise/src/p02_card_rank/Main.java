package p02_card_rank;

public class Main {
    public static void main(String[] args) {

        System.out.println("Card Ranks:");
        for (CardRanks cardRanks : CardRanks.values()) {
            System.out.println(cardRanks.toString());
        }
    }
}