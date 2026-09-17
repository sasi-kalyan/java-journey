
class Sun{
    String s = "Sun";
    public void positionSun(){
        System.out.println("Center of the universe");
    }
}

class Venus extends Sun{
    String v = "Venus";
    public void positionVenus(){
        System.out.println("2nd Orbit of the Sun");
    }
}

class Mercury extends Sun{
    String m = "Mercury";
    public void positionMercury(){
        System.out.println("1st Orbit of the sun");
    }
}

class Earth extends Sun{
    String e = "Earth";
    public void positionEarth(){
        System.out.println("3rd orbit of the sun");
    }
}

class Moon extends Earth{
    String moon = "Moon";
    public void positionMoon(){
        System.out.println("Orbit of the Earth");
    }
}



public class HybridInheritence {
    public static void main(String[] args) {
        Mercury obj = new Mercury();
        System.out.println(obj.s+" --> "+obj.m);
        obj.positionMercury();
        obj.positionSun();

        Venus v = new Venus();
        System.out.println(v.s+" --> "+v.v);
        v.positionVenus();
        v.positionSun();

        Earth e = new Earth();
        System.out.println(e.s+" --> "+e.e);
        e.positionEarth();
        e.positionSun();

        Moon m = new Moon();
        System.out.println(m.s+" --> "+m.e+" --> "+m.moon);
        m.positionSun();
        m.positionMoon();
        m.positionEarth();
    }
}
