package org.javase.genericsexamples.test;

import java.util.ArrayList;
import java.util.List;

public class WildcardsAndSubtyping {

    public static void main(String[] args) {
        List<? extends Integer> intList = new ArrayList<>();
        // OK. List<? extends Integer> is a subtype of List<? extends Number>
        List<? extends Number>  numList = intList;
    }
}
