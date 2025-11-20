package com.example;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void testSaludo() {
        App app = new App();
        // Verificamos que el método saludo() devuelve exactamente "Kaixo DevOps"
        assertEquals("Kaixo DevOps", app.saludo());
    }
}