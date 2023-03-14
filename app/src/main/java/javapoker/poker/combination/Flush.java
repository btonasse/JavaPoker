package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.hand.PokerHandEnum;

public class Flush extends Combination implements FlushInterface {
    public Flush(ArrayList<PokerCard> cards) {
        super(cards, PokerHandEnum.FLUSH);
        assert this.isFlush(cards) == true;

    }

    @Override
    protected int getIndividualValue() {
        return this.getHighestCardValue(); //todo tiebreaker
    }
}
