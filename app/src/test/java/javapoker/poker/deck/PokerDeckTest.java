package javapoker.poker.deck;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerSuit;
//import javapoker.poker.deck.PokerDeck; why don't I need this import?

public class PokerDeckTest {
    PokerDeck pokerDeck;
    PokerCard clubs2;

    @BeforeEach
    public void setUp() {
        pokerDeck = new PokerDeck(12345L);
        clubs2 = pokerDeck.cards().get(0);
    }

    @Test
    public void findCard() {
        assertEquals(clubs2, pokerDeck.findCard("2", PokerSuit.CLUBS));
    }
}
