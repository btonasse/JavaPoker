package javapoker.poker.combination;

import java.util.ArrayList;
import java.util.Comparator;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public abstract class RankSet extends Combination {
    private PokerRank rank;

    public RankSet(ArrayList<PokerCard> cards, PokerHandEnum combination, PokerRank rank) {
        super(cards, combination);
        this.rank = rank;
    }

    protected PokerRank getRank() {
        return this.rank;
    }

    protected Comparator<RankSet> highestRank(RankSet other) {
        return Comparator.comparing(RankSet::getRank);
    }
}
