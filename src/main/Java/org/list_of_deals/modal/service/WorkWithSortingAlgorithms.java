package org.list_of_deals.modal.service;

import java.util.Arrays;

public class WorkWithSortingAlgorithms {

    public static void testingSortMethods() {

        //Bubble sort
        int[] smallArr = {6, 1, 9, 2, 44, 92, 22, 14, -3, -6, 45, 32, 65, 82, 11, 34, 73, 10, 10};
        System.out.println("---------------------- Bubble sort");
        SortAlgorithms.bubbleSort(smallArr);
        System.out.println("----------------------");

        //Selection sort
        int[] smallArr1 = {6, 1, 9, 2, 44, 92, 22, 14, -3, -6, 45, 32, 65, 82, 11, 34, 73, 10, 10};
        System.out.println("---------------------- Selection sort");
        SortAlgorithms.selectionSort(smallArr1);
        System.out.println("----------------------");

        //Insertion sort
        int[] smallArr2 = {6, 1, 9, 2, 44, 92, 22, 14, -3, -6, 45, 32, 65, 82, 11, 34, 73, 10, 10};
        System.out.println("---------------------- Insertion sort");
        SortAlgorithms.insertionSort(smallArr2);
        System.out.println("----------------------");

        //Insertion sort
        int[] smallArr3 = {6, 1, 9, 2, 44, 92, 22, 14, -3, -6, 45, 32, 65, 82, 11, 34, 73, 10, 10};
        System.out.println("---------------------- Merge sort");
        SortAlgorithms.mergeSort(smallArr3);
        System.out.println("----------------------");

        System.out.println("---------------------- Bubble sort on sorted array");
        SortAlgorithms.bubbleSort(smallArr);
        System.out.println("----------------------");

        System.out.println("---------------------- Selection sort on sorted array");
        SortAlgorithms.selectionSort(smallArr1);
        System.out.println("----------------------");

        System.out.println("---------------------- Insertion sort on sorted array");
        SortAlgorithms.insertionSort(smallArr2);
        System.out.println("----------------------");

        System.out.println("---------------------- Merge sort on sorted array");
        SortAlgorithms.mergeSort(smallArr3);
        System.out.println("----------------------");



        //Wort with big array, and with almost sorted array

        //TODO before you uncomment and run workWithBigArray(),
        // please comment all System.out.println in bubbleSort and other Sort methods in code, in SortAlgorithms class
        //workWithBigArray();


    }

