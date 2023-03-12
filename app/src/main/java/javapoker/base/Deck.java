package javapoker.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

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
            int lastIndex = this.cards.size() - 1;
            drawnCards.add(this.cards.remove(lastIndex));
        }
        return drawnCards;

    }

    public void shuffle() {
        shuffle(null);
    }

    public void shuffle(Long seed) {
        if (seed != null) {
            Collections.shuffle(this.cards, new Random(seed));
        } else {
            Collections.shuffle(this.cards);
        }

    }
}
