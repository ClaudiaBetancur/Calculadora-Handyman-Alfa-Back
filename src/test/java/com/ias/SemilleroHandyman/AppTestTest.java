package com.ias.SemilleroHandyman;

import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
class AppTestTest {

    @Test
    void sumar() {
        AppTest appTest = new AppTest();
        int a = 10;
        int b = 15;

        int result = appTest.sumar(a, b);

        assertEquals(25, result);
    }

    @Test
    void multiplicar() {
    }

    @Test
    void dividir() {
    }
}