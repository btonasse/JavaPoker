package javapoker.poker.combination;

import java.util.ArrayList;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.hand.PokerHandEnum;

public class Straight extends Combination {
    public Straight(ArrayList<PokerCard> cards) {
        super(cards, PokerHandEnum.STRAIGHT);
    }

    private boolean isLowAce() {
        return this.getCards().stream()
                .map(PokerCard::getRank)
                .filter(rank -> rank == PokerRank.ACE || rank == PokerRank.FIVE)
                .count() == 2;
    }

    protected Comparator<Combination> tieBreaker(Combination other) {
        if (this.isLowAce()) {
            return 5;
        }
        return this.getHighestCardValue();
    }

}
