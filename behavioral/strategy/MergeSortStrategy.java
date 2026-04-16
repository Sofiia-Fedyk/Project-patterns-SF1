package behavioral.strategy;

import java.util.Arrays;

public class MergeSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] data) {
        mergeSort(data, 0, data.length - 1);
        System.out.println("  MergeSort result:  " + Arrays.toString(data));
    }

    private void mergeSort(int[] data, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(data, left, mid);
            mergeSort(data, mid + 1, right);
            merge(data, left, mid, right);
        }
    }

    private void merge(int[] data, int left, int mid, int right) {
        int[] tmp = Arrays.copyOfRange(data, left, right + 1);
        int i = 0, j = mid - left + 1, k = left;
        while (i <= mid - left && j <= right - left) {
            if (tmp[i] <= tmp[j]) data[k++] = tmp[i++];
            else                  data[k++] = tmp[j++];
        }
        while (i <= mid - left) data[k++] = tmp[i++];
        while (j <= right - left) data[k++] = tmp[j++];
    }

    @Override
    public String getName() {
        return "Merge Sort";
    }
}
