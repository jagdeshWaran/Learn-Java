package array;

public class ArrayProblem {
    public static int getIndex(int[] arr, int find) {
        for (int index = 0; index <= arr.length; index++) {
            if (find == arr[index]) return index;
        }
        return -1;
    }
}
