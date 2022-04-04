package Week3;

import java.lang.reflect.Array;
import java.util.ArrayList;

// Java program for implementation of Bubble Sort
public class Bubble {
    public static void bubbleSort(ArrayList<Integer> arr) {

        for (int i = 0; i < arr.size() - 1; i++) {
            if (arr.get(i).compareTo(arr.get(i + 1)) > 0) {
                int temp = arr.get(i);
                arr.set(i, arr.get(i + 1));
                arr.set(i + 1, temp);
            }
        }
    }
}
    

