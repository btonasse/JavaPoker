package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public abstract class RankSet extends Combination {
    private PokerRank rank;

    public RankSet(ArrayList<PokerCard> cards, PokerHandEnum combination, PokerRank rank) {
        super(cards, combination);
        this.rank = rank;
    }

    @Override
    protected int getIndividualValue() {
        return this.rank.getNumericValue(true);
    }
}
