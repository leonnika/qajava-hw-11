package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductManagerBookTest {
    @Mock  // подставляет заглушку вместо реальной реализации
    ProductRepository repository;
    @InjectMocks  // подставляет заглушку в конструктор
    ProductManager manager = new ProductManager(repository);
    private Book firstBook = new Book(1, "Война и мир.том1", 1000, "Л.Н.Толстой", 5000, 2000);
    private Book secondBook = new Book(2, "Война и мир.том2", 1000, "Л.Н.Толстой", 5000, 2000);
    private Book thirdBook = new Book(3, "Война и мир.том3", 1000, "Л.Н.Толстой", 5000, 2000);
    private Book fourthBook = new Book(4, "Война и мир.том4", 1000, "Л.Н.Толстой", 5000, 2000);

    @Test
    void shouldSearcyByBookAutor() {
        Book[] returned = new Book[]{firstBook, secondBook, thirdBook, fourthBook};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Л.Н.Толстой");
        Product[] expected = new Book[]{firstBook, secondBook, thirdBook, fourthBook};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void shouldSearcyByBookName() {
        Book[] returned = new Book[]{firstBook, secondBook, thirdBook, fourthBook};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Война и мир.том1");
        Product[] expected = new Book[]{firstBook};
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearcyByBookNoСoincidence() {
        Book[] returned = new Book[]{firstBook, secondBook, thirdBook, fourthBook};
        doReturn(returned).when(repository).findAll();
        manager.remById(1);
        Product[] actual = manager.searcyBy("Отцы и дети");
        Product[] expected = new Book[]{};
        assertArrayEquals(expected, actual);
    }
}