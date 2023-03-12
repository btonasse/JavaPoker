package javapoker.poker.card;

import javapoker.base.Card;

public class PokerCard extends Card<PokerCard> {
    int value;
    PokerSuit suit;

    public PokerCard(String name, int value, PokerSuit suit) {
        super(name);
        this.value = value;
        this.suit = suit;
    }

    @Override
    public int compareTo(PokerCard other) {
        return compareTo(other, true);
    }

    public int compareTo(PokerCard other, boolean aceHigh) {
        int thisRealValue, otherRealValue;
        if (!aceHigh) {
            if (this.name == "Ace") {
                thisRealValue = 1;
            } else {
                thisRealValue = this.value;
            }
            if (other.name == "Ace") {
                otherRealValue = 1;
            } else {
                otherRealValue = other.value;
            }
        } else {
            thisRealValue = this.value;
            otherRealValue = other.value;
        }
        return thisRealValue - otherRealValue;
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