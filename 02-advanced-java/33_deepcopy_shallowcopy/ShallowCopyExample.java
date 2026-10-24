
class Address implements Cloneable{
    String city;
}

class Employee1 implements Cloneable{
    int id;
    String name;
    Address address;

    public Employee1(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Override
    protected Employee1 clone() throws CloneNotSupportedException {
        return (Employee1) super.clone();
    }
}


public class ShallowCopyExample {

    /*
            Shallow copy: the copy technique, that creates a new object but copying values
            of the primitive types, but for fields that are references to other objects,
            it copies ONLY the reference (the pointer).
     */

    public static void main(String[] args) throws CloneNotSupportedException {

        Address address = new Address();
        address.city = "New York";

        Employee1 employee1 = new Employee1(10, "naruto", address);
        Employee1 employee2 = employee1.clone();

        System.out.println("Employee-1 details");
        System.out.println("Employee Id: " + employee1.id + " Employee name: " + employee1.name + " Employee address: " + employee1.address.city);


        System.out.println("Employee-2 details");
        System.out.println("Employee Id: " + employee2.id + " Employee name: " + employee2.name + " Employee address: " + employee2.address.city);

        //lets check e1 == e2
        System.out.println(employee1 == employee2);

        employee2.address.city = "Konoha";
        employee2.id = 100;
        employee2.name = "Light Yagami";

        System.out.println("--->Employee 2 Changed, Lets see...");

        System.out.println("Employee-1 details");
        System.out.println("Employee Id: " + employee1.id + " Employee name: " + employee1.name + " Employee address: " + employee1.address.city);

        System.out.println("Employee-2 details");
        System.out.println("Employee Id: " + employee2.id + " Employee name: " + employee2.name + " Employee address: " + employee2.address.city);

    }
}
