package javapoker.base;

public abstract class Card<T> implements Comparable<T> {
    protected String name;

    public Card(String name) {
        this.name = name;

    }

    @Override
    public abstract int compareTo(T other);

    public abstract String getName();

}
