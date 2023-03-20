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
    PokerCard clubs2, diamonds3, diamonds4, spades5, clubs6, spades2, heartsAce, heartsKing, clubs7, clubsQueen,
            spadesAce,
            spadesKing, clubsAce, clubsKing;

    @BeforeEach
    void setUp() {
        deck = new PokerDeck();
        clubs2 = deck.getCardByRankAndSuit(PokerRank.TWO, PokerSuit.CLUBS).get();
        diamonds3 = deck.getCardByRankAndSuit(PokerRank.THREE, PokerSuit.DIAMONDS).get();
        diamonds4 = deck.getCardByRankAndSuit(PokerRank.FOUR, PokerSuit.DIAMONDS).get();
        spades5 = deck.getCardByRankAndSuit(PokerRank.FIVE, PokerSuit.SPADES).get();
        clubs6 = deck.getCardByRankAndSuit(PokerRank.SIX, PokerSuit.CLUBS).get();
        spades2 = deck.getCardByRankAndSuit(PokerRank.TWO, PokerSuit.SPADES).get();
        heartsAce = deck.getCardByRankAndSuit(PokerRank.ACE, PokerSuit.HEARTS).get();
        spadesAce = deck.getCardByRankAndSuit(PokerRank.ACE, PokerSuit.SPADES).get();
        clubsAce = deck.getCardByRankAndSuit(PokerRank.ACE, PokerSuit.CLUBS).get();
        heartsKing = deck.getCardByRankAndSuit(PokerRank.KING, PokerSuit.HEARTS).get();
        spadesKing = deck.getCardByRankAndSuit(PokerRank.KING, PokerSuit.SPADES).get();
        clubsKing = deck.getCardByRankAndSuit(PokerRank.KING, PokerSuit.CLUBS).get();
        clubs7 = deck.getCardByRankAndSuit(PokerRank.SEVEN, PokerSuit.CLUBS).get();
        clubsQueen = deck.getCardByRankAndSuit(PokerRank.QUEEN, PokerSuit.CLUBS).get();

    }

    @Test
    void compareDifferentCombinations() {

        Kicker kickerA = new Kicker(new ArrayList<>(List.of(clubs2, clubsQueen, heartsAce, spadesKing, clubs7)));
        Pair pairOfAces = new Pair(new ArrayList<>(List.of(clubs2, clubsQueen, heartsAce, spadesAce, clubs7)),
                PokerRank.ACE);
        TwoPair twoPairK2 = new TwoPair(new ArrayList<>(List.of(clubs2, spades2, heartsKing, spadesKing, clubs7)),
                PokerRank.KING, PokerRank.TWO);
        ThreeOfAKind threeKings = new ThreeOfAKind(
                new ArrayList<>(List.of(clubs2, clubsQueen, heartsKing, spadesKing, clubsKing)),
                PokerRank.ACE);
        SimpleStraight straight6 = new SimpleStraight(
                new ArrayList<>(List.of(clubs2, diamonds3, diamonds4, spades5, clubs6)));
        assertTrue(kickerA.compareTo(pairOfAces) < 0);
        assertTrue(pairOfAces.compareTo(twoPairK2) < 0);
        assertTrue(twoPairK2.compareTo(threeKings) < 0);
        assertTrue(threeKings.compareTo(straight6) < 0);

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

    @Test
    void threeTieBreaker() {
        ThreeOfAKind threeKings = new ThreeOfAKind(
                new ArrayList<>(List.of(clubs2, clubs6, heartsKing, spadesKing, clubsKing)),
                PokerRank.ACE);
        ThreeOfAKind threeAces = new ThreeOfAKind(
                new ArrayList<>(List.of(clubs2, clubsQueen, heartsAce, spadesAce, clubsAce)),
                PokerRank.ACE);
        ThreeOfAKind threeKingsKicker = new ThreeOfAKind(
                new ArrayList<>(List.of(clubs2, clubsQueen, heartsKing, spadesKing, clubsKing)),
                PokerRank.ACE);
        assertTrue(threeKings.compareTo(threeAces) < 0);
        assertTrue(threeKings.compareTo(threeKingsKicker) < 0);
        assertTrue(threeKingsKicker.compareTo(threeAces) < 0);
    }

}
