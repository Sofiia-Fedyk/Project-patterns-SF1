package behavioral.strategy;

import java.util.Arrays;

public class QuickSortStrategy implements SortStrategy {

    @Override
    public void sort(int[] data) {
        quickSort(data, 0, data.length - 1);
        System.out.println("  QuickSort result:  " + Arrays.toString(data));
    }

    private void quickSort(int[] data, int low, int high) {
        if (low < high) {
            int pivot = partition(data, low, high);
            quickSort(data, low, pivot - 1);
            quickSort(data, pivot + 1, high);
        }
    }

    private int partition(int[] data, int low, int high) {
        int pivot = data[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (data[j] <= pivot) {
                i++;
                int tmp = data[i];
                data[i] = data[j];
                data[j] = tmp;
            }
        }
        int tmp = data[i + 1];
        data[i + 1] = data[high];
        data[high] = tmp;
        return i + 1;
    }

    @Override
    public String getName() {
        return "Quick Sort";
    }
}
