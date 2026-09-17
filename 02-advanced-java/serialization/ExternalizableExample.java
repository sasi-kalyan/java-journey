import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

class MyProduct implements Externalizable{

    private String name;
    private double price;
    private int quantity;

    public MyProduct() {
        System.out.println("no-args constructor called");
    }

    public MyProduct(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeDouble(price);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {

    }
}

public class ExternalizableExample {
}
