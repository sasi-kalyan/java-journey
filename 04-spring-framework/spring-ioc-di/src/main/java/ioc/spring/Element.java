package ioc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Element {
    private String name;
    private int valency;
    private int energyLevels;

    //@Autowired
    Atom atom;  //-- this instance variable used for to test autowiring

    public Element() {
        System.out.println("Invoked Default constructor");
    }

    @Autowired(required = true)
    public Element(String name, int valency, int energyLevels, Atom atom) {
        this.name = name;
        this.valency = valency;
        this.energyLevels = energyLevels;
        this.atom = atom;
        System.out.println("Autowiring invoked in parameterized-constructor...");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValency() {
        return valency;
    }

    public void setValency(int valency) {
        this.valency = valency;
    }

    public int getEnergyLevels() {
        return energyLevels;
    }

    public void setEnergyLevels(int energyLevels) {
        this.energyLevels = energyLevels;
    }

    public Atom getAtom() {
        return atom;
    }

    //@Autowired(required = true)
    public void setAtom(Atom atom) {
        this.atom = atom;
        System.out.println("Autowiring invoked in setter...");
    }

    @PostConstruct
    public void postConstruct(){
        System.out.println("Element Bean Created...");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("Element Bean Destroyed...");
    }

    @Override
    public String toString() {
        return "Element{" +
                "name='" + name + '\'' +
                ", valency=" + valency +
                ", energyLevels=" + energyLevels +
                ", atom=" + atom +
                '}';
    }
}
