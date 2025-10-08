// URL base da sua API REST para Categoria
const API_URL = '/api/categorias'; 

// Adiciona os event listeners após o carregamento da página
document.addEventListener('DOMContentLoaded', () => {
    carregarCategorias(); 

    // Captura o evento de SUBMIT do formulário
    document.getElementById('form-categoria').addEventListener('submit', function(e) {
        e.preventDefault(); // Impede o recarregamento padrão da página
        salvarOuAtualizarCategoria();
    });
});

// ----------------------------------------------------------------------
// FUNÇÕES CRUD
// ----------------------------------------------------------------------

// GET (Leitura): Carrega e exibe a lista na tabela
async function carregarCategorias() {
    const tabelaBody = document.getElementById('tabela-categorias');
    tabelaBody.innerHTML = ''; // Limpa a tabela para recarregar

    try {
        const response = await fetch(API_URL);
        
        if (!response.ok) {
            throw new Error(`Erro HTTP: ${response.status}`);
        }
        
        const categorias = await response.json();

        categorias.forEach(cat => {
            const row = tabelaBody.insertRow();
            
            // Colunas de dados
            row.insertCell(0).textContent = cat.codigo;
            row.insertCell(1).textContent = cat.descricao;

            // Coluna de Ações
            const acoesCell = row.insertCell(2);

            // Botão de Edição
            const btnEditar = document.createElement('button');
            btnEditar.textContent = 'Editar';
            btnEditar.className = 'btn btn-sm btn-info me-2';
            btnEditar.onclick = () => preencherFormulario(cat);
            acoesCell.appendChild(btnEditar);

            // Botão de Exclusão
            const btnExcluir = document.createElement('button');
            btnExcluir.textContent = 'Excluir';
            btnExcluir.className = 'btn btn-sm btn-danger';
            btnExcluir.onclick = () => deletarCategoria(cat.id);
            acoesCell.appendChild(btnExcluir);
        });

    } catch (error) {
        console.error("Erro ao carregar categorias:", error);
    }
}

// POST/PUT (Criação ou Atualização)
async function salvarOuAtualizarCategoria() {
    const id = document.getElementById('id-categoria').value;
    const codigo = document.getElementById('codigo').value;
    const descricao = document.getElementById('descricao').value;

    const categoriaData = { codigo, descricao };

    let url = API_URL;
    let method = 'POST'; // POST para criar

    if (id) {
        // PUT para atualizar se o ID estiver preenchido
        url = `${API_URL}/${id}`; 
        method = 'PUT';
    }

    try {
        const response = await fetch(url, {
            method: method,
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(categoriaData)
        });

        if (response.ok) {
            alert('Categoria salva com sucesso!');
            limparFormulario();
            carregarCategorias(); // Atualiza a lista
        } else {
            // Se o status for 400 (Bad Request), pode ser erro de validação (NotBlank)
            alert('Erro ao salvar categoria. Verifique se todos os campos estão preenchidos.');
        }
    } catch (error) {
        console.error("Erro na requisição:", error);
        alert('Erro de conexão com o servidor.');
    }
}

// DELETE (Exclusão)
async function deletarCategoria(id) {
    if (!confirm('Tem certeza que deseja excluir esta categoria?')) {
        return;
    }

    try {
        const response = await fetch(`${API_URL}/${id}`, {
            method: 'DELETE'
        });

        if (response.status === 204) { // Status 204 é o sucesso para DELETE
            alert('Categoria excluída com sucesso!');
            carregarCategorias(); // Atualiza a lista
        } else if (response.status === 404) {
             alert('Categoria não encontrada.');
        } else {
            alert('Erro ao excluir categoria.');
        }
    } catch (error) {
        console.error("Erro na requisição:", error);
    }
}

// ----------------------------------------------------------------------
// FUNÇÕES DE UTILIDADE
// ----------------------------------------------------------------------

// Preenche o formulário com dados da linha selecionada para edição
function preencherFormulario(categoria) {
    document.getElementById('id-categoria').value = categoria.id;
    document.getElementById('codigo').value = categoria.codigo;
    document.getElementById('descricao').value = categoria.descricao;
}

// Limpa todos os campos do formulário
function limparFormulario() {
    document.getElementById('form-categoria').reset();
    document.getElementById('id-categoria').value = ''; // Garante que o ID é zerado
}