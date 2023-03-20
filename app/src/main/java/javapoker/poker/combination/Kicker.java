package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.hand.PokerHandEnum;

public class Kicker extends Combination {
    Kicker(ArrayList<PokerCard> cards) {
        super(cards, PokerHandEnum.KICKER);
    }
}
