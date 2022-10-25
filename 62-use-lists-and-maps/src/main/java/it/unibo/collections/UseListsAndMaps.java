package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {
    private static final int ELEMS = 100000;
    private static final int READS = 100000;
    private static final int SELEMS = 1000;
    private static final int FELEMS = 2000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *          unused
     */
    private static void readElems(final List<Integer> l) {
        long time1 = System.nanoTime();
        for (int u = 0; u < READS; u++) {
            l.get(l.size() / 2);
        }
        time1 = System.nanoTime() - time1;
        System.out.println(time1);

    }

    private static void addElems(final List<Integer> l) {
        long time1 = System.nanoTime();
        for (int m = 0; m < ELEMS; m++) {
            l.add(0, m);
        }
        time1 = System.nanoTime() - time1;
        System.out.println(time1);
    }

    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        final List<Integer> l = new ArrayList<>();
        for (int i = SELEMS; i < FELEMS; i++) {
            l.add(i);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        final List<Integer> ll = new LinkedList<>(l);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        final int i = l.get(0);
        l.set(0, l.get(l.size() - 1));
        l.set(l.size() - 1, i);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (final int j : l) {
            System.out.println(j);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        addElems(l);
        addElems(ll);
        /*
         * long time1 = System.nanoTime();
         * for (int m = 0; m < ELEMS; m++) {
         * l.add(0, m);
         * }
         * time1 = System.nanoTime() - time1;
         * 
         * long time2 = System.nanoTime();
         * for (int m = 0; m < ELEMS; m++) {
         * ll.add(0, m);
         * }
         * time2 = System.nanoTime() - time2;
         * 
         * System.out.println(time1 + " " + time2);
         */
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example PerfTest.java.
         */
        readElems(l);
        readElems(ll);
        /*
        time1 = System.nanoTime();
        for (int u = 0; u < READS; u++) {
            l.get(l.size() / 2);
        }
        time1 = System.nanoTime() - time1;
        time2 = System.nanoTime();
        for (int u = 0; u < READS; u++) {
            ll.get(ll.size() / 2);
        }
        time2 = System.nanoTime() - time2;

        System.out.println(time1 + " " + time2);
        */
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        final Map<String, Long> m = new HashMap<>();
        m.put("Africa", 1110635000L);
        m.put("Americas", 972005000L);
        m.put("Antarctica", 0L);
        m.put("Asia", 4298723000L);
        m.put("Europe", 742452000L);
        m.put("Oceania", 38304000L);

        /*
         * 8) Compute the population of the world
         */

        long tot = 0;
        for (final long p : m.values()) {
            tot += p;
        }
        System.out.println("population: " + tot);
    }
}
