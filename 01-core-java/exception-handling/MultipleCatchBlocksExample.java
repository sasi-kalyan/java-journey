public class MultipleCatchBlocksExample {
    public static void main(String[] args) {
        int n1 = 10;
        int n2 = 1;

        String str = "";

        String num = "2s";

        try{
            int res = n1/n2;   //may cause ArithmeticException if n2 = 0

            int len = str.length();  //may cause NullPointerException if the string is null

            int con = Integer.parseInt(num); //may cause NumberFormatException if the string is not a numerical
        }catch (ArithmeticException e){
            System.out.println("Cannot divide by Zero");
        }catch (NullPointerException e){
            System.out.println("String is null, can't calcualte length");
        }catch (NumberFormatException e){
            System.out.println("Conversion Incompatible");
        }catch (Exception e){ // generic exception
            System.out.println("Other exception occurred!");
        }
    }
}
