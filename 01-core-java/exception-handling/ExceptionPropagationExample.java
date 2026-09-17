public class ExceptionPropagationExample {

    public static int method2(int[] arr){
        int res = arr[arr.length];     // exception? yes: array index out of bounds , but not handled here, exception propagtes the called method
        return res;
    }

    public static void method1(int n){   // exception comes here
        int[] arr = new int[n];
        for(int i = 0;i <n ;i++){
            arr[i] = 5;
        }

        method2(arr);   // here also not handled, exception propagates to the main
    }

    public static void main(String[] args) {
        int n = 5;

        try{
            method1(n);     // exception handled here.
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
