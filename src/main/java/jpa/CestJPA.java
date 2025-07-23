package jpa;

import util.JPAUtil;
import modelo.Cest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CestJPA {

    public static void cadastrar(Cest cest) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(cest);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<Cest> listar() {
        List<Cest> listaCest = new ArrayList<Cest>();

        EntityManager manager = JPAUtil.conectar();
        try {
            Query consulta = manager.createQuery("SELECT x FROM cest x");
            listaCest = consulta.getResultList();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return listaCest;
    }

    public static void excluir(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            Cest cest = manager.find(Cest.class, id);
            if (cest != null) {
                manager.remove(cest);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static Cest obter(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            return manager.find(Cest.class, id);
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static void atualizar(Cest cest) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.merge(cest);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }
}
