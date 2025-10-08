document.addEventListener('DOMContentLoaded', initRelatorioProduto);

const ENDPOINT = '/api/produto';
const tabelaCorpo = document.getElementById('tabela-produtos-corpo');

// Função para buscar e listar todos os produtos
async function carregarProdutos() {
    tabelaCorpo.innerHTML = '<tr><td colspan="9" class="text-center">Carregando produtos...</td></tr>';
    try {
        const response = await fetch(ENDPOINT);
        if (!response.ok) {
            throw new Error(`Falha ao carregar produtos. Status: ${response.status}`);
        }
        const produtos = await response.json();
        exibirProdutos(produtos);
    } catch (error) {
        console.error('Erro ao carregar produtos:', error);
        tabelaCorpo.innerHTML = `<tr><td colspan="9" class="text-center text-danger">Erro: ${error.message}. Verifique o servidor.</td></tr>`;
    }
}

// Função para exibir os produtos na tabela
function exibirProdutos(produtos) {
    tabelaCorpo.innerHTML = ''; // Limpa o conteúdo
    
    if (produtos.length === 0) {
        tabelaCorpo.innerHTML = '<tr><td colspan="9" class="text-center">Nenhum produto cadastrado.</td></tr>';
        return;
    }

    produtos.forEach(produto => {
        const row = tabelaCorpo.insertRow();
        
        // Função auxiliar para obter a descrição da entidade ou um valor formatado
        const getDesc = (entity, field = 'descricao') => entity ? (entity[field] || entity.id) : '-';
        
        // Função auxiliar para formatar alíquota (PIS/COFINS)
        const formatPisCofins = (pc) => {
            if (!pc) return '-';
            const pis = pc.aliquotaPis ? parseFloat(pc.aliquotaPis).toFixed(2) : '0.00';
            const cofins = pc.aliquotaCofins ? parseFloat(pc.aliquotaCofins).toFixed(2) : '0.00';
            return `P: ${pis}% / C: ${cofins}%`;
        };

        // Função auxiliar para formatar alíquota única (ICMS/FCP)
        const formatAliquota = (ent) => {
             if (!ent) return '-';
             const aliquota = ent.aliquota ? parseFloat(ent.aliquota).toFixed(2) : '0.00';
             return `${aliquota}%`;
        };

        // Colunas da Tabela
        row.insertCell().textContent = produto.codigo;
        row.insertCell().textContent = produto.descricao;
        row.insertCell().textContent = produto.codBarras || '-';
        row.insertCell().textContent = getDesc(produto.categoria);
        row.insertCell().textContent = getDesc(produto.ncm, 'codigo'); 
        
        // CSTs
        const cstEntrada = getDesc(produto.cstEntrada, 'codigo');
        const cstSaida = getDesc(produto.cstSaida, 'codigo');
        row.insertCell().textContent = `${cstEntrada} / ${cstSaida}`;
        
        // ICMS
        const icmsEntrada = formatAliquota(produto.icmsEntrada);
        const icmsSaida = formatAliquota(produto.icmsSaida);
        row.insertCell().textContent = `${icmsEntrada} / ${icmsSaida}`;
        
        // PIS/COFINS
        row.insertCell().textContent = formatPisCofins(produto.pisCofins);

        // Coluna de Ações
        const acoesCell = row.insertCell();
        
        // Botão Editar
        const btnEditar = document.createElement('button');
        btnEditar.className = 'btn btn-sm btn-primary me-2';
        btnEditar.innerHTML = '<i class="fas fa-edit"></i>';
        btnEditar.onclick = () => editarProduto(produto.id);
        acoesCell.appendChild(btnEditar);

        // Botão Excluir
        const btnExcluir = document.createElement('button');
        btnExcluir.className = 'btn btn-sm btn-danger';
        btnExcluir.innerHTML = '<i class="fas fa-trash"></i>';
        btnExcluir.onclick = () => confirmarExclusao(produto.id, produto.descricao);
        acoesCell.appendChild(btnExcluir);
    });
}

// Lógica de Edição (Redireciona para pagina10 com o ID)
function editarProduto(id) {
    // Usamos localStorage para armazenar o ID e a pagina10 pode buscá-lo ao carregar
    localStorage.setItem('produtoIdParaEdicao', id);
    window.location.href = 'pagina10.html';
}

// Lógica de Exclusão
function confirmarExclusao(id, descricao) {
    if (confirm(`Tem certeza que deseja excluir o produto: ${descricao} (ID: ${id})?`)) {
        excluirProduto(id);
    }
}

async function excluirProduto(id) {
    try {
        const response = await fetch(`${ENDPOINT}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('Produto excluído com sucesso!');
            carregarProdutos(); // Recarrega a tabela
        } else if (response.status === 404) {
             alert('Erro: Produto não encontrado.');
        } else {
            throw new Error(`Falha ao excluir. Status: ${response.status}`);
        }
    } catch (error) {
        console.error('Erro ao excluir produto:', error);
        alert(`Erro ao excluir: ${error.message}`);
    }
}

// Lógica de Busca (Filtro simples no lado do cliente)
function filtrarProdutos() {
    // Implementação futura: Se a lista for muito grande, o filtro deve ser feito no servidor.
    // Por enquanto, vamos carregar a lista completa novamente.
    carregarProdutos();
}


// Inicialização
function initRelatorioProduto() {
    carregarProdutos();
    document.getElementById('btn-buscar').addEventListener('click', filtrarProdutos);
    // Adiciona listener para a tecla Enter no campo de busca
    document.getElementById('input-busca').addEventListener('keypress', function(e) {
        if (e.key === 'Enter') {
            filtrarProdutos();
        }
    });
}