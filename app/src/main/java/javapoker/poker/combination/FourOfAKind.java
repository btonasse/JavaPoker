package javapoker.poker.combination;

import java.util.ArrayList;
import java.util.Comparator;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class FourOfAKind extends RankSet {
    public FourOfAKind(ArrayList<PokerCard> cards, PokerRank rank) {
        super(cards, PokerHandEnum.FOUR_OF_A_KIND, rank);
    }

    @Override
    protected Comparator<Combination> tieBreaker(Combination other) {
        if (other instanceof FourOfAKind) {
            return this.highestCard((FourOfAKind) other);
        }
        return super.tieBreaker(other);
    }

}
