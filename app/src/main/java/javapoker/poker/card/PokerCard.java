package javapoker.poker.card;

import javapoker.base.Card;
import java.util.Arrays;

public class PokerCard extends Card<PokerCard> {
    private PokerSuit suit;
    String[] cardNames = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };

    public PokerCard(String name, PokerSuit suit) throws IllegalArgumentException {
        super(name);
        if (Arrays.asList(cardNames).indexOf(name) == -1) {
            throw new IllegalArgumentException(name + " is an invalid poker card name!");
        }
        this.suit = suit;
    }

    @Override
    public int compareTo(PokerCard other) {
        return compareTo(other, true);
    }

    public int compareTo(PokerCard other, boolean aceHigh) {
        return getValue(aceHigh) - other.getValue(aceHigh);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public PokerSuit getSuit() {
        return this.suit;
    }

    public int getValue(boolean aceHigh) {
        if (!aceHigh && this.name == "Ace") {
            return 1;
        } else {
            return Arrays.asList(cardNames).indexOf(name) + 2;
        }

    }

    @Override
    public String toString() {
        return this.name + " of " + this.suit;
    }
}