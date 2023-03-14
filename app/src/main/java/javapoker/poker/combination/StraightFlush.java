package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.hand.PokerHandEnum;

public class StraightFlush extends Straight implements FlushInterface {
    public StraightFlush(ArrayList<PokerCard> cards) {
        super(cards);
        assert this.isFlush(cards);
        this.combination = PokerHandEnum.STRAIGHT_FLUSH;
    }
}
