package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class FullHouse extends TwoSet {

    public FullHouse(ArrayList<PokerCard> cards, PokerRank highest, PokerRank second) {
        super(cards, PokerHandEnum.FULL_HOUSE, highest, second);
    }
}
