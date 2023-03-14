package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.hand.PokerHandEnum;

public abstract class Combination implements Comparable<Combination> {
    protected ArrayList<PokerCard> cards;
    protected PokerHandEnum combination;

    public Combination(ArrayList<PokerCard> cards, PokerHandEnum combination) {
        assert cards.size() == 5;
        this.cards = cards;
        this.combination = combination;
    }

    public ArrayList<PokerCard> getCards() {
        return this.cards;
    }

    @Override
    public int compareTo(Combination other) {
        return this.getValue() - other.getValue();
    }

    protected int getHighestCardValue() {
        return this.cards.stream()
                .max(PokerCard::compareTo)
                .get()
                .getValue(false);
    }

    protected abstract int getIndividualValue(); // Must include a tie-breaker - maybe value needs to be a double so we add another 0 for each tie-breaker level

    public int getValue() {
        return this.getIndividualValue() + this.combination.ordinal() * 1000;
    }

}
