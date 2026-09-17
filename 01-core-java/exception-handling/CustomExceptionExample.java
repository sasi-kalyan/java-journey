public class CustomExceptionExample {

    public static void checkObesity(int bmi){
        try {
            if (bmi > 30) {
                throw new IncompatibleException(" :Person is Overweighted");
            }
        }catch (IncompatibleException e){
            System.out.println(e);
        }
    }
    public static void main(String[] args) {
        int bmi = 45;
        checkObesity(bmi);
    }
}
