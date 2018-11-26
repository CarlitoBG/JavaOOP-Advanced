package p08_card_game;

public class Card implements Comparable<Card> {

    private CardRank cardRank;
    private CardSuit cardSuit;

    Card(CardRank cardRank, CardSuit cardSuit) {
        this.cardRank = cardRank;
        this.cardSuit = cardSuit;
    }

    private String getCardRank() {
        return this.cardRank.name();
    }

    private String getCardSuit() {
        return this.cardSuit.name();
    }

    Integer getPower(){
        return this.cardRank.getValue() + this.cardSuit.getValue();
    }

    @Override
    public int compareTo(Card card) {
        return this.getPower().compareTo(card.getPower());
    }

    @Override
    public String toString() {
        return String.format("%s of %s", this.getCardRank(), this.getCardSuit());
    }
}