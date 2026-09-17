// Aggregation

class Identity{
    private String job;
    private String cmpny;

    public Identity(String job, String cmpny) {
        this.job = job;
        this.cmpny = cmpny;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getCmpny() {
        return cmpny;
    }

    public void setCmpny(String cmpny) {
        this.cmpny = cmpny;
    }
}

class Person{
    private Identity personIdentity;
    private String name;

    public Person(Identity personIdentity, String name) {
        this.personIdentity = personIdentity;
        this.name = name;
    }

    public Identity getPersonIdentity() {
        return personIdentity;
    }

    public void setPersonIdentity(Identity personIdentity) {
        this.personIdentity = personIdentity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "personIdentity=" + "[" +personIdentity.getJob() + " "+ personIdentity.getCmpny()+" ]"+
                ", name='" + name + '\'' +
                '}';
    }
}

public class Aggregation {
    public static void main(String[] args) {
        Identity identity = new Identity("Developer", "XYZ");
        Person person = new Person(identity, "Kalyan");
        System.out.println(person);
    }
}
