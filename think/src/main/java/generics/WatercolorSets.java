//: generics/WatercolorSets.java
package generics; /* Added by Eclipse.py */

import java.util.EnumSet;
import java.util.Set;

import generics.watercolors.Watercolors;

import static generics.watercolors.Watercolors.BRILLIANT_RED;
import static generics.watercolors.Watercolors.BURNT_UMBER;
import static generics.watercolors.Watercolors.CERULEAN_BLUE_HUE;
import static generics.watercolors.Watercolors.VIRIDIAN_HUE;
import static net.mindview.util.Print.print;
import static net.mindview.util.Sets.complement;
import static net.mindview.util.Sets.difference;
import static net.mindview.util.Sets.intersection;
import static net.mindview.util.Sets.union;

public class WatercolorSets {
    public static void main(String[] args) {
        Set<Watercolors> set1 = EnumSet.range(BRILLIANT_RED, VIRIDIAN_HUE);
        Set<Watercolors> set2 = EnumSet.range(CERULEAN_BLUE_HUE, BURNT_UMBER);
        print("set1: " + set1);
        print("set2: " + set2);
        print("union(set1, set2): " + union(set1, set2));
        Set<Watercolors> subset = intersection(set1, set2);
        print("intersection(set1, set2): " + subset);
        print("difference(set1, subset): " + difference(set1, subset));
        print("difference(set2, subset): " + difference(set2, subset));
        print("complement(set1, set2): " + complement(set1, set2));
    }
}