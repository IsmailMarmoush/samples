package com.marmoush.javasamples.algorithms.sorting;

/**
 * To Run :~/git/java-samples$ ./gradlew -PmainClass=com.marmoush.javasamples.sorting.QuickSort :Algorithms:execute
 */
public class QuickSort {
  public static int partition(int arr[], int left, int right) {
    int tmp;
    int pivot = arr[(left + right) / 2];

    while (left <= right) {
      while (arr[left] < pivot)
        left++;
      while (arr[right] > pivot)
        right--;
      if (left <= right) {
        tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        left++;
        right--;
      }
    }
    return left;
  }

  public static void quickSort(int arr[], int left, int right) {
    int index = partition(arr, left, right);
    if (left < index - 1)
      quickSort(arr, left, index - 1);
    if (index < right)
      quickSort(arr, index, right);
  }

  public static void main(String[] args) {
    int arr[] = {6, 2, 2, 4, 5, 8, 21, 2, 1, 3, 53, 2, 1};
    quickSort(arr, 0, arr.length - 1);
    for (int i : arr) {
      System.out.print(i + "  ");
    }
  }
}
