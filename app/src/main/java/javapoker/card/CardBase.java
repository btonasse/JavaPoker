package javapoker.card;

public abstract class CardBase<T> implements Comparable<T> {
    protected String name;

    public CardBase(String name) {
        this.name = name;

    }

    @Override
    public abstract int compareTo(T other);

    public abstract String getName();

}
