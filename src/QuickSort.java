import javax.swing.*;
public class QuickSort {
    public void executeQuickSort(int[] arr, Draw draw, Run run) throws InterruptedException{
        quickSort(arr,0,arr.length-1,draw);
        run.needReset = true;
    }

    public void quickSort(int[] arr, int low, int high, Draw draw) throws InterruptedException{
        Run.noComparisons++;
        if (low < high){
            int pi = partition(arr , low , high, draw);
            quickSort(arr , low, pi-1, draw);
            quickSort(arr, pi+1, high,draw);
        }
    }
    public int partition(int[] arr, int low, int high, Draw draw) throws InterruptedException{
        int pivot = arr[high];
        int i = low-1;
        for (int j = low ; j < high ; j++){
            Run.noComparisons++;
            if (arr[j] <= pivot){
                i++;
                Run.noSwaps++;
                swap(arr, i, j);

                draw.updateArray(arr);
                draw.paintImmediately(0,30,870,532);
                Thread.sleep(1);
            }
        }

        swap(arr, i+1, high);
        draw.updateArray(arr);
        draw.paintImmediately(0,30,870,532);
        Thread.sleep(30);
        return i+1;
    }
    public void swap(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }
}
