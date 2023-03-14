package javapoker.base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.stream.Collectors;

public class Deck<TCard extends Card<TCard>> {
    protected ArrayList<TCard> cards;
    private Long seed;

    public Deck() {
        this(null);
    }

    public Deck(Long seed) {
        this.cards = new ArrayList<TCard>();
        this.seed = seed;
    }

    public ArrayList<TCard> cards() {
        return this.cards;
    }

    public int size() {
        return this.cards.size();
    }

    public void add(ArrayList<TCard> cards) {
        for (TCard card : cards) {
            this.cards.add(card);
        }
    }

    public void add(TCard card) {
        this.cards.add(card);
    }

    public TCard getRandomCard() {
        Random generator = seed != null ? new Random(seed) : new Random();
        int index = (int) (generator.nextDouble() * size());
        return this.cards.get(index);
    }

    public ArrayList<TCard> getCardsByName(String name) {
        return this.cards().stream()
                .filter(card -> card.getName() == name)
                .collect(Collectors.toCollection(ArrayList::new));
    }

    public ArrayList<TCard> removeCards(ArrayList<TCard> cards) {
        ArrayList<TCard> removedCards = new ArrayList<TCard>();
        for (TCard card : cards) {
            int index = this.cards.indexOf(card);
            if (index >= 0) {
                removedCards.add(this.cards.remove(index));
            }
        }
        return removedCards;
    }

    public ArrayList<TCard> removeCards(int[] cardIndexes) throws IndexOutOfBoundsException {
        ArrayList<TCard> toRemove = new ArrayList<TCard>();
        for (int index : cardIndexes) {
            toRemove.add(this.cards.get(index));
        }
        return removeCards(toRemove);
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
        if (seed != null) {
            Collections.shuffle(this.cards, new Random(seed));
        } else {
            Collections.shuffle(this.cards);
        }

    }

}
