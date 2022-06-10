package Serialize;

import java.util.ArrayList;

public class Mobile {
    String name;
    int id;
    ArrayList<String> apps;
    ArrayList<Apps> applist;

    public Mobile(String name, int id, ArrayList<String> apps, ArrayList<Apps> applist) {
        this.name = name;
        this.id = id;
        this.apps = apps;
        this.applist = applist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<String> getApps() {
        return apps;
    }

    public void setApps(ArrayList<String> apps) {
        this.apps = apps;
    }

    public ArrayList<Apps> getApplist() {
        return applist;
    }

    public void setApplist(ArrayList<Apps> applist) {
        this.applist = applist;
    }

    @Override
    public String toString() {
        return "Mobile{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", apps=" + apps +
                ", applist=" + applist +
                '}';
    }
}
