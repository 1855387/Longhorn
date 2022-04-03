package Week3;

import java.util.ArrayList;

// Java program for implementation of Bubble Sort
public class Bubble
{
   public static void bubbleSort(ArrayList<Integer> arr)
    {
        int n = arr.size();
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (arr.get(j) > arr.get(j+1))
                {
                    // swap arr[j+1] and arr[j]
                    int temp = arr.get(j);
                    arr.set(j, j+1);
                    arr.set(j+1, temp);
                }
    }

}

