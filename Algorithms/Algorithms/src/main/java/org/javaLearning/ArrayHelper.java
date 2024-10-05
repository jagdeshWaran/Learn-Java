package generics;

/**
 * @author Jagadeesh waran
 * @see Comparable
 */
@SuppressWarnings("unused")
public class ArrayHelper {

    // Don't let anyone create an instance
    private ArrayHelper() {
    }

    // ---------- Search Operations ---------- //

    public static <T extends Comparable<T>> T getSecondMaximum(T[] arr) {
        T max = null;
        T secondMax = null;

        for (T val : arr) {
            if (max == null) {
                max = val;
                continue;
            }
            if (max.compareTo(val) < val.compareTo(max)) {
                secondMax = max;
                max = val;
                continue;
            }
            if (secondMax == null) {
                continue;
            }
            if (max.compareTo(val) > val.compareTo(max) && secondMax.compareTo(val) < val.compareTo(secondMax)) {
                secondMax = val;
            }
        }
        return secondMax;
    }


    public static <T extends Comparable<T>> T maxOf(T[] obj) {
        T max = null;

        for (T o : obj) {
            if (max == null) {
                max = o;
                continue;
            }
            if (max.compareTo(o) < o.compareTo(max)) {
                max = o;
            }
        }
        return max;
    }

    public static <T> int indexOf(T[] source, T target) {
        if (target == null) {
            for (int i = 0; i < source.length; i++) {
                if (source[i] == null) {
                    return i;
                }
            }
        }
        for (int i = 0; i < source.length; i++) {
            if (source[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    // ----------- Sort Operations ----------- //

    public static <T extends Comparable<T>> T[] bubbleSort(T[] objects) {
        return objects;
    }
}
