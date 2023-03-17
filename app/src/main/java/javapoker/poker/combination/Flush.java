package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.hand.PokerHandEnum;

public class Flush extends Combination implements IFlush {
    public Flush(ArrayList<PokerCard> cards) {
        super(cards, PokerHandEnum.FLUSH);
        if (!this.isFlush(cards)) {
            throw new IllegalArgumentException("A flush consists of 5 cards of the same suit");
        }
    }
}
