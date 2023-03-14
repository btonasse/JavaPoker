package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class ThreeOfAKind extends RankSet {
    public ThreeOfAKind(ArrayList<PokerCard> cards, PokerRank rank) {
        super(cards, PokerHandEnum.THREE_OF_A_KIND, rank);
    }
}
