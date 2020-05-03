package ru.netology.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SmartphoneTest {
    Smartphone smartphone = new Smartphone(1, "iPhone8.0", 20000, "Apple");

    @Test
    void shouldMatchesSmartphoneName() {
        assertTrue(smartphone.matches("iPhone8.0"));
    }

    @Test
    void shouldMatchesSmartphoneNameNoСoincidence() {
        assertFalse(smartphone.matches("iPhone"));
    }

    @Test
    void shouldMatchesSmartphoneProducer() {
        assertTrue(smartphone.matches("Apple"));
    }

    @Test
    void shouldMatchesSmartphoneProducerNoСoincidence() {
        assertFalse(smartphone.matches("Nokia"));
    }


}