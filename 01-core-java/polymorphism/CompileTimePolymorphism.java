public class CompileTimePolymorphism {

    public void sendMsg(int id, String data){
        System.out.println("Message Id: "+id+" "+"Data: "+data);
    }

    public void sendMsg(int id, boolean data){
        System.out.println("Message Id: "+id+" "+"Message Received? "+data);
    }

    public static void main(String[] args) {
        CompileTimePolymorphism obj = new CompileTimePolymorphism();
        obj.sendMsg(10, "Hi<User>, Code it soon.");
        obj.sendMsg(100, true);
    }

}
