package io.beans;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class App {

    private int id;
    private String appname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppname() {
        return appname;
    }

    public void setAppname(String appname) {
        this.appname = appname;
    }

    @Override
    public String toString() {
        return "App{" +
                "id=" + id +
                ", appname='" + appname + '\'' +
                '}';
    }
}
