package EqualsAndHashCode;

import java.util.HashSet;
import java.util.Objects;

/**
 * @ClassName product
 * @Description TODO
 * @Author alms
 * @Data 2022/3/1 20:54
 **/
public class product {
    private int id;
    private String name;

    public product(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        product product = (product) o;
        return id == product.id ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public static void main(String[] args) {
        product car = new product(1, "car");
        product bike = new product(1, "bike");

        System.out.println(car.equals(bike));
        HashSet<product> products = new HashSet<>();
        products.add(car);
        products.add(bike);
        System.out.println(products.size());
    }
}
