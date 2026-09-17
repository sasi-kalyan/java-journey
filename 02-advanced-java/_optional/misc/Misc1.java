public class Misc1 {
    public static void main(String[] args) {

        String day = "Monday";

        //switch can be used as expression -- introduced in java 12+
        String result = switch (day){
            case "Monday", "Tuesday" -> "Yes Monday or Tuesday!!";
            default -> "Invalid day!!";
        };

        System.out.println(result);


        //Labels in Java

        outerLoop:
        for(int i=0;i<10;i++){
            innerLoop:
            for(int j=0;j<10;j++){
                if(i==0 && j == 5){
                    System.out.println("outer loop breaking shortly...terminated!!");
                    break outerLoop;
                }
            }
        }
    }
}
