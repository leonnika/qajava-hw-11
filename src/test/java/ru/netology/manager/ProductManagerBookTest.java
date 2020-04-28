package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerBookTest {

    private Book firstBook= new Book(1, "Война и мир.том1", 1000, "Л.Н.Толстой", 5000, 2000);
    private Book secondBook= new Book(2, "Война и мир.том2", 1000, "Л.Н.Толстой", 5000, 2000);
    private Book thirdBook = new Book(3, "Война и мир.том3", 1000, "Л.Н.Толстой", 5000, 2000);
    private Book fourthBook= new Book(4, "Война и мир.том4", 1000, "Л.Н.Толстой", 5000, 2000);

    @BeforeEach
    void init() {
    }

    @Test
    void shouldSearcyByBookAutor() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.AddPoduct(firstBook);
        manager.AddPoduct(secondBook);
        manager.AddPoduct(thirdBook);
        manager.AddPoduct(fourthBook);
       Product[] actual = manager.searcyBy("Л.Н.Толстой");
        Product[] expected = new Book[]{firstBook,secondBook,thirdBook,fourthBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearcyByBookName() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.AddPoduct(firstBook);
        manager.AddPoduct(secondBook);
        manager.AddPoduct(thirdBook);
        manager.AddPoduct(fourthBook);
        Product[] actual = manager.searcyBy("Война и мир.том1");
        Product[] expected = new Book[]{firstBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearcyByBookNoСoincidence() {
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.AddPoduct(firstBook);
        manager.AddPoduct(secondBook);
        manager.AddPoduct(thirdBook);
        manager.AddPoduct(fourthBook);
        Product[] actual = manager.searcyBy("Отцы и дети");
        Product[] expected = new Book[]{};
        assertArrayEquals(expected, actual);
    }
}