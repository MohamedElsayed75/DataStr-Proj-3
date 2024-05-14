public class CountingSort {
    public void countingSort(int[] arr){
        int max = getMax(arr);
        int[] count = new int[max+1];
        for (int num : arr){
            count[num]++;
        }
        for (int i=1 ; i<=max ; i++){
            count[i] += count[i-1];
        }
        int[] output = new int[arr.length];
        for (int i=arr.length-1; i>=0 ;i--  ){
            output[count[arr[i]]-1] = arr[i];
            count[arr[i]]--;
        }
        for (int i=0; i<arr.length;i++){
            arr[i]=output[i];
        }
    }

    public int getMax(int[] arr){
        int max = -1 ;
        for (int i : arr){
            if (i > max){
                max=i;
            }
        }
        return max;
    }
}
