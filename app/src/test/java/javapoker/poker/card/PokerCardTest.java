package javapoker.poker.card;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class PokerCardTest {
    private PokerCard aceClubs, aceHearts, twoClubs;

    @BeforeEach
    public void setUp() {
        aceClubs = new PokerCard(PokerRank.ACE, PokerSuit.CLUBS);
        twoClubs = new PokerCard(PokerRank.TWO, PokerSuit.CLUBS);
        aceHearts = new PokerCard(PokerRank.ACE, PokerSuit.HEARTS);
    }

    @Test
    void higherCard() {
        assertTrue(aceClubs.compareTo(twoClubs) > 0);
        assertTrue(aceClubs.compareTo(twoClubs, false) < 0);
        assertTrue(aceClubs.compareTo(aceHearts) == 0);
    }

    @Test
    void getName() {
        assertEquals("Ace of Clubs", aceClubs.toString());
    }
}
