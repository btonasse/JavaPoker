package javapoker.poker.deck;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Optional;

import javapoker.base.Deck;
import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.card.PokerSuit;

public class PokerDeck extends Deck<PokerCard> {
    public PokerDeck(boolean init, Long seed) {
        super(seed);
        if (init) {
            this.init();
        }
    }

    public PokerDeck(boolean init) {
        this(init, null);
    }

    public PokerDeck(Long seed) {
        this(true, seed);
    }

    public PokerDeck() {
        this(true, null);
    }

    private void init() {
        for (PokerRank rank : PokerRank.values()) {
            add(new PokerCard(rank, PokerSuit.CLUBS));
            add(new PokerCard(rank, PokerSuit.HEARTS));
            add(new PokerCard(rank, PokerSuit.SPADES));
            add(new PokerCard(rank, PokerSuit.DIAMONDS));
        }
    }

    public Optional<PokerCard> getCardByRankAndSuit(PokerRank rank, PokerSuit suit) {
        return this.cards().stream()
                .filter(card -> card.getRank() == rank && card.getSuit() == suit).findFirst();
    }

    public ArrayList<PokerCard> getCardsByRank(PokerRank rank) {
        return this.cards().stream()
                .filter(card -> card.getRank() == rank)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<PokerCard> getCardsBySuit(PokerSuit suit) {
        return this.cards().stream()
                .filter(card -> card.getSuit() == suit)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    private Stream<PokerCard> getCardsByValueStream(int value, boolean aceHigh) {
        return this.cards().stream()
                .filter(card -> card.getValue(aceHigh) == value);
    }

    public ArrayList<PokerCard> getCardsByValue(int value, boolean aceHigh) {
        return this.getCardsByValueStream(value, aceHigh)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public Optional<PokerCard> getAnyCardByValue(int value, boolean aceHigh) {
        return this.getCardsByValueStream(value, aceHigh).findAny();
    }

    public Optional<PokerCard> getCardBySuitAndValue(PokerSuit suit, int value, boolean aceHigh) {
        return this.cards().stream()
                .filter(card -> card.getSuit() == suit && card.getValue(aceHigh) == value).findFirst();
    }

    protected Optional<PokerCard> getNextCard(PokerCard current, boolean matchingSuit) {
        // We always search from the current up, so if current card is an Ace we want it
        // to have a value of 1
        int valueToSearch = current.getValue(false) + 1;
        if (matchingSuit) {
            return this.getCardBySuitAndValue(current.getSuit(), valueToSearch, true);
        } else {
            return this.getAnyCardByValue(valueToSearch, true);
        }
    }

}
