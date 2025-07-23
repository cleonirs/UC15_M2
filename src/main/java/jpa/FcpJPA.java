package jpa;

import util.JPAUtil;
import modelo.Fcp;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class FcpJPA {

    public static void cadastrar(Fcp fcp) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(fcp);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<Fcp> listar() {
        List<Fcp> listaFcp = new ArrayList<Fcp>();

        EntityManager manager = JPAUtil.conectar();
        try {
            Query consulta = manager.createQuery("SELECT x FROM fcp x");
            listaFcp = consulta.getResultList();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return listaFcp;
    }

    public static void excluir(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            Fcp fcp = manager.find(Fcp.class, id);
            if (fcp != null) {
                manager.remove(fcp);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static Fcp obter(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            return manager.find(Fcp.class, id);
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static void atualizar(Fcp fcp) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.merge(fcp);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }
}
