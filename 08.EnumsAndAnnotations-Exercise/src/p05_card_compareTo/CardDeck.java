package p05_card_compareTo;

public class CardDeck implements Comparable<CardDeck>{

    private RankPowers rankPowers;
    private SuitPowers suitPowers;

    CardDeck(RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
    }

    private Integer getPower(){
        return this.rankPowers.getValue() + this.suitPowers.getValue();
    }

    @Override
    public int compareTo(CardDeck card) {
        return this.getPower().compareTo(card.getPower());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rankPowers.name(), this.suitPowers.name(), this.getPower());
    }
}