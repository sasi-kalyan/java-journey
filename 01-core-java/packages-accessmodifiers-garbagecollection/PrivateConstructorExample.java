
class PrivateConstructor{
    private PrivateConstructor(){
        System.out.println("Private Constructor");
    }
}

public class PrivateConstructorExample {
    public static void main(String[] args){
        //PrivateConstructor obj = new PrivateConstructor();  //error, we cannot create an object outside of the class, if the constructor is private.
    }
}
