package javapoker.poker.combination;

import java.util.ArrayList;
import java.util.Comparator;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class TwoSet extends RankSet {
    protected PokerRank secondHighestSetRank;

    public TwoSet(ArrayList<PokerCard> cards, PokerHandEnum combination, PokerRank highest, PokerRank second) {
        super(cards, combination, highest);
        this.secondHighestSetRank = second;
    }

    public PokerRank getSecondHighestSetRank() {
        return this.secondHighestSetRank;
    }

    @Override
    protected Comparator<Combination> tieBreaker(Combination other) {
        if (other instanceof TwoSet) {
            return super.tieBreaker(other)
                    .thenComparing(comb -> this.getSecondHighestSetRank());
        } else {
            return super.tieBreaker(other);
        }
    }

}
