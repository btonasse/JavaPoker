package javapoker.card;

public abstract class CardBase {
    protected String name;

    public CardBase(String name) {
        this.name = name;

    }

    public abstract String getName();

}
