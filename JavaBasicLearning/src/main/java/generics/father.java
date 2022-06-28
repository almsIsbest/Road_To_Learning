package generics;

/**
 * @ClassName father
 * @Description
 * @Author alms
 * @Data 2022/6/23 15:52
 **/
public class father<T,D>{
    private T name;
    private D id;

    public father(T name, D id) {
        this.name = name;
        this.id = id;
    }

    public T getName() {
        return name;
    }

    public void setName(T name) {
        this.name = name;
    }

    public D getId() {
        return id;
    }

    public void setId(D id) {
        this.id = id;
    }



}
