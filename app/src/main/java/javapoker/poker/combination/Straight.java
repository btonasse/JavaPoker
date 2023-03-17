package javapoker.poker.combination;

import java.util.ArrayList;
import java.util.Comparator;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public abstract class Straight extends Combination {
    public Straight(ArrayList<PokerCard> cards, PokerHandEnum combination) {
        super(cards, combination);
    }

    private boolean isLowAce() {
        return this.getCards().stream()
                .map(PokerCard::getRank)
                .filter(rank -> rank == PokerRank.ACE || rank == PokerRank.FIVE)
                .count() == 2;
    }

    private PokerRank getStraightHighestRank() {
        if (this.isLowAce()) {
            return PokerRank.FIVE;
        }
        return this.getCards().stream()
                .max(Comparator.comparing(PokerCard::getRank))
                .get().getRank();
    }

    @Override
    protected Comparator<Combination> tieBreaker(Combination other) {
        if (this.getClass() != other.getClass()) {
            throw new IllegalArgumentException("Can only compare two straights");
        }
        return Comparator.comparing(comb -> this.getStraightHighestRank());
    }

}
