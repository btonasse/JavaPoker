package javapoker.poker.combination;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javapoker.poker.card.PokerCard;
import javapoker.poker.hand.PokerHandEnum;

public abstract class Combination implements Comparable<Combination> {
    private ArrayList<PokerCard> cards;
    private PokerHandEnum combination;

    public Combination(ArrayList<PokerCard> cards, PokerHandEnum combination) {
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
                .thenComparing(this.tieBreaker())
                .thenComparing(this.highestCard())
                .compare(this, other);
    }

    protected abstract Comparator<Combination> tieBreaker();

    protected Comparator<? super Combination> highestCard() {
        return Comparator.comparing(Combination::getCards, Collections.reverseOrder());
    }

}
