package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    private Book firstBook = new Book(1, "Война и мир.том1", 1000, "Л.Н.Толстой");
    private Book secondBook = new Book(2, "Война и мир.том2", 1000, "Л.Н.Толстой");
    ProductRepository repository = new ProductRepository();
    @Test
    void shouldCheckMetodsRepositiry() {
        repository.save(firstBook);
        repository.save(secondBook);
        repository.removeById(1);
        Product[] actual = repository.findAll();
        Product[] expected = new Product[]{secondBook};
        assertArrayEquals(expected, actual);
    }

   }