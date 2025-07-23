package jpa;

import util.JPAUtil;
import modelo.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class ProdutoJPA {

    public static void cadastrar(Produto produto) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.persist(produto);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static List<Produto> listar() {
        List<Produto> listaProduto = new ArrayList<Produto>();

        EntityManager manager = JPAUtil.conectar();
        try {
            Query consulta = manager.createQuery("SELECT x FROM produto x");
            listaProduto = consulta.getResultList();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
        return listaProduto;
    }

    public static void excluir(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            Produto produto = manager.find(Produto.class, id);
            if (produto != null) {
                manager.remove(produto);
            }
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static Produto obter(int id) {
        EntityManager manager = JPAUtil.conectar();
        try {
            return manager.find(Produto.class, id);
        } finally {
            JPAUtil.desconectar();
        }
    }

    public static void atualizar(Produto produto) {
        EntityManager manager = JPAUtil.conectar();
        try {
            manager.getTransaction().begin();
            manager.merge(produto);
            manager.getTransaction().commit();
        } catch (Exception e) {
            manager.getTransaction().rollback();
            throw e;
        } finally {
            JPAUtil.desconectar();
        }
    }
}
