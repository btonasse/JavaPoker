package javapoker.poker.card;

public enum PokerRank {
    TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE;

    public int getNumericValue(boolean aceHigh) {
        if (!aceHigh && this == PokerRank.ACE) {
            return 1;
        }
        return this.ordinal() + 2;
    }

    @Override
    public String toString() {
        String root = this.name();
        Integer val = this.ordinal() + 2;
        if (val <= 10) {
            root = val.toString();
        }
        return root.substring(0, 1) + root.substring(1).toLowerCase();
    }
}
