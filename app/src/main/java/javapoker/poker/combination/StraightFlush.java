package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.hand.PokerHandEnum;

public class StraightFlush extends Straight implements IFlush {
    public StraightFlush(ArrayList<PokerCard> cards) {
        super(cards, PokerHandEnum.STRAIGHT_FLUSH);
        if (!this.isFlush(cards)) {
            throw new IllegalArgumentException("A straight flush needs 5 cards of the same suit");
        }
    }
}
