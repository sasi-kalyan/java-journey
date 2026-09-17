import java.util.Arrays;

public class Arrays2Example {
    public static void main(String[] args) {

        //Array Operations

        int[] arr = {10, 20, 30, 40, 50, 60};

        //traversing the array
        for(int i=0;i<arr.length;i++){
            System.out.println("index - "+ i + ": " + arr[i]);
        }

        //enhanced for loop
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println();


        //searching of elements
        int index = Arrays.binarySearch(arr, 11);
        System.out.println("element found at: "+ index);

        //to sort the arrays
        Arrays.sort(arr);

        System.out.println("after sort: "+ arr);

        //copy of array elements
        int[] arr2 = new int[arr.length];

        System.arraycopy(arr, 0, arr2, 0, arr.length);

        for(int i: arr2){
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
