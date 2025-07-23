package jpa;

import util.JPAUtil;
import modelo.Ncm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class NcmJPA {

    public static void cadastrar(Ncm ncm) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(ncm);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<Ncm> listar() {
        List<Ncm> listaNcm = new ArrayList<Ncm>();

        EntityManager manager = JPAUtil.conectar();
        try {
            Query consulta = manager.createQuery("SELECT x FROM ncm x");
            listaNcm = consulta.getResultList();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return listaNcm;
    }

    public static void excluir(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            Ncm ncm = manager.find(Ncm.class, id);
            if (ncm != null) {
                manager.remove(ncm);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static Ncm obter(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            return manager.find(Ncm.class, id);
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static void atualizar(Ncm ncm) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.merge(ncm);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }
}
