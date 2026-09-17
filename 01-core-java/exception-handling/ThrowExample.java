public class ThrowExample {

    public static void checkAgeWeight(int age, int weight){
        try{
            if(age <= 18 && weight >= 40 ){
                throw new ArithmeticException("Student is over weighted!");
            }
        }catch (ArithmeticException e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        int age = 18;
        int weight = 40;
        checkAgeWeight(age, weight);
    }
}
