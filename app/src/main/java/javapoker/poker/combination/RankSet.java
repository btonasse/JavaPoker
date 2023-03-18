package javapoker.poker.combination;

import java.util.ArrayList;
import java.util.Comparator;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public abstract class RankSet extends Combination {
    private PokerRank highestSetRank;

    public RankSet(ArrayList<PokerCard> cards, PokerHandEnum combination, PokerRank rank) {
        super(cards, combination);
        this.highestSetRank = rank;
    }

    protected PokerRank getHighestSetRank() {
        return this.highestSetRank;
    }

    @Override
    protected Comparator<Combination> tieBreaker(Combination other) {
        if (other instanceof RankSet) {
            return Comparator.comparing(comb -> this.getHighestSetRank());
        } else {
            return super.tieBreaker(other);
        }
    }

}
