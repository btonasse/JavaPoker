package javapoker.poker.hand;

import org.junit.jupiter.api.Test;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerSuit;
import javapoker.poker.deck.PokerDeck;

import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Optional;

public class PokerHandTest {
    PokerHand hand;
    PokerDeck deck;

    @BeforeEach
    void setUp() {
        hand = new PokerHand();
        deck = new PokerDeck();

    }

}
