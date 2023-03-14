package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class Pair extends RankSet {
    public Pair(ArrayList<PokerCard> cards, PokerRank rank) {
        super(cards, PokerHandEnum.PAIR, rank);
    }
}
