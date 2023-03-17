package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.hand.PokerHandEnum;

public class SimpleStraight extends Straight {
    public SimpleStraight(ArrayList<PokerCard> cards) {
        super(cards, PokerHandEnum.STRAIGHT);
    }

}
