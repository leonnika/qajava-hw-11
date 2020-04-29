package ru.netology.manager;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class ProductManagerSmartphoneTest {
    @Mock
    ProductRepository repository;
    @InjectMocks
    ProductManager manager = new ProductManager(repository);
    private Smartphone firstSmartphone = new Smartphone(1, "iPhone8.0", 20000, "Apple");
    private Smartphone secondSmartphone = new Smartphone(2, "iPhone SE", 40000, "Apple");
    private Smartphone thirdSmartphone = new Smartphone(3, "iPhone 11", 100000, "Apple");
    private Smartphone fourthSmartphone = new Smartphone(4, "Samsung Galaxy A50", 25000, "Samsung");

    @Test
    void searcyBySmartphoneName() {
        Smartphone[] returned = new Smartphone[]{firstSmartphone, secondSmartphone, thirdSmartphone, fourthSmartphone};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Samsung Galaxy A50");
        Product[] expected = new Smartphone[]{fourthSmartphone};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void searcyBySmartphoneProducer() {
        Smartphone[] returned = new Smartphone[]{firstSmartphone, secondSmartphone, thirdSmartphone, fourthSmartphone};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Apple");
        Product[] expected = new Smartphone[]{firstSmartphone, secondSmartphone, thirdSmartphone};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }

    @Test
    void searcyBySmartphoneNoСoincidence() {
        Smartphone[] returned = new Smartphone[]{firstSmartphone, secondSmartphone, thirdSmartphone, fourthSmartphone};
        doReturn(returned).when(repository).findAll();
        Product[] actual = manager.searcyBy("Nokia");
        Product[] expected = new Smartphone[]{};
        assertArrayEquals(expected, actual);
        verify(repository).findAll();
    }
}