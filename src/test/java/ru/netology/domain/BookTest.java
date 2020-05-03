package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookTest {
    Book book = new Book(1, "Война и мир.том1", 1000, "Л.Н.Толстой");

    @Test
    void shouldMatchesBookAutor() {
        assertTrue(book.matches("Л.Н.Толстой"));
    }

    @Test
    void shouldMatchesBookAutorNoСoincidence() {
        assertFalse(book.matches("А.С.Пушкин"));
    }

    @Test
    void shouldMatchesBookNameNoСoincidence() {
        assertFalse(book.matches("Война и мир"));
    }

    @Test
    void shouldMatchesBookName() {
        assertTrue(book.matches("Война и мир.том1"));
    }
}