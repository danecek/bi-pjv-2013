/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danecek
 */
public class ParQuicksort extends Thread {

//    private int[] numbers;
    private int[] numbers;
    int low;
    int high;

    public ParQuicksort(int[] numbers, int low, int high) {
        this.numbers = numbers;
        this.low = low;
        this.high = high;
    }

//    public void sort(int[] values) {
//        // check for empty or null array
//        if (values == null || values.length == 0) {
//            return;
//        }
//        this.numbers = values;
//        number = values.length;
//        quicksort(0, number - 1);
//    }
    public void run() {//int[] numbers, int low, int high) {
        System.out.println(low + ":" + high);
        int i = low, j = high;
        // Get the pivot element from the middle of the list
        int pivot = numbers[low + (high - low) / 2];

        // Divide into two lists
        while (i <= j) {
            // If the current value from the left list is smaller then the pivot
            // element then get the next element from the left list
            while (numbers[i] < pivot) {
                i++;
            }
            // If the current value from the right list is larger then the pivot
            // element then get the next element from the right list
            while (numbers[j] > pivot) {
                j--;
            }

            // If we have found a values in the left list which is larger then
            // the pivot element and if we have found a value in the right list
            // which is smaller then the pivot element then we exchange the
            // values.
            // As we are done we can increase i and j
            if (i <= j) {
                exchange(numbers, i, j);
                i++;
                j--;
            }
        }
        Thread t = null, t2 = null;
        // Recursion
        if (low < j) {
            t = new ParQuicksort(numbers, low, j);
            t.start();
//            quicksort(numbers, low, j);
        }
        if (i < high) {
            t2 = new ParQuicksort(numbers, i, high);
            t2.start();
//            quicksort(numbers, i, high);
        }
        try {
            if (t != null) {
                t.join();
            }
            if (t2 != null) {
                t2.join();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(ParQuicksort.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void exchange(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] pole = {1, 8, 2, 9, 5, 222, 444, 6, 8, 23, 54, 1};
        Thread t = new ParQuicksort(pole, 0, pole.length - 1);
        t.start();
        try {
            t.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(ParQuicksort.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println(Arrays.toString(pole));

    }
}
