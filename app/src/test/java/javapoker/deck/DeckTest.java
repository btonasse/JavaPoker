package javapoker.deck;

import org.junit.jupiter.api.Test;

import javapoker.poker.card.PokerCard;
import javapoker.poker.deck.PokerDeck;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;

public class DeckTest {
    PokerDeck pokerDeck;

    @BeforeEach
    public void setUp() {
        pokerDeck = new PokerDeck();
    }

    @Test
    public void deckLength() {
        assertEquals(52, pokerDeck.getCards().size());
    }

    @Test
    public void shuffleTest() {
        PokerCard clubs2 = pokerDeck.getCards().get(0);
        long seed = 12345L;
        pokerDeck.shuffle(seed);
        assertEquals(clubs2, pokerDeck.getCards().get(32));

    }

    @Test
    public void drawTest() {
        ArrayList<PokerCard> drawnCards, expectedCards;
        int lastIndex = pokerDeck.getCards().size() - 1;
        expectedCards = new ArrayList<PokerCard>(pokerDeck.getCards().subList(lastIndex - 1, lastIndex + 1));
        Collections.reverse(expectedCards);
        drawnCards = pokerDeck.draw(2);
        assertEquals(expectedCards, drawnCards);
        assertEquals(50, pokerDeck.getCards().size());
    }
}
