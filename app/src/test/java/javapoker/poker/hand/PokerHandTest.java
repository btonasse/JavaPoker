package javapoker.poker.hand;

import org.junit.jupiter.api.Test;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerSuit;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class PokerHandTest {
    PokerHand hand;

    @BeforeEach
    public void setUp() {
        PokerCard card1, card2, card3, card4, card5, card6, card7;
        card1 = new PokerCard("Ace", PokerSuit.SPADES);
        card2 = new PokerCard("2", PokerSuit.SPADES);
        card3 = new PokerCard("K", PokerSuit.SPADES);
        hand = new PokerHand();

    }
}
