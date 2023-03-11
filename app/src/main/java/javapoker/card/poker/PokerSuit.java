package javapoker.card.poker;

public enum PokerSuit {
    HEARTS, SPADES, CLUBS, DIAMONDS;

    public String toString() {
        return this.name().substring(0, 1) + this.name().substring(1).toLowerCase();
    }
}
