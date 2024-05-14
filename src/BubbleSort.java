import javax.swing.*;

public class BubbleSort extends JPanel {
    public void executeBubbleSort(int[] arr ,Draw draw,Run run) throws InterruptedException{
        for (int p =0; p<arr.length ;p++){
            int changes = 0;
            for(int i = 0 ; i<arr.length-1 ; i++){
                Run.noComparisons++;
                if(arr[i]>arr[i+1]){
                    changes++;
                    Run.noSwaps++;
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;

                    Thread.sleep(1);
                    draw.removeAll();
                    draw.updateArray(arr);

                    draw.paintImmediately(0,30,870,622 );

                }
            }
            if (changes == 0) return;
        }
        run.needReset = true;
    }

}
