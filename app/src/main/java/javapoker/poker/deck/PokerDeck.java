package javapoker.poker.deck;

import javapoker.base.Deck;
import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerSuit;

public class PokerDeck extends Deck<PokerCard> {
    public PokerDeck(Long seed) {
        super(seed);
        String[] cardNameMap = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace" };
        for (int i = 0; i < cardNameMap.length; i++) {
            add(new PokerCard(cardNameMap[i], PokerSuit.CLUBS));
            add(new PokerCard(cardNameMap[i], PokerSuit.HEARTS));
            add(new PokerCard(cardNameMap[i], PokerSuit.SPADES));
            add(new PokerCard(cardNameMap[i], PokerSuit.DIAMONDS));
        }
    }

    public PokerDeck() {
        this(null);
    }

    public PokerCard findCard(String name, PokerSuit suit) {
        for (PokerCard card : this.cards) {
            if (card.getName() == name && card.getSuit() == suit) {
                return card;
            }
        }
        return null;
    }
}
