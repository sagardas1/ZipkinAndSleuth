package com.example.OrderService.OrderService.DTO;

/**
 * Created by sagardas on 18/02/24.
 */
public class Order {

    String name;
    String type;
    int id;

    public Order(String name, String type, int id) {
        this.name = name;
        this.type = type;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
