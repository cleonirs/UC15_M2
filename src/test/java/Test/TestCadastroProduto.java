package Test;

import jpa.ProdutoJPA;
import modelo.Produto;
import static org.junit.Assert.*;
import org.junit.Test;


public class TestCadastroProduto {

    public TestCadastroProduto() {
    }

    @Test
    public void testCadastrarProdutoValido() {
        Produto produto = new Produto();
        produto.setCodigo("12345");
        produto.setDescricao("Produto Teste Cleonir");
        produto.setCodigoBarras("7891234567890");
        produto.setCategoriaId(1);
        produto.setOrigemId(1);
        produto.setNcmId(1);
        produto.setCestId(1);
        produto.setCstEntradaId(1);
        produto.setCstSaidaId(1);
        produto.setAliquotaIcmsEntradaId(1);
        produto.setAliquotaIcmsSaidaId(1);
        produto.setAliquotaPisId(1);
        produto.setAliquotaFCPId(1);

        ProdutoJPA.cadastrar(produto);

        assertNotNull("ID do produto não pode ser nulo após persistência", produto.getId());
    }
}
