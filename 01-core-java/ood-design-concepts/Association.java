//Association
class Engine{
    private String type;

    public Engine(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void startEngine(){
        System.out.println("Engine started.");
    }
}

class Car{
    private Engine engine;
    private String model;

    public Car(Engine engine, String model) {
        this.engine = engine;
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "engine=" + engine.getType() +
                ", model='" + model + '\'' +
                '}';
    }
}

public class Association {
    public static void main(String[] args) {
        Engine engine = new Engine("V8");
        Car car = new Car(engine, "Mustang");
        System.out.println(car);
    }
}
