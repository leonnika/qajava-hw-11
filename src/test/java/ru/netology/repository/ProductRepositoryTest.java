package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private Product first = new Product(1,"iPhone8.0", 20000);
    private Product second = new Product(2,"ABC",500);
    @Test
    void shouldRemoveById() {
        ProductRepository repository = new ProductRepository();
        repository.save(first);
        repository.save(second);
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{second};
        assertArrayEquals(expected, actual);

    }
}