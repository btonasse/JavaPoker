package javapoker.base;

import java.util.ArrayList;
import java.util.Collections;

public abstract class Deck<TCard> {
    protected ArrayList<TCard> cards;

    public Deck(ArrayList<TCard> cards) {
        this.cards = cards;
    }

    public ArrayList<TCard> getCards() {
        return this.cards;
    }

    public ArrayList<TCard> draw(int howMany) throws IndexOutOfBoundsException {
        ArrayList<TCard> drawnCards = new ArrayList<TCard>();
        for (int i = 0; i < howMany; i++) {
            drawnCards.add(this.cards.remove(i));
        }
        return drawnCards;

    }

    public void shuffle() {
        Collections.shuffle(this.cards);
    }
}
