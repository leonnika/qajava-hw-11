package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(1,"iPhone8.0", 20000, "Apple");

    @Test
    void souldMatchesSmartphoneName() {
        boolean actual = smartphone.matches("iPhone8.0");
        boolean expected = true;
        assertEquals(expected, actual);
    }

    @Test
    void souldMatchesSmartphoneNameNoСoincidence() {
        boolean actual = smartphone.matches("iPhone");
        boolean expected = false;
        assertEquals(expected, actual);
    }

    @Test
    void souldMatchesSmartphoneProducer() {
       assertEquals(true, smartphone.matches("Apple"));
    }

    @Test
    void souldMatchesSmartphoneProducerNoСoincidence() {
        assertEquals(false, smartphone.matches("Nokia"));
    }


}