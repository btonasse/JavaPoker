package javapoker.poker.card;

import javapoker.base.card.CardBase;

public class PokerCard extends CardBase<PokerCard> {
    int value;
    PokerSuit suit;

    public PokerCard(String name, int value, PokerSuit suit) {
        super(name);
        this.value = value;
        this.suit = suit;
    }

    @Override
    public int compareTo(PokerCard other) {
        return this.value - other.value;
    }

    @Override
    public String getName() {
        return this.name + " of " + this.suit;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}