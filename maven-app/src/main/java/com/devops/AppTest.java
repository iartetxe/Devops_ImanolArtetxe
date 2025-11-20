package com.devops;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {
    @Test
    public void testSaludo() {
        App app = new App();
        assertEquals("Kaixo DevOps", app.saludo());
    }
}