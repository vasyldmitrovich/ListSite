package org.list_of_deals.modal.service;

import java.util.Arrays;

public class SortAlgorithms {

    //---------------------------------------------------------------------------------------
    /* Bubble sort algorithm
     * On the right side of array is the bigger element
     * How we can to improve bubble sort algorithm
     * 1. We can sort only left part of array, without sorted elements
     * 2. And on each step, we can make passing from left to right -> and right to left <-
     * On bubble sort algorithm was created another sorted algorithm
     * */
    public static void bubbleSort(int[] arr) {
        int count = 0;
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    /*int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;*/
                    arr[i] = arr[i] + arr[i + 1] - (arr[i + 1] = arr[i]);
                    count++;
                }
            }
            System.out.println("arr = " + Arrays.toString(arr));
        }
        System.out.println("How many operations = " + count);
    }

    //---------------------------------------------------------------------------------------
    /*About selection sort
     * Consider that first element is the less element in array
     * After that equals that element with next element
     * if second element is less than first
     * write that element in temp variable
     * when we go through whole array
     * we change these elements in places*/
    public static void selectionSort(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            int indexMin = i;
            int min = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    indexMin = j;
                    min = array[j];
                }
            }
            array[indexMin] = array[i];
            array[i] = min;
            count++;
            System.out.println("array = " + Arrays.toString(array) + "\tChanges element: " + array[indexMin] +
                    " -> And " + array[i] + " <-");
        }
        System.out.println("How many operations = " + count);
    }

    //---------------------------------------------------------------------------------------
    /* That algorithm is in standard libraries Java Arrays.sort()
     * Complexity O(n^2)
     * Efficiency for large arrays do not enough
     * Divide array to two array,
     * when we start first element is in first array
     * all another element is in second array
     * than take first element from second array
     * and pun on correct place in first array
     * That algorithm use if array almost sorted
     * but have some value in not correct places
     * make less step than quick sort*/
    public static void insertionSort(int[] arr) {
        int count = 0;
        for (int i = 1; i < arr.length; i++) {
            StringBuilder element = new StringBuilder("");
            int currenElement = arr[i];//That temp variable with value first element from second array

            int j = i;
            while (j > 0 && arr[j - 1] > currenElement) {
                element.append(" " + currenElement + "[" + j + "] less" + " " + arr[j - 1] + "[" + (j - 1) +
                        "] Data ->" + arr[j - 1] + " put in cell [" + j + "] ");
                arr[j] = arr[j - 1];
                j--;
                count++;
            }
            element.append("AFTER that " + currenElement + " put in cell[" + j + "]");
            arr[j] = currenElement;
            System.out.println("arr = " + Arrays.toString(arr) + "\t" + element);
        }
        System.out.println("How many operations = " + count);
    }

    //---------------------------------------------------------------------------------------
    /* Based on the principle 'divide et impera'
     * An array is divided into subarrays until there is one element in the array
     * After that, these arrays are combined with each other, 1 of 2, 2 of 3 etc.
     * When arrays concatenating, we are sorting that's elements
     * And we have many arrays on 2 element
     * After that, these arrays are combined with each other, and we have many arrays on 4 element etc.
     * */
    public static void mergeSort(int[] array) {
        int[] tmp;
        int[] currentSrc = array;
        int[] currentDest = new int[array.length];

        int size = 1;
        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;

            System.out.println("array = " + Arrays.toString(currentSrc));
        }
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    //---------------------------------------------------------------------------------------
    /*Quick sort
     * Take some elements
     * Divide on two array*/
    public static void quickSort(int[] arr, int from, int to) {

        if (from < to) {

            int divideIndex = partition(arr, from, to);

            quickSort(arr, from, divideIndex - 1);

            quickSort(arr, divideIndex, to);
        }
    }

    private static int partition(int[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        int pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (arr[leftIndex] < pivot) {
                leftIndex++;
            }

            while (arr[rightIndex] > pivot) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                swap(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }

}
