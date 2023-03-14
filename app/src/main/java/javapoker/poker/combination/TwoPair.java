package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class TwoPair extends RankSet {
    private PokerRank second;

    public TwoPair(ArrayList<PokerCard> cards, PokerRank highest, PokerRank second) {
        super(cards, PokerHandEnum.TWO_PAIR, highest);
        this.second = second;
    }

    @Override
    protected int getIndividualValue() {
        int highest = super.getIndividualValue() + 100;
        return this.second.getNumericValue(true) + highest;
    }
}
