package ru.netology.domain;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Product {
    private int id;
    private String name;
    private int price;

    public boolean matches(String search) {
        if (name.equalsIgnoreCase(search)) {
            return true;
        }
        return false;
    }
}
