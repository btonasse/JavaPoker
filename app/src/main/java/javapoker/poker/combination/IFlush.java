package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerSuit;

public interface IFlush {
    public default boolean isFlush(ArrayList<PokerCard> cards) {
        PokerSuit suit = cards.get(0).getSuit();
        return cards.stream().allMatch(c -> c.getSuit() == suit);
    };
}
