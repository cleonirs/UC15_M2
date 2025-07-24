package Test;

import jakarta.persistence.EntityManager;

import static org.junit.Assert.*;
import org.junit.Test;
import util.JPAUtil;

public class TestConexao {

    public TestConexao() {
    }

    @Test
    public void testConectar() {
        System.out.println("conectar");
        EntityManager result = JPAUtil.conectar();
        assertNotNull("EntityManager não deve ser nulo", result);
        assertTrue("EntityManager deve estar aberto", result.isOpen());

        if (result.isOpen()) {
            result.close();
        }
    }
}
