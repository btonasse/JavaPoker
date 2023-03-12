package javapoker.poker.card;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class PokerCardTest {
    private PokerCard aceClubs, aceHearts, twoClubs;

    @BeforeEach
    public void setUp() {
        aceClubs = new PokerCard("Ace", PokerSuit.CLUBS);
        twoClubs = new PokerCard("2", PokerSuit.CLUBS);
        aceHearts = new PokerCard("Ace", PokerSuit.HEARTS);
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

    @Test
    void invalidName() {
        assertThrows(IllegalArgumentException.class, () -> {
            new PokerCard("Aces", PokerSuit.HEARTS);
        });
    }
}
