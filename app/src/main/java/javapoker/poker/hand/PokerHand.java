package javapoker.poker.hand;

import javapoker.poker.card.PokerCard;
import javapoker.poker.card.PokerRank;
import javapoker.poker.card.PokerSuit;
import javapoker.poker.combination.Combination;
import javapoker.poker.combination.Flush;
import javapoker.poker.combination.FourOfAKind;
import javapoker.poker.combination.FullHouse;
import javapoker.poker.combination.Pair;
import javapoker.poker.combination.SimpleStraight;
import javapoker.poker.combination.Straight;
import javapoker.poker.combination.StraightFlush;
import javapoker.poker.combination.ThreeOfAKind;
import javapoker.poker.combination.TwoPair;
import javapoker.poker.deck.PokerDeck;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PokerHand extends PokerDeck implements Comparable<PokerHand> {

    public PokerHand() {
        super(false);
    }

    public int compareTo(PokerHand other) {
        return this.getHighestCombination().compareTo(other.getHighestCombination());
        // todo (hands must be comparable so as to
        // return the highest card if combination
        // value is the same)
    }

    public Combination getHighestCombination() {
        // Check for straight flush
        Optional<Straight> straight = this.getHighestStraight(this.cards);
        if (straight.isPresent() && straight.get() instanceof StraightFlush) {
            return straight.get();
        }
        // Now group cards by rank and check for sets
        HashMap<PokerRank, ArrayList<PokerCard>> ranks = this.groupByRank(this.cards);
        Optional<ArrayList<PokerCard>> set = this.getHighestSet(ranks);
        if (set.isPresent()) {
            int size = set.get().size();
            PokerRank setRank = this.getSetRank(set.get());
            // Check for four of a kind
            if (size == 4) {
                return new FourOfAKind(this.completeSetWithHighestCards(set.get()), setRank);
            }
            // Check for three of a kind. If found, check for Full House 
            else if (size == 3) {
                Optional<ArrayList<PokerCard>> pairForFullHouse = this.getHighestSetOfSize(ranks, 2);
                if (pairForFullHouse.isPresent()) {
                    set.get().addAll(pairForFullHouse.get());
                    return new FullHouse(set.get(), setRank, this.getSetRank(pairForFullHouse.get()));
                }
                // If no full house, check for flush and straight. Otherwise return three of a kind
                else {
                    HashMap<PokerSuit, ArrayList<PokerCard>> suits = this.groupBySuit(this.cards);
                    Optional<Flush> flush = this.getHighestFlush(suits);
                    if (flush.isPresent()) {
                        return flush.get();
                    } else if (straight.isPresent()) {
                        return straight.get();
                    } else {
                        return new ThreeOfAKind(this.completeSetWithHighestCards(set.get()), setRank);
                    }
                }
            }
            // Check for two pairs. If not found, return the single pair that was found
            else {
                HashMap<PokerRank, ArrayList<PokerCard>> ranksWithoutPair = new HashMap<>(ranks);
                ranksWithoutPair.remove(this.getSetRank(set.get()));
                Optional<ArrayList<PokerCard>> secondPair = this.getHighestSetOfSize(ranksWithoutPair, 2);
                if (secondPair.isPresent()) {
                    set.get().addAll(secondPair.get());
                    return new TwoPair(this.completeSetWithHighestCards(set.get()), setRank,
                            this.getSetRank(secondPair.get()));
                } else {
                    return new Pair(this.completeSetWithHighestCards(set.get()), setRank);
                }
            }
        } else {
            return null;
        }

    }

    private Optional<Straight> getStraight(ArrayList<PokerCard> previousCards, boolean tryFlush) {
        int size = previousCards.size();
        // Base case: poker hands have 5 cards
        if (size == 5) {
            // if the tryFlush flag hasn't been turned off, this means we have a straight flush
            if (tryFlush) {
                return Optional.of(new StraightFlush(previousCards));
            } else {
                return Optional.of(new SimpleStraight(previousCards));
            }
        }
        /* Try to get next card.
         * If fails and we tried to get a next card of the same suit, flip tryFlush flag and try again.
         * Otherwise return empty Optional. */
        Optional<PokerCard> next = this.getNextCard(previousCards.get(size - 1), tryFlush);
        if (next.isEmpty()) {
            if (tryFlush) {
                return this.getStraight(previousCards, false);
            }
            return Optional.empty();
        }
        // If successful, add found card and recurse
        previousCards.add(next.get());
        return this.getStraight(previousCards, tryFlush);

    }

    private Optional<Straight> getHighestStraight(ArrayList<PokerCard> cards) {
        return cards.stream()
                .map(card -> this.getStraight(new ArrayList<>(List.of(card)), true))
                .flatMap(Optional::stream)
                .max(Straight::compareTo);

    }

    private HashMap<PokerRank, ArrayList<PokerCard>> groupByRank(ArrayList<PokerCard> cards) {
        return this.cards().stream()
                .collect(Collectors.groupingBy(PokerCard::getRank, HashMap::new,
                        Collectors.toCollection(ArrayList::new)));
    }

    private HashMap<PokerSuit, ArrayList<PokerCard>> groupBySuit(ArrayList<PokerCard> cards) {
        return this.cards().stream()
                .collect(Collectors.groupingBy(PokerCard::getSuit, HashMap::new,
                        Collectors.toCollection(ArrayList::new)));
    }

    private Optional<Flush> getHighestFlush(HashMap<PokerSuit, ArrayList<PokerCard>> suitGroups) {
        Optional<Flush> highestFlush = suitGroups.entrySet().stream()
                .filter(suit -> suit.getValue().size() >= 5)
                .map(suit -> new Flush(PokerCard.getHighestNCards(suit.getValue(), 5)))
                .max(Flush::compareTo);
        return highestFlush;
    }

    private Optional<ArrayList<PokerCard>> getHighestSetOfSize(HashMap<PokerRank, ArrayList<PokerCard>> rankGroups,
            int size) {
        assert size >= 2 && size <= 4;
        Optional<ArrayList<PokerCard>> highestSet = rankGroups.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(arrayList -> arrayList.size() == size)
                .max((a, b) -> a.get(0).compareTo(b.get(0)));

        return Optional.ofNullable(highestSet.get());
    }

    private ArrayList<PokerCard> completeSetWithHighestCards(ArrayList<PokerCard> set) {
        ArrayList<PokerCard> finalHand = new ArrayList<>();
        finalHand.addAll(set);

        ArrayList<PokerCard> remainingCards = this.cards().stream()
                .filter(card -> !finalHand.contains(card))
                .sorted(Comparator.reverseOrder())
                .limit(5 - finalHand.size())
                .collect(Collectors.toCollection(ArrayList::new));

        finalHand.addAll(remainingCards);
        return finalHand;
    }

    private Optional<ArrayList<PokerCard>> getHighestSet(HashMap<PokerRank, ArrayList<PokerCard>> rankGroups) {
        Optional<ArrayList<PokerCard>> highestSet = rankGroups.entrySet().stream()
                .map(entry -> entry.getValue())
                .filter(arrayList -> arrayList.size() > 1)
                .max(Comparator.comparingInt((ArrayList<PokerCard> list) -> list.size())
                        .thenComparing(Comparator.comparing((ArrayList<PokerCard> list) -> list.get(0))));
        return Optional.ofNullable(highestSet.get());
    }

    private PokerRank getSetRank(ArrayList<PokerCard> set) {
        return set.get(0).getRank();
    }

    // Todo: 
    // 1) Implement comparators separately instead of having them be anonymous on all these methods
    // 2) Break this class up (especially getHighestCombination) and figure out where every method should live
    // 3) Figure out the role of the combination classes. Should they have static methods that return their own instances to help solve #2?
    // 4) Write tests!
    // 5) Replace asserts with IllegalArgumentExceptions!
    // 6) Handle when no combinations exist. How to handle highest card?
    // 7) What about tiebreakers when highest card is the same? Need a better implementation of comparation in each combination class
    // 8) Better handle the numeric value of each combination. Or maybe its redundant if we implement proper comparation
}
