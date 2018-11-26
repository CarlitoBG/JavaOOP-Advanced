package p03_cards_with_power;

public class CardDeck {

    private RankPowers rankPowers;
    private SuitPowers suitPowers;

    CardDeck(RankPowers rankPowers, SuitPowers suitPowers) {
        this.rankPowers = rankPowers;
        this.suitPowers = suitPowers;
    }

    private int getPower(){
        return this.rankPowers.getValue() + this.suitPowers.getValue();
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rankPowers.name(), this.suitPowers.name(), this.getPower());
    }
}