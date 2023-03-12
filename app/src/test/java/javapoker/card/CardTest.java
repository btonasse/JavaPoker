package javapoker.card;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerSuit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    private PokerCard aceClubs, aceHearts, twoClubs;

    @BeforeEach
    public void setUp() {
        aceClubs = new PokerCard("Ace", 14, PokerSuit.CLUBS);
        twoClubs = new PokerCard("2", 2, PokerSuit.CLUBS);
        aceHearts = new PokerCard("Ace", 14, PokerSuit.HEARTS);
    }

    @Test
    void higherCard() {
        assertTrue(aceClubs.compareTo(twoClubs) > 0);
        assertTrue(aceClubs.compareTo(twoClubs, false) < 0);
        assertTrue(aceClubs.compareTo(aceHearts) == 0);
    }

    @Test
    void getName() {
        assertEquals("Ace of Clubs", aceClubs.getName());
    }
}
