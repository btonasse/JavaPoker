package javapoker.poker.deck;

import java.util.ArrayList;

import javapoker.base.Deck;
import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerSuit;

public class PokerDeck extends Deck<PokerCard> {
    public PokerDeck() {
        super(new ArrayList<PokerCard>());
        String[] cardNameMap = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King" };
        for (int i = 0; i < cardNameMap.length; i++) {
            this.cards.add(new PokerCard(cardNameMap[i], i + 1, PokerSuit.CLUBS));
            this.cards.add(new PokerCard(cardNameMap[i], i + 1, PokerSuit.HEARTS));
            this.cards.add(new PokerCard(cardNameMap[i], i + 1, PokerSuit.SPADES));
            this.cards.add(new PokerCard(cardNameMap[i], i + 1, PokerSuit.DIAMONDS));
        }
    }
}
