package jpa;

import util.JPAUtil;
import modelo.PisCofins;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class PisCofinsJPA {

    public static void cadastrar(PisCofins pis) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(pis);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<PisCofins> listar() {
        List<PisCofins> listaPis = new ArrayList<PisCofins>();

        EntityManager manager = JPAUtil.conectar();
        try {
            Query consulta = manager.createQuery("SELECT x FROM pis x");
            listaPis = consulta.getResultList();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return listaPis;
    }

    public static void excluir(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            PisCofins pis = manager.find(PisCofins.class, id);
            if (pis != null) {
                manager.remove(pis);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static PisCofins obter(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            return manager.find(PisCofins.class, id);
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static void atualizar(PisCofins pis) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.merge(pis);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }
}
