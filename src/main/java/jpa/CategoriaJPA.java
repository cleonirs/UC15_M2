package jpa;

import util.JPAUtil;
import modelo.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CategoriaJPA {

    public static void cadastrar(Categoria categoria) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(categoria);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<Categoria> listar() {
        List<Categoria> listaCategoria = new ArrayList<Categoria>();

        EntityManager manager = JPAUtil.conectar();
        try {
            Query consulta = manager.createQuery("SELECT x FROM categoria x");
            listaCategoria = consulta.getResultList();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return listaCategoria;
    }

    public static void excluir(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            Categoria categoria = manager.find(Categoria.class, id);
            if (categoria != null) {
                manager.remove(categoria);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static Categoria obter(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            return manager.find(Categoria.class, id);
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static void atualizar(Categoria categoria) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.merge(categoria);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }
}
