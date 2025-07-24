package Test;

import jpa.ProdutoJPA;
import modelo.Produto;
import static org.junit.Assert.*;
import org.junit.Test;

public class TestExclusaoProduto {

    public TestExclusaoProduto() {
    }

    @Test
    public void testExcluirProdutoExistente() {
        int idProduto = 48; // id previamente cadastrado

        ProdutoJPA.excluir(idProduto); // método void

        Produto produto = ProdutoJPA.obter(idProduto);
        assertNull("Produto deve ser nulo após exclusão", produto);
    }
}
