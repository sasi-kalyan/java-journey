package ioc.spring;

import org.springframework.beans.factory.annotation.Autowired;

public class App {

    private Long id;
    private String appname;
    private String desc;

    //@Autowired
    Process process;

    public App(){
        System.out.println("APP >> INSIDE DEFAULT CONSTRUCTOR");
    }

    @Autowired
    public App(Long id, String appname, String desc, Process process) {
        System.out.println("APP >> INSIDE PARAMETERIZED CONSTRUCTOR");
        this.id = id;
        this.appname = appname;
        this.desc = desc;
        this.process = process;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Process getProcess() {
        return process;
    }

    //@Autowired
    public void setProcess(Process process) {
        this.process = process;
        System.out.println("APP >> SETTER METHOD <<PROCESS>>");
    }

    @Override
    public String toString() {
        return "App{" +
                "id=" + id +
                ", appname='" + appname + '\'' +
                ", desc='" + desc + '\'' +
                ", process=" + process +
                '}';
    }
}
