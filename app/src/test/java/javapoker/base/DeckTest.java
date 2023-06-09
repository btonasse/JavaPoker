package javapoker.base;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

public class DeckTest {
    Deck<GenericCard> deck;
    GenericCard card1, card2, card3;

    private final class GenericCard extends Card<GenericCard> {
        public GenericCard(String name) {
            super(name);
        }

        @Override
        public int compareTo(GenericCard other) {
            return 0;
        }
    }

    @BeforeEach
    public void setUp() {

        deck = new Deck<GenericCard>(12345L);
        card1 = new GenericCard("card1");
        card2 = new GenericCard("card2");
        card3 = new GenericCard("card3");
        deck.add(card1);
        deck.add(card2);
        deck.add(card3);

    }

    @Test
    public void deckSize() {
        assertEquals(3, deck.cards().size());
        assertEquals(3, deck.size());
    }

    @Test
    public void shuffleTest() {
        deck.shuffle();
        assertSame(card3, deck.cards().get(1));

    }

    @Test
    public void getRandomTest() {
        assertSame(card2, deck.getRandomCard());

    }

    @Test
    public void drawTest() {
        ArrayList<GenericCard> drawnCards, expectedCards;
        int lastIndex = deck.cards().size() - 1;
        expectedCards = new ArrayList<GenericCard>(deck.cards().subList(lastIndex - 1, lastIndex + 1));
        Collections.reverse(expectedCards);
        drawnCards = deck.draw(2);
        assertEquals(expectedCards, drawnCards);
        assertEquals(1, deck.cards.size());
    }

    @Test
    public void removeCards() {
        ArrayList<GenericCard> toRemove = new ArrayList<GenericCard>();
        toRemove.add(card2);
        assertEquals(toRemove, deck.removeCards(toRemove));
        assertEquals(2, deck.cards.size());
    }

    @Test
    public void removeByIndex() {
        ArrayList<GenericCard> expected = new ArrayList<GenericCard>();
        expected.add(card2);
        expected.add(card3);
        int[] toRemove = { 1, 2 };
        assertEquals(expected, deck.removeCards(toRemove));
        assertEquals(1, deck.cards.size());
    }

    @Test
    public void getAllByName() {
        deck.add(new GenericCard("card2"));
        ArrayList<GenericCard> found = deck.getCardsByName("card2");
        assertEquals(2, found.size());
        assertTrue(found.stream().allMatch(card -> card.getName() == "card2"));
    }
}
