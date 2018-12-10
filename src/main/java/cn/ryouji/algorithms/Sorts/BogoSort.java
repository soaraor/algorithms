package cn.ryouji.algorithms.Sorts;

import java.util.Random;

/**
 * 猴子排序[听天由命]
 */
public class BogoSort implements SortAlgorithm {
    private static final Random random = new Random();


    private static <T extends Comparable<T>> boolean isSorted(T array[]){
        for(int i = 0; i<array.length - 1; i++){
            if(SortUtils.less(array[i + 1], array[i])) return false;
        }
        return true;
    }

    // Randomly shuffles the array
    private static <T> void nextPermutation(T array[]){
        int length = array.length;

        for (int i = 0; i < array.length; i++) {
            int randomIndex = i + random.nextInt(length - i);
            SortUtils.swap(array, randomIndex, i);
        }
    }

    public <T extends Comparable<T>> T[] sort(T array[]) {
        while(!isSorted(array)){
            nextPermutation(array);
        }
        return array;
    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        long time1 = System.currentTimeMillis();

        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};

        BogoSort bogoSort = new BogoSort();

        // print a sorted array
        SortUtils.print(bogoSort.sort(integers));

        // String Input
        String[] strings = {"c", "a", "e", "b","d"};

        SortUtils.print(bogoSort.sort(strings));

        long time2 = System.currentTimeMillis();
        System.out.println("本次猴子排序耗时："+(time1-time2)/1000+"msec");
    }
}