    public static void workWithBigArray() {

        System.out.println("------------------------------------------------------------------");


        //---------------------------------------------------------------------------------------
        int[] arr1 = new int[100_000];
        for (int i = 0; i < arr1.length; i++) {
            arr1[i] = TestingSomeMethods.randomIntFromOneToThousands();
        }
        System.out.println("---------------------- Bubble sort on BIG ARRAY");
        long startTime1Big = System.currentTimeMillis() / 1000;
        SortAlgorithms.bubbleSort(arr1);
        long finishTime1Big = System.currentTimeMillis() / 1000;
        long howLongWorkingAlgorithm1Big = finishTime1Big - startTime1Big;
        System.out.println("Bubble sort algorithm on BIG ARRAY have worked since " +
                howLongWorkingAlgorithm1Big + "s. \tOr: " + (howLongWorkingAlgorithm1Big * 1000) + "ms.");
        System.out.println("------------------------------------------------------------------");


        //---------------------------------------------------------------------------------------
        int[] arr2 = new int[100_000];
        for (int i = 0; i < arr2.length; i++) {
            arr2[i] = TestingSomeMethods.randomIntFromOneToThousands();
        }
        System.out.println("---------------------- Selection sort on BIG ARRAY");
        long startTime2Big = System.currentTimeMillis() / 1000;
        SortAlgorithms.selectionSort(arr2);
        long finishTime2Big = System.currentTimeMillis() / 1000;
        long howLongWorkingAlgorithm2Big = finishTime2Big - startTime2Big;
        System.out.println("Selection sort algorithm on BIG ARRAY have worked since " +
                howLongWorkingAlgorithm2Big + "s. \tOr: " + (howLongWorkingAlgorithm2Big * 1000) + "ms.");
        System.out.println("------------------------------------------------------------------");


        //---------------------------------------------------------------------------------------
        int[] arr3 = new int[100_000];
        for (int i = 0; i < arr3.length; i++) {
            arr3[i] = TestingSomeMethods.randomIntFromOneToThousands();
        }
        System.out.println("---------------------- Insertion sort on BIG ARRAY");
        long startTime3Big = System.currentTimeMillis() / 1000;
        SortAlgorithms.insertionSort(arr3);
        long finishTime3Big = System.currentTimeMillis() / 1000;
        long howLongWorkingAlgorithm3Big = finishTime3Big - startTime3Big;
        System.out.println("Insertion sort algorithm on BIG ARRAY have worked since " +
                howLongWorkingAlgorithm3Big + "s. \tOr: " + (howLongWorkingAlgorithm3Big * 1000) + "ms.");
        System.out.println("------------------------------------------------------------------");


        //---------------------------------------------------------------------------------------
        int[] arr4 = new int[100_000];
        for (int i = 0; i < arr4.length; i++) {
            arr4[i] = TestingSomeMethods.randomIntFromOneToThousands();
        }
        System.out.println("---------------------- Merge sort on BIG ARRAY");
        long startTime4Big = System.currentTimeMillis() / 1000;
        SortAlgorithms.mergeSort(arr4);
        long finishTime4Big = System.currentTimeMillis() / 1000;
        long howLongWorkingAlgorithm4Big = finishTime4Big - startTime4Big;
        System.out.println("Merge sort algorithm on BIG ARRAY have worked since " +
                howLongWorkingAlgorithm4Big + "s. \tOr: " + (howLongWorkingAlgorithm4Big * 1000) + "ms.");
        System.out.println("------------------------------------------------------------------");




        //---------------------------------------------------------------------------------------
        makeBigArrAlmostSorted(arr1);
        long startTime1 = System.currentTimeMillis() / 1000;
        SortAlgorithms.bubbleSort(arr1);
        long finishTime1 = System.currentTimeMillis() / 1000;
        long howLongWorkingAlgorithm1 = finishTime1 - startTime1;
        System.out.println("Bubble sort algorithm on big almost sorted array (only 3 element out of place) have worked since " +
                howLongWorkingAlgorithm1 + "s. \tOr: " + (howLongWorkingAlgorithm1 * 1000) + "ms.");
        System.out.println("------------------------------------------------------------------");

        //---------------------------------------------------------------------------------------
        makeBigArrAlmostSorted(arr2);
        long startTime2 = System.currentTimeMillis() / 1000;
        SortAlgorithms.selectionSort(arr2);
        long finishTime2 = System.currentTimeMillis() / 1000;
        long howLongWorkingAlgorithm2 = finishTime2 - startTime2;
        System.out.println("Selection sort algorithm on big almost sorted array (only 3 element out of place) have worked since " +
                howLongWorkingAlgorithm2 + "s. \tOr: " + (howLongWorkingAlgorithm2 * 1000) + "ms.");
        System.out.println("------------------------------------------------------------------");

        //---------------------------------------------------------------------------------------
        makeBigArrAlmostSorted(arr3);
        long startTime3 = System.currentTimeMillis() / 1000;
        SortAlgorithms.insertionSort(arr3);
        long finishTime3 = System.currentTimeMillis() / 1000;
        long howLongWorkingAlgorithm3 = finishTime3 - startTime3;
        System.out.println("Insertion sort algorithm on big almost sorted array (only 3 element out of place) have worked since " +
                howLongWorkingAlgorithm3 + "s. \tOr: " + (howLongWorkingAlgorithm3 * 1000) + "ms.");
        System.out.println("------------------------------------------------------------------");

        //---------------------------------------------------------------------------------------
        makeBigArrAlmostSorted(arr4);
        long startTime4 = System.currentTimeMillis() / 1000;
        SortAlgorithms.mergeSort(arr4);
        long finishTime4 = System.currentTimeMillis() / 1000;
        long howLongWorkingAlgorithm4 = finishTime4 - startTime4;
        System.out.println("Merge sort algorithm on big almost sorted array (only 3 element out of place) have worked since " +
                howLongWorkingAlgorithm4 + "s. \tOr: " + (howLongWorkingAlgorithm4 * 1000) + "ms.");
        System.out.println("------------------------------------------------------------------");

    }

    public static void makeBigArrAlmostSorted(int[] bigArrayAlmostSorted) {
        for (int i = 0; i < bigArrayAlmostSorted.length; i++) {
            bigArrayAlmostSorted[i] = TestingSomeMethods.randomIntFromOneToThousands();
        }
        //Sorting array
        Arrays.sort(bigArrayAlmostSorted);

        //I change places of several elements
        if (bigArrayAlmostSorted.length > 200) {
            bigArrayAlmostSorted[100] = bigArrayAlmostSorted[100] + bigArrayAlmostSorted[200] -
                    (bigArrayAlmostSorted[200] = bigArrayAlmostSorted[100]);
        }
        if (bigArrayAlmostSorted.length > 2000) {
            bigArrayAlmostSorted[1000] = bigArrayAlmostSorted[1000] + bigArrayAlmostSorted[2000] -
                    (bigArrayAlmostSorted[2000] = bigArrayAlmostSorted[1000]);
        }
        if (bigArrayAlmostSorted.length > 25000) {
            bigArrayAlmostSorted[15000] = bigArrayAlmostSorted[15000] + bigArrayAlmostSorted[25000] -
                    (bigArrayAlmostSorted[25000] = bigArrayAlmostSorted[15000]);
        }
    }
}
