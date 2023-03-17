package javapoker.poker.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import javapoker.base.Card;

public class PokerCard extends Card<PokerCard> {
    private PokerSuit suit;
    private PokerRank rank;

    public PokerCard(PokerRank rank, PokerSuit suit) {
        super(rank.name());
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public int compareTo(PokerCard other) {
        return compareTo(other, true);
    }

    public int compareTo(PokerCard other, boolean aceHigh) {
        return getValue(aceHigh) - other.getValue(aceHigh);
    }

    public PokerSuit getSuit() {
        return this.suit;
    }

    public PokerRank getRank() {
        return this.rank;
    }

    public int getValue(boolean aceHigh) {
        return this.getRank().getNumericValue(aceHigh);

    }

    @Override
    public String toString() {
        return this.rank + " of " + this.suit;
    }

    public static ArrayList<PokerCard> getHighestNCards(ArrayList<PokerCard> cards, int howMany) {
        if (cards.size() >= howMany) {
            throw new IllegalArgumentException("Tried to get more cards than available cards");
        }
        return cards.stream()
                .sorted(Collections.reverseOrder())
                .limit(howMany)
                .collect(Collectors.toCollection(ArrayList::new));
    }
}