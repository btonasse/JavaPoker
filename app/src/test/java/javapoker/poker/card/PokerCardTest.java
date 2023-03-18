package javapoker.poker.card;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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

    @Test
    void getValue() {
        assertEquals(14, aceHearts.getValue(true));
        assertEquals(1, aceHearts.getValue(false));
    }

    @Test
    void getNHighest() {
        ArrayList<PokerCard> cards = new ArrayList<>();
        cards.add(this.aceClubs);
        cards.add(this.twoClubs);
        cards.add(this.aceHearts);
        ArrayList<PokerCard> expected = new ArrayList<>();
        expected.add(this.aceClubs);
        expected.add(this.aceHearts);
        assertThrows(IllegalArgumentException.class, () -> PokerCard.getHighestNCards(cards, 4));
        assertThrows(IllegalArgumentException.class, () -> PokerCard.getHighestNCards(cards, 4));
        assertEquals(expected, PokerCard.getHighestNCards(cards, 2));

    }
}
