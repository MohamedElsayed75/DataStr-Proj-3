import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class CreateArray {
    public int[] generateArray(){
        int[] arr = sortedArray(850);
        Random rand = new Random();

        for (int i = 0; i < 850 ; i++) {
            int randomIndexToSwap = rand.nextInt(arr.length);
            int temp = arr[randomIndexToSwap];
            arr[randomIndexToSwap] = arr[i];
            arr[i] = temp;
        }
        return arr;
    }
    public int[] sortedArray(int size){
        int[] arr = new int[size];
        for (int i=0 ; i<size ; i++){
            arr[i] = i/2;
        }
        return arr;
    }

}
