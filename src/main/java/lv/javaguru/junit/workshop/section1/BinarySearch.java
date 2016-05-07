package lv.javaguru.junit.workshop.section1;

public class BinarySearch {

    public int binarySearch(int[] sorted, int value) {
        int index = binarySearch(sorted, 0, sorted.length, value);
        if(index < 0) index = -1;
        return index;
    }

    private static int binarySearch(int[] sorted, int first, int upto, int value) {
        while (first < upto) {
            int mid = (first + upto) / 2;  // Compute mid point.
            if (value < sorted[mid]) {
                upto = mid;     // repeat search in bottom half.
            } else if (value > sorted[mid]) {
                first = mid + 1;  // Repeat search in top half.
            } else {
                return mid;     // Found it. return position
            }
        }
        return -(first + 1);    // Failed to find key
    }

}
