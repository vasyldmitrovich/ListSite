package org.list_of_deals.modal.service;


import java.util.Arrays;

/*Class for testing some logic*/
public class TestingSomeMethods {
    public static void main(String[] args) {
        System.out.println("Middle of three number is:\t " + middleOfThree("4", "6", "9"));
        System.out.println("To do Match.abc, but do Trial operation:\t " + mathAbsButTrialOperation(-35.7));
        System.out.println("From fahrenheit to celsius:\t " + fahrenheitToCelsius(-90));
        System.out.println("Factorial we use cycle for:\t " + factorialUseFor(5));
        System.out.println("Factorial like example recursion:\t " + factorialUseRecursion(5));
        int[] arrIntSmall = {6, 1, 9, 2, 44, 92, 22, 14, -3, -6};
        System.out.println("Minimal value in array:\t " + minValueInArr(arrIntSmall));
        System.out.println();
        int[][] arrIntDecimal = new int[6][4];
        arrIntDecimal = addRandomIntInDecimalArr(arrIntDecimal);
        System.out.println(Arrays.deepToString(arrIntDecimal));
        System.out.println("____________________");


    }

    public static int[][] addRandomIntInDecimalArr(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = randomIntFromOneToHundred();
            }
        }
        return arr;
    }

    public static int middleOfThree(String str1, String str2, String str3) {
        if (str1 != null & str2 != null & str3 != null) {
            int mid = 0;
            try {
                int first = Integer.parseInt(str1);
                int second = Integer.parseInt(str2);
                int third = Integer.parseInt(str3);
                int max = Math.max(Math.max(first, second), third);
                int min = Math.min(Math.min(first, second), third);

                mid = first + second + third - (max + min);
            } catch (NumberFormatException n) {
                System.out.println("Error: " + n);
            }
//        Integer a = Integer.parseInt(str1);
//        Integer b = Integer.parseInt(str2);
//        Integer c = Integer.parseInt(str3);
//        return mid = (a > b)? ((c<b)?b:((c<a)?c:a)): ( (a>c)?a:(b>c)?c:b);
            return mid;
        } else return -1;
    }

    public static int minValueInArr(int[] arr) {
        int indexMin = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] <= arr[indexMin]) {
                indexMin = i;
            }
        }
        return arr[indexMin];
    }

    public static double mathAbsButTrialOperation(double data) {
        return data < 0 ? -data : data;
    }

    public static double fahrenheitToCelsius(int fahrenheit) {
        return (fahrenheit - 32) / 1.8;
    }

    public static int factorialUseFor(int n) {
        if (n <= 1) {
            return 1;
        } else {
            int result = 1;
            for (int i = n; i >= 1; i--) {
                result *= i;
            }
            return result;
        }
    }

    public static int factorialUseRecursion(int in) {
        if (in == 1) {
            return 1;
        }
        return in * factorialUseRecursion(in - 1);
    }

    public static long timeInMoment() {
        return System.nanoTime();
    }

    public static int[] bubbleSort(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    isSorted = false;
                    arr[i] = arr[i] + arr[i + 1] - (arr[i + 1] = arr[i]);
                }
            }
        }
        return arr;
    }

    public static int randomIntFromOneToHundred() {
        return (int) (Math.random() * 100);
    }

}
