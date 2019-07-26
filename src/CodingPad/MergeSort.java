package CodingPad;

import java.util.Arrays;

public class MergeSort {
    // time: O(nlogn), space:O(longn)
    public int[] mergeSort(int[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        int[] helper = new int[array.length];
        sort(array, helper, 0, array.length - 1);
        return array;
    }

    private void sort(int[] array, int[] helper, int left, int right) {
        // TODO: recursive do merge sort
        // base case
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(array, helper, left, mid);
        sort(array, helper, mid + 1, right);
        merge(array, helper, left, mid, right); // merge sorted subarray after recursice call sort function
    }

    private void merge(int[] array, int[] helper, int left, int mid, int right) {
        // TODO: merge 2 sorted interval: [left, mid] and [mid + 1, right]
        // use helper[] to reduce complexity of merging process
        for (int i = left; i <= right; i++) {
            helper[i] = array[i];
        }
        int leftIndex = left;
        int rightIndex = mid + 1; // guaranteed: right >= left + 1, mid >= left + 1
        while (leftIndex <= mid && rightIndex <= right) {
            if (array[leftIndex] <= array[rightIndex]) {
                array[left++] = helper[leftIndex++];
            } else {
                array[left++] = helper[rightIndex++];
            }
        }
        // if left interval not finished comsumming
        while (leftIndex <= mid) {
            array[left++] = helper[leftIndex++];
        }
        // if right interval not finished comsuming: doingt nothing
    }

    public static void main(String[] args) {
        MergeSort sol = new MergeSort();
        int[] res = sol.mergeSort(new int[]{3,5,1,2,4,8});
        System.out.println(Arrays.toString(res));
    }
}

