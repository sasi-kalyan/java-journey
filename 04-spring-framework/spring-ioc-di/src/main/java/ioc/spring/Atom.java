package ioc.spring;

public class Atom {
    private int atomicNumber;
    private double atomicMass;
    private int atomicRadius;
    private double density;

    //default constructor
    public Atom(){
    }

    public Atom(int atomicNumber, double atomicMass, int atomicRadius, double density) {
        this.atomicNumber = atomicNumber;
        this.atomicMass = atomicMass;
        this.atomicRadius = atomicRadius;
        this.density = density;
    }

    public int getAtomicNumber() {
        return atomicNumber;
    }

    public void setAtomicNumber(int atomicNumber) {
        this.atomicNumber = atomicNumber;
    }

    public double getAtomicMass() {
        return atomicMass;
    }

    public void setAtomicMass(double atomicMass) {
        this.atomicMass = atomicMass;
    }

    public int getAtomicRadius() {
        return atomicRadius;
    }

    public void setAtomicRadius(int atomicRadius) {
        this.atomicRadius = atomicRadius;
    }

    public double getDensity() {
        return density;
    }

    public void setDensity(double density) {
        this.density = density;
    }

    @Override
    public String toString() {
        return "Atom{" +
                "atomicNumber=" + atomicNumber +
                ", atomicMass=" + atomicMass +
                ", atomicRadius=" + atomicRadius +
                ", density=" + density +
                '}';
    }
}
