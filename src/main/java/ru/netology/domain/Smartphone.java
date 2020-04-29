package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class Smartphone extends Product {
    private String producer;

    public Smartphone() {
    }

    public Smartphone(int id, String name, int price, String producer) {
        super(id, name, price);
        this.producer = producer;
    }

    @Override
    public boolean matches(String search) {
        if (super.matches(search)) {
            return true;
        }
        if (producer.equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
