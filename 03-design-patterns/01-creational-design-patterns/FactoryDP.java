
interface Vehicle{
    void drive();
}


class Truck implements Vehicle{

    @Override
    public void drive() {
        System.out.println("Truck drive.");
    }
}

class Bike implements Vehicle{

    @Override
    public void drive() {
        System.out.println("Bike drive.");
    }
}

/*
        Factory: is a creational design pattern the hides the implementation / object process.
        Define a central interface for creating an object but let the subclasses decide which
        class to instantiate.
*/

class VehicleFactory{

    public static Vehicle getVehicleObject(String vehicleName){

        return switch (vehicleName){
            case "truck" -> new Truck();
            case "bike" -> new Bike();
            default -> throw new IllegalStateException("Unexpected value: " + vehicleName);
        };
    }

}


public class FactoryDP{
    public static void main(String[] args) {

        Truck truckObj = (Truck) VehicleFactory.getVehicleObject("truck");
        Bike bikeObj = (Bike) VehicleFactory.getVehicleObject("bike");

        truckObj.drive();
        bikeObj.drive();
    }
}