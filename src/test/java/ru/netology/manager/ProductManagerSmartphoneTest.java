package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerSmartphoneTest {
    ProductRepository repository = new ProductRepository();
    ProductManager manager = new ProductManager(repository);
    private Smartphone firstSmartphone = new Smartphone(1, "iPhone8.0", 20000, "Apple");
    private Smartphone secondSmartphone = new Smartphone(2, "iPhone SE", 40000, "Apple");
    private Smartphone thirdSmartphone = new Smartphone(3, "iPhone 11", 100000, "Apple");
    private Smartphone fourthSmartphone = new Smartphone(4, "Samsung Galaxy A50", 25000, "Samsung");

    @BeforeEach
    void init() {
        manager.addPoduct(firstSmartphone);
        manager.addPoduct(secondSmartphone);
        manager.addPoduct(thirdSmartphone);
        manager.addPoduct(fourthSmartphone);
    }

    @Test
    void searcyBySmartphoneName() {
        Product[] actual = manager.searcyBy("Samsung Galaxy A50");
        Product[] expected = new Smartphone[]{fourthSmartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searcyBySmartphoneProducer() {
        Product[] actual = manager.searcyBy("Apple");
        Product[] expected = new Smartphone[]{firstSmartphone, secondSmartphone, thirdSmartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searcyBySmartphoneNoСoincidence() {
        Product[] actual = manager.searcyBy("Nokia");
        Product[] expected = new Smartphone[]{};
        assertArrayEquals(expected, actual);
    }
}