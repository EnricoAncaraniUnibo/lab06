package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        List<Integer> ls = new ArrayList<>();
        for(int i = 0; i<1000; i++) {
            ls.add(i+1000);
        }
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        List<Integer> ls2 = new LinkedList<>(ls);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        Integer tmp;
        tmp = ls.get(0);
        ls.set(0, ls.get(ls.size()-1));
        ls.set(ls.size()-1, tmp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer integer : ls) {
            System.out.print(integer+" ");
        }
        System.out.println();
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            ls.add(i);
        }

        time = System.nanoTime() - time;
        final var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + ls.size()
                + " writing 100000 int "
                + time
                + "ns ("
                + millis
                + "ms)"
        );

        time = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            ls2.add(i);
        }
        time = System.nanoTime() - time;
        final var millis2 = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + ls2.size()
                + " writing 100000 int "
                + time
                + "ns ("
                + millis2
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for(int i = 0;i<1000;i++) {
            tmp = ls.get((int)Math.floor(ls.size()/2));
        }
        time = System.nanoTime() - time;
        final var millis3 = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + ls.size()
                + " read 1000 times the element in the middle "
                + time
                + "ns ("
                + millis3
                + "ms)"
        );

        time = System.nanoTime();
        for(int i = 0;i<1000;i++) {
            tmp = ls2.get((int)Math.floor(ls2.size()/2));
        }
        time = System.nanoTime() - time;
        final var millis4 = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + ls2.size()
                + " read 1000 times the element in the middle "
                + time
                + "ns ("
                + millis4
                + "ms)"
        );
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
        Map<String,Long> m = new HashMap<>();
        m.put("Africa", 1110635000L);
        m.put("Americas", 972005000L);
        m.put("Antarctica", 0L);
        m.put("Asia", 4298723000L);
        m.put("Europe", 742452000L);
        m.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        long worldPop = 0;
        for (var k : m.keySet()) {
            worldPop += m.get(k);
        }
        System.out.println(worldPop);
    }
}
