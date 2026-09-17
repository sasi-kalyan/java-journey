package ioc.spring;

public class Process {

    private int id;
    private String desc;

    public Process(){
        System.out.println("Process >> INSIDE DEFAULT CONSTRUCTOR");
    }

    public Process(int id, String desc) {
        System.out.println("Process >> INSIDE PARAMETERIZED CONSTRUCTOR");
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Process{" +
                "id=" + id +
                ", desc='" + desc + '\'' +
                '}';
    }
}
