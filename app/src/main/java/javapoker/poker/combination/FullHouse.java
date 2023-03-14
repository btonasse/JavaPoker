package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class FullHouse extends TwoPair {

    public FullHouse(ArrayList<PokerCard> cards, PokerRank highest, PokerRank second) {
        super(cards, highest, second);
        this.combination = PokerHandEnum.FULL_HOUSE;
    }

}
