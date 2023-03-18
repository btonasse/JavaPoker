package javapoker.poker.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javapoker.poker.card.PokerCard;
import javapoker.poker.hand.PokerHandEnum;

public abstract class Combination implements Comparable<Combination> {
    private ArrayList<PokerCard> cards;
    private PokerHandEnum combination;

    public Combination(ArrayList<PokerCard> cards, PokerHandEnum combination) throws IllegalArgumentException {
        if (cards.size() != 5) {
            throw new IllegalArgumentException("Combinations must have 5 cards.");
        }
        this.cards = cards;
        this.combination = combination;
    }

    public ArrayList<PokerCard> getCards() {
        return this.cards;
    }

    public PokerHandEnum getCombination() {
        return this.combination;
    }

    @Override
    public int compareTo(Combination other) {
        return Comparator.comparing(Combination::getCombination)
                .thenComparing(this.tieBreaker(other))
                .thenComparing(this.highestUniqueCard(other))
                .compare(this, other);
    } // apparently this is inefficient because thenComparing is not skipped. Need to do conditionals.

    protected Comparator<Combination> tieBreaker(Combination other) {
        return this.highestUniqueCard(other);
    }

    protected Comparator<Combination> highestUniqueCard(Combination other) {
        return Comparator.comparing(Combination::getCards, (cards1, cards2) -> {
            ArrayList<PokerCard> copy1 = new ArrayList<>(cards1);
            ArrayList<PokerCard> copy2 = new ArrayList<>(cards2);
            copy1.removeAll(cards2);
            copy2.removeAll(cards1);
            return copy1.isEmpty() ? 0 : Collections.max(copy1).compareTo(Collections.max(copy2));
        });
    }

}
