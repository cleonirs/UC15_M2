package jpa;

import util.JPAUtil;
import modelo.Cst;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CstJPA {

    public static void cadastrar(Cst cst) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(cst);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<Cst> listar() {
        List<Cst> listaCst = new ArrayList<Cst>();

        EntityManager manager = JPAUtil.conectar();
        try {
            Query consulta = manager.createQuery("SELECT x FROM cst x");
            listaCst = consulta.getResultList();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return listaCst;
    }

    public static void excluir(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            Cst cst = manager.find(Cst.class, id);
            if (cst != null) {
                manager.remove(cst);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static Cst obter(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            return manager.find(Cst.class, id);
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static void atualizar(Cst cst) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.merge(cst);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }
}
