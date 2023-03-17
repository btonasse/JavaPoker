package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class TwoPair extends TwoSet {

    public TwoPair(ArrayList<PokerCard> cards, PokerRank highest, PokerRank second) {
        super(cards, PokerHandEnum.TWO_PAIR, highest, second);
    }

}
