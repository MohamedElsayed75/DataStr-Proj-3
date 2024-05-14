import java.util.Random;

public class Main {
    static long[] swaps = new long[]{0,0,0,0,0,0,0,0,0};
    static long[] comparisons = new long[]{0,0,0,0,0,0,0,0,0};
    public static void main(String[] args) {

        int size = 10000;



//        int[] sortedArray = sortedArray(size);
//        int[] randomArray = randomArray(size);
//        int[] invertedArray = invertedArray(size);



        System.out.println("Counting sort: o(k+n) for all cases");

        int[] linearRandomArray = randomArray(size);

        long sLinearRandom = System.nanoTime();
        countingSort(linearRandomArray,0);
        long eLinearRandom = System.nanoTime();
        System.out.println("Linear sort + random array  : ") ;
        System.out.println("Time(mS): "+ (eLinearRandom-sLinearRandom)/1000000.0 + "    Swaps: " + swaps[0] + "    Comparisons: " + comparisons[0]);



        int[] linearSortedArray = sortedArray(size);

        long sLinearSorted = System.nanoTime();
        countingSort(linearSortedArray,1);
        long eLinearSorted = System.nanoTime();
        System.out.println("Linear sort + sorted array  : ");
        System.out.println("Time(mS): "+ (eLinearSorted-sLinearSorted)/1000000.0 +"    Swaps: " + swaps[1] + "    Comparisons: " + comparisons[1]);



        int[] linearInvertedArray = invertedArray(size);

        long sLinearInverted = System.nanoTime();
        countingSort(linearInvertedArray,2);
        long eLinearInverted = System.nanoTime();
        System.out.println("Linear sort + inverted array: ");
        System.out.println("Time(mS): "+(eLinearInverted-sLinearInverted)/1000000.0+"    Swaps: " + swaps[2] + "    Comparisons: " + comparisons[2]);




        System.out.println();

        System.out.println("Quick sort: o(n log n) for random arrays, o(n^2) for sorted or inverted arrays ");


        int[] quickRandomArray = randomArray(size);

        long sQuickRandom = System.nanoTime();
        quickSort(quickRandomArray, 0, size-1, 3);
        long eQuickRandom = System.nanoTime();
        System.out.println("Quick sort + random array   : ");
        System.out.println("Time(mS): "+(eQuickRandom-sQuickRandom)/1000000.0+"    Swaps: " + swaps[3] + "    Comparisons: " + comparisons[3]);


        int[] quickSortedArray = sortedArray(size);

        long sQuickSorted = System.nanoTime();
        quickSort(quickSortedArray, 0, size-1, 4);
        long eQuickSorted = System.nanoTime();
        System.out.println("Quick sort + sorted array   : ");
        System.out.println("Time(mS): "+ (eQuickSorted-sQuickSorted)/1000000.0+"    Swaps: " + swaps[4] + "    Comparisons: " + comparisons[4]);


        int[] quickInvertedArray = invertedArray(size);

        long sQuickInverted = System.nanoTime();
        quickSort(quickInvertedArray, 0, size-1, 5);
        long eQuickInverted = System.nanoTime();
        System.out.println("Quick sort + inverted array : ");
        System.out.println("Time(mS): "+ (eQuickInverted - sQuickInverted)/1000000.0 +"    Swaps: " + swaps[5] + "    Comparisons: " + comparisons[5]);




        System.out.println();

        System.out.println("Bubble sort: o(n) is array is sorted, o(n^2) otherwise");

        int[] bubbleRandomArray = randomArray(size);

        long sBubbleRandom = System.nanoTime();
        bubbleSort(bubbleRandomArray, 6);
        long eBubbleRandom = System.nanoTime();
        System.out.println("Bubble sort + random array  : ");
        System.out.println("Time(mS): "+ (eBubbleRandom - sBubbleRandom)/1000000.0+"    Swaps: " + swaps[6] + "    Comparisons: " + comparisons[6]);



        int[] bubbleSortedArray = sortedArray(size);

        long sBubbleSorted = System.nanoTime();
        bubbleSort(bubbleSortedArray, 7);
        long eBubbleSorted = System.nanoTime();
        System.out.println("Bubble sort + sorted array  : ");
        System.out.println("Time(mS): "+ (eBubbleSorted - sBubbleSorted)/1000000.0 +"    Swaps: " + swaps[7] + "    Comparisons: " + comparisons[7]);



        int[] bubbleInvertedArray = invertedArray(size);

        long sBubbleInverted = System.nanoTime();
        bubbleSort(bubbleInvertedArray, 8);
        long eBubbleInverted = System.nanoTime();
        System.out.println("Bubble sort + inverted array: ");
        System.out.println("Time(mS): " + (eBubbleInverted - sBubbleInverted)/1000000.0 +"    Swaps: " + swaps[8] + "    Comparisons: " + comparisons[8]);


    }



    public static int[] sortedArray(int size){
        int[] arr = new int[size];
        for (int i=0 ; i<size ; i++){
            arr[i] = i+1 ;
        }
        return arr;
    }


        public static int[] randomArray(int size){
            int[] arr = sortedArray(size);
            Random rand = new Random();

            for (int i = 0; i < size ; i++) {
                int randomIndexToSwap = rand.nextInt(arr.length);
                int temp = arr[randomIndexToSwap];
                arr[randomIndexToSwap] = arr[i];
                arr[i] = temp;
            }
            return arr;

    }
    public static int[] invertedArray(int size){
        int[] arr = new int[size];
        int j = 0;
        for (int i=size ; i>=1 ; i--){
            arr[j] = i;
            j++;
        }
        return arr;
    }




    // Best case o(nlogn) -> random numbers
    // Worst case o(n^2) -> sorted inversely or not
    public static void quickSort(int[] arr, int low, int high, int INDEX){
        comparisons[INDEX]++;
        if (low < high){
            int pi = partition(arr , low , high, INDEX);
            quickSort(arr , low, pi-1, INDEX);
            quickSort(arr, pi+1, high, INDEX);
        }
    }
    public static int partition(int[] arr, int low, int high, int INDEX){
        int pivot = arr[high];
        int i = low-1;
        for (int j = low ; j < high ; j++){
            comparisons[INDEX]++;
            if (arr[j] <= pivot){
                i++;
                swaps[INDEX]++;
                swap(arr, i, j);
            }
        }
        swaps[INDEX]++;
        swap(arr, i+1, high);
        return i+1;
    }
    public static void swap(int[] arr, int low, int high){
        int temp = arr[low];
        arr[low] = arr[high];
        arr[high] = temp;
    }



    public static void countingSort(int[] arr, int INDEX){
        int max = getMax(arr, INDEX);
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

    // works only for +ve ints
    // fastest known sorting algo
    // o(n+k) where k is the max element

    public static int getMax(int[] arr, int INDEX){
        int max = -1 ;
        for (int i : arr){
            comparisons[INDEX]++;
            if (i > max){
                max=i;
            }
        }
        return max;
    }


    //Bubble sort average/worst o(n^2)
    //            Best o(n) if sorted

    public static void bubbleSort(int[] arr, int INDEX){

        for (int p =0; p<arr.length ;p++){
            int changes = 0;
            for(int i = 0 ; i<arr.length-1 ; i++){
                comparisons[INDEX]++;
                if(arr[i]>arr[i+1]){
                    changes++;

                    swaps[INDEX]++;
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
            if (changes == 0) return;
        }
    }


}