package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {
    Book book = new Book(1, "Война и мир.том1", 1000, "Л.Н.Толстой", 5000, 2000);

    @Test
    void ShouldMatchesBookAutor() {
        boolean actual = book.matches("Л.Н.Толстой");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void ShouldMatchesBookAutorNoСoincidence() {
        boolean actual = book.matches("А.С.Пушкин");
        boolean expected =  false;
        assertEquals(expected, actual);
    }

    @Test
    void ShouldMatchesBookNameNoСoincidence() {
        boolean actual = book.matches("Война и мир");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void ShouldMatchesBookName() {
        boolean actual = book.matches("Война и мир.том1");
        boolean expected = true;
        assertEquals(expected, actual);
    }
}