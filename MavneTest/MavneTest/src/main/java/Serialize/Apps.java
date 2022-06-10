package Serialize;

public class Apps {
    int id;
    int time;

    public Apps(int id, int time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "Apps{" +
                "id=" + id +
                ", time=" + time +
                '}';
    }
}
