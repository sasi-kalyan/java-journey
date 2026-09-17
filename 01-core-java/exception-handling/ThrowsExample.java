import java.io.IOException;

public class ThrowsExample{

    public void method(String filePath) throws IOException{
        if(filePath == null){
            throw new IOException("File path not found");
        }else{
            System.out.println("Read file path: "+filePath);
        }
    }

    public static void main(String[] args){
        ThrowsExample file = new ThrowsExample();
        try{
            file.method(null);
        }catch(IOException e){
            System.out.println(e);
        }
    }
}

/*
    java.io.IOException: File path not found
*/