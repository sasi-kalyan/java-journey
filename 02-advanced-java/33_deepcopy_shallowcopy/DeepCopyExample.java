class Address1 implements Cloneable{
    String city;

    public Address1(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Employee2 implements Cloneable{
    int id;
    String name;
    Address1 address;

    public Employee2(int id, String name, Address1 address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    protected Employee2 clone() throws CloneNotSupportedException {
        Employee2 copy =  (Employee2) super.clone();
        copy.address = (Address1) this.address.clone();
        return copy;
    }
}

public class DeepCopyExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        Address1 address1 = new Address1("Bangalore");

        Employee2 employee1 = new Employee2(1, "user1", address1);
        Employee2 employee2 = employee1.clone();

        System.out.println(employee1 == employee2);
        System.out.println(employee1.address == employee2.address);

    }
}
