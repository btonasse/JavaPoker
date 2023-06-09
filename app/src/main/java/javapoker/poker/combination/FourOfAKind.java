package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class FourOfAKind extends RankSet {
    public FourOfAKind(ArrayList<PokerCard> cards, PokerRank rank) {
        super(cards, PokerHandEnum.FOUR_OF_A_KIND, rank);
    }

}
