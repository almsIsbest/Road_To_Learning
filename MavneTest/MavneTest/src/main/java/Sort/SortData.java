package Sort;

public class SortData {
    int first = 0;
    int second = 0;
    int third = 0;

    public SortData(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public int getFirst() {
        return first;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getThird() {
        return third;
    }

    public void setThird(int third) {
        this.third = third;
    }

    @Override
    public String toString() {
        return "SortData{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                '}';
    }
}
