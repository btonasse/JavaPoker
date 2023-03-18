package javapoker.poker.deck;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.card.PokerSuit;

public class PokerDeckTest {
    PokerDeck pokerDeck;
    PokerCard clubs2;

    @BeforeEach
    void setUp() {
        pokerDeck = new PokerDeck(12345L);
        clubs2 = pokerDeck.cards().get(0);
    }

    @Test
    void getByRankAndSuit() {
        assertSame(clubs2, pokerDeck.getCardByRankAndSuit(PokerRank.TWO, PokerSuit.CLUBS).get());
        pokerDeck.removeCards(new int[] { 0 });
        assertTrue(pokerDeck.getCardByRankAndSuit(PokerRank.TWO, PokerSuit.CLUBS).isEmpty());
    }

    @Test
    void getAllBySuit() {
        ArrayList<PokerCard> found = pokerDeck.getCardsBySuit(PokerSuit.CLUBS);
        assertEquals(13, found.size());
        assertTrue(found.stream().allMatch(card -> card.getSuit() == PokerSuit.CLUBS));
    }

    @Test
    void getByValue() {
        ArrayList<PokerCard> foundCards = pokerDeck.getCardsByValue(2, true);
        assertEquals(4, foundCards.size());
        assertTrue(foundCards.stream().allMatch(card -> card.getValue(true) == 2));
        assertTrue(pokerDeck.getCardsByValue(1, true).isEmpty());

        Optional<PokerCard> next = pokerDeck.getAnyCardByValue(2, true);
        assertTrue(next.get().getValue(true) == 2);
    }

    @Test
    void getBySuitAndValue() {
        Optional<PokerCard> found = pokerDeck.getCardBySuitAndValue(PokerSuit.CLUBS, 2, true);
        assertEquals(clubs2, found.get());
        assertTrue(pokerDeck.getCardBySuitAndValue(PokerSuit.CLUBS, 1, true).isEmpty());
    }

    @Test
    void getNext() {
        PokerCard nextAny, nextClubs;
        nextAny = pokerDeck.getNextCard(clubs2, false).get();
        assertTrue(nextAny.getRank() == PokerRank.THREE);
        nextClubs = pokerDeck.getNextCard(clubs2, true).get();
        assertTrue(nextAny.getRank() == PokerRank.THREE && nextClubs.getSuit() == PokerSuit.CLUBS);
    }

    @Test
    void groupingMethods() {
        HashMap<PokerRank, ArrayList<PokerCard>> rankGroup = pokerDeck.groupByRank();
        assertEquals(4, rankGroup.get(PokerRank.EIGHT).size());
        assertTrue(rankGroup.get(PokerRank.EIGHT).stream().allMatch(card -> card.getRank() == PokerRank.EIGHT));
        HashMap<PokerSuit, ArrayList<PokerCard>> suitGroup = pokerDeck.groupBySuit();
        assertEquals(13, suitGroup.get(PokerSuit.SPADES).size());
        assertTrue(suitGroup.get(PokerSuit.SPADES).stream().allMatch(card -> card.getSuit() == PokerSuit.SPADES));
    }
}
