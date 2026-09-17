
class EncapsulationTest{
    private int id;
    private String name;
    private float rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "EncapsulationTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rating=" + rating +
                '}';
    }
}

public class EncapsulationExample {
    public static void main(String[] args) {
        EncapsulationTest obj = new EncapsulationTest();
        obj.setId(100);
        obj.setName("Kalyan");
        obj.setRating(9.8f);

        System.out.println(obj);

    }
}
