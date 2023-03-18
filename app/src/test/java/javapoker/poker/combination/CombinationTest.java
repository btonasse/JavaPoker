package javapoker.poker.combination;

import org.junit.jupiter.api.Test;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.card.PokerSuit;
import javapoker.poker.deck.PokerDeck;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

class CombinationTest {
    PokerDeck deck;
    PokerCard clubs2, spades2, heartsAce, heartsKing, clubs7, clubsQueen, spadesAce, spadesKing;

    @BeforeEach
    void setUp() {
        deck = new PokerDeck();
        clubs2 = deck.getCardByRankAndSuit(PokerRank.TWO, PokerSuit.CLUBS).get();
        spades2 = deck.getCardByRankAndSuit(PokerRank.TWO, PokerSuit.SPADES).get();
        heartsAce = deck.getCardByRankAndSuit(PokerRank.ACE, PokerSuit.HEARTS).get();
        spadesAce = deck.getCardByRankAndSuit(PokerRank.ACE, PokerSuit.SPADES).get();
        heartsKing = deck.getCardByRankAndSuit(PokerRank.KING, PokerSuit.HEARTS).get();
        spadesKing = deck.getCardByRankAndSuit(PokerRank.KING, PokerSuit.SPADES).get();
        clubs7 = deck.getCardByRankAndSuit(PokerRank.SEVEN, PokerSuit.CLUBS).get();
        clubsQueen = deck.getCardByRankAndSuit(PokerRank.QUEEN, PokerSuit.CLUBS).get();

    }

    @Test
    void compareDifferentCombinations() {
        ArrayList<PokerCard> handPair, handTwoPair;
        handPair = new ArrayList<>(List.of(clubs2, clubsQueen, heartsAce, spadesAce, clubs7));
        handTwoPair = new ArrayList<>(List.of(clubs2, spades2, heartsKing, spadesKing, clubs7));

        Pair pairOfAces = new Pair(handPair, PokerRank.ACE);
        TwoPair twoPairK2 = new TwoPair(handTwoPair, PokerRank.KING, PokerRank.TWO);
        assertTrue(pairOfAces.compareTo(twoPairK2) < 0);

    }

    @Test
    void pairTieBreaker() {
        ArrayList<PokerCard> cards1, cards2, cards3;
        cards1 = new ArrayList<>(List.of(clubs2, spades2, heartsAce, heartsKing, clubs7));
        cards2 = new ArrayList<>(List.of(clubs2, spades2, clubsQueen, heartsKing, clubs7));
        cards3 = new ArrayList<>(List.of(clubs2, spades2, heartsAce, clubsQueen, clubs7));

        Pair pair1 = new Pair(cards1, PokerRank.TWO);
        Pair pair2 = new Pair(cards2, PokerRank.TWO);
        Pair pair3 = new Pair(cards3, PokerRank.TWO);
        assertTrue(pair1.compareTo(pair2) > 0);
        assertTrue(pair1.compareTo(pair3) > 0);
        assertTrue(pair1.compareTo(pair1) == 0);
        assertTrue(pair2.compareTo(pair3) < 0);

    }

}
