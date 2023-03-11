package javapoker.card.poker;

import javapoker.card.CardBase;

public class PokerCard extends CardBase<PokerCard> {
    int value;
    PokerSuit suit;

    public PokerCard(String name, int value, PokerSuit suit) {
        super(name);
        this.value = value;
        this.suit = suit;
    }

    public int compareTo(PokerCard other) {
        return this.value - other.value;
    }

    public String getName() {
        return this.name + " of " + this.suit;
    }

    public String toString() {
        return this.getName();
    }
}