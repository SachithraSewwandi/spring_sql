package model;

/**
 * Created by hsenid on 1/5/16.
 */
public class Customer {
    int custId;
    String name;
    int age;

    public Customer(int custId, String name, int age) {
        this.custId = custId;
        this.age = age;
        this.name = name;
    }

    public int getCustId() {
        return custId;
    }

    public Customer setCustId(int custId) {
        this.custId = custId;
        return this;
    }

    public String getName() {
        return name;
    }

    public Customer setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Customer setAge(int age) {
        this.age = age;
        return this;
    }
}
