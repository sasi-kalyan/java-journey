
class One{
    public One(String data){
        System.out.println("Data received: "+data);
    }
}

class Two extends One{
    public Two(String data){
        super(data);
    }
}


public class SuperKeywordConstructors {
    public static void main(String[] args) {
        new Two("packets getting transferred");
    }
}
