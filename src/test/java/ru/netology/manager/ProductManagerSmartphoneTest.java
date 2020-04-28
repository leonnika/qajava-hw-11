package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Smartphone;
import ru.netology.domain.Product;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerSmartphoneTest {
    private Smartphone firstSmartphone = new Smartphone(1,"iPhone8.0", 20000, "Apple");
    private Smartphone secondSmartphone;
    private Smartphone thirdSmartphone;
    private Smartphone fourthSmartphone;


    @Test
    void searcyBySmartphoneName() {
        secondSmartphone = new Smartphone(2, "iPhone SE", 40000, "Apple");
        thirdSmartphone = new Smartphone(3, "iPhone 11", 100000, "Apple");
        fourthSmartphone = new Smartphone(4, "Samsung Galaxy A50", 25000, "Samsung");
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.AddPoduct(firstSmartphone);
        manager.AddPoduct(secondSmartphone);
        manager.AddPoduct(thirdSmartphone);
        manager.AddPoduct(fourthSmartphone);
        Product[] actual = manager.searcyBy("Samsung Galaxy A50");
        Product[] expected = new Smartphone[]{fourthSmartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searcyBySmartphoneProducer() {
        secondSmartphone = new Smartphone(2, "iPhone SE", 40000, "Apple");
        thirdSmartphone = new Smartphone(3, "iPhone 11", 100000, "Apple");
        fourthSmartphone = new Smartphone(4, "Samsung Galaxy A50", 25000, "Samsung");
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.AddPoduct(firstSmartphone);
        manager.AddPoduct(secondSmartphone);
        manager.AddPoduct(thirdSmartphone);
        manager.AddPoduct(fourthSmartphone);
        Product[] actual = manager.searcyBy("Apple");
        Product[] expected = new Smartphone[]{firstSmartphone,secondSmartphone,thirdSmartphone};
        assertArrayEquals(expected, actual);
    }

    @Test
    void searcyBySmartphoneNoСoincidence() {
        secondSmartphone = new Smartphone(2, "iPhone SE", 40000, "Apple");
        thirdSmartphone = new Smartphone(3, "iPhone 11", 100000, "Apple");
        fourthSmartphone = new Smartphone(4, "Samsung Galaxy A50", 25000, "Samsung");
        ProductRepository repository = new ProductRepository();
        ProductManager manager = new ProductManager(repository);
        manager.AddPoduct(firstSmartphone);
        manager.AddPoduct(secondSmartphone);
        manager.AddPoduct(thirdSmartphone);
        manager.AddPoduct(fourthSmartphone);
        Product[] actual = manager.searcyBy("Nokia");
        Product[] expected = new Smartphone[]{};
        assertArrayEquals(expected, actual);
    }
}