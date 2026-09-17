import java.util.Arrays;

public class ArraysExample {

    /*
            Arrays: These are the fixed sized, ordered collection of elements which can store the same
            data typed values inside it (it is homogeneous data structure)
            1. Fixed size
            2. Ordered
            3. Index based

            Types of Arrays:
            1. 1D arrays
            2. 2D arrays/ Multi-dimensional arrays
     */


    public static void main(String[] args) {

        //single dimensional arrays
        int[] num = {10, 2, 1, 4, 5, -2};

        //accessing of elements
        System.out.println("index 0: "+ num[0]);

        //multi-dimensional arrays
        int[][] mat = {
                {1, 5, 7},
                {3, 4, 5},
                {7, 10, 12}
        };

        //print matrix
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        //Arrays class
        //To sort the arrys
        Arrays.sort(num);
        System.out.println("after sorting....");
        for (int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
        System.out.println();

        //search operation
        int index = Arrays.binarySearch(num, -2);
        System.out.println("index found at: "+ index);

        //fill method
        Arrays.fill(num, -1);
        System.out.println("after filling");
        for (int i=0;i<num.length;i++){
            System.out.print(num[i]+" ");
        }
    }
}
