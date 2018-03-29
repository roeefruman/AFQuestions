import javafx.util.Pair;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class SubtractList {
    public static void main(String[] args) {
    }

    /*
     * Assuming We are not looking for a deep copy of and that we can use the original Pair we recive.
     * if HashCode() and Equales() are implemented on the Pair Object - we could use Hashset and use remove all like in the 1st 2 solutions
     *
     */



    /**
     * A solution using aList copy in aList hash set. so the comparing of elements in
     * solution is average O(nm), On aList very bad hashCode method of Pair it could get to O(n logn m) on Java 8+ on earliar version its O(n^2 m) - Java 8+ implement aList tree inside the bucket while earlier version aList list
     * If we have large data in Pair and have it happen oftern and need aList faster solution
     * we could Wrap pair with PairWithQuickHash - that will save the hash value of the pair on the pair creation
     * and cut down fron O(nm) to O(n)
     *
     * m - is just assuming that some hash code method complexity like string are depended on the content length\size
     * Requires Pair to implement hashCode
     *
     * Throws an error if one if the recived lists is null
     *
     * @param aList Base List
     * @param bList List of item to be "Substreacted" from A
     * @return aList List of item in A not in B
     */
    public static LinkedList<Pair> substractListsHashSolution(List<Pair> aList, List<Pair> bList) {
        Objects.requireNonNull(aList, "List A is Null");
        Objects.requireNonNull(bList, "List B is Null");

        if (aList.size()==0 || bList.size() == 0) {
            return new LinkedList<>(aList);
        }

        HashSet<Pair> hashedBSet = new HashSet<>(bList);
        LinkedList<Pair> results = new LinkedList<>();

        for (Pair pair : aList) {
            if (!hashedBSet.contains(pair)) {
                results.add(pair);
            }
        }
        return results;
    }



    /**
     * This version just uses the Java function dulicates and removes.
     * Performanec wise it dpepends on the List implementation of their removel all and contructor -
     * and if it has its optimization.
     * For Linked List it will be O(n^2), For TreeList O(n logn) ...
     * For A list with
     * It will still have the over head of creating the all the item and the removing those that aren't relavent
     * While in some solutions we can skip that and only add the one we want.
     *
     * Throws an error if one if the recived lists is null
     *
     * @param a
     * @param b List of item to be "Substreacted" from A
     * @return a List of item in A not in B
     */
    public static LinkedList<Pair> substractListsShortCode(List   <Pair> a, List<Pair> b) {
        Objects.requireNonNull(a, "List A is null");
        Objects.requireNonNull(b, "List B is null");
        if (a.size()==0 || b.size() == 0) {
            return new LinkedList<>(a);
        }


        LinkedList<Pair> results = new LinkedList<>(a);
        results.removeAll(b);
        return results;
    }

    /**
     * The Plain naive doubled loop solution
     * two nested loops     * @param a
     */
    public static LinkedList<Pair> substractListsPlain(List   <Pair> a, List<Pair> b) {
        Objects.requireNonNull(a, "List A is null");
        Objects.requireNonNull(b, "List B is null");
        if (a.size()==0 || b.size() == 0) {
            return new LinkedList<>(a);
        }

        LinkedList<Pair> results = new LinkedList<>();


        for (Pair valuaA : a) {
            boolean contains =false;
            for (Pair aB : b) {
                if (isSame(valuaA, aB)) {
                    contains = true;
                    break;
                }
            }
            if (!contains) {
                results.add(valuaA);
            }
        }
        return results;
    }

    private static boolean isSame(Pair valueA, Pair b) {
        return valueA.equals(b);
    }
}

