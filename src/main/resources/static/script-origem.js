document.addEventListener('DOMContentLoaded', carregarOrigens);
const formOrigem = document.getElementById('form-origem');
const tabelaOrigem = document.getElementById('tabela-origem');
const idInput = document.getElementById('id-origem');
const codigoInput = document.getElementById('codigo');
const descricaoInput = document.getElementById('descricao');
const ENDPOINT = '/api/origem';

formOrigem.addEventListener('submit', function(event) {
    event.preventDefault();
    salvarOrigem();
});

function limparFormulario() {
    formOrigem.reset();
    idInput.value = '';
}

async function carregarOrigens() {
    try {
        const response = await fetch(ENDPOINT);
        const origens = await response.json();
        tabelaOrigem.innerHTML = ''; // Limpa a tabela

        origens.forEach(origem => {
            const row = tabelaOrigem.insertRow();
            row.insertCell(0).textContent = origem.codigo;
            row.insertCell(1).textContent = origem.descricao;
            
            // Botões de Ação
            const acoesCell = row.insertCell(2); // Coluna 3
            const btnEditar = document.createElement('button');
            btnEditar.textContent = 'Editar';
            btnEditar.className = 'btn btn-sm btn-info me-2';
            btnEditar.onclick = () => preencherFormulario(origem);
            
            const btnExcluir = document.createElement('button');
            btnExcluir.textContent = 'Excluir';
            btnExcluir.className = 'btn btn-sm btn-danger';
            btnExcluir.onclick = () => excluirOrigem(origem.id);
            
            acoesCell.appendChild(btnEditar);
            acoesCell.appendChild(btnExcluir);
        });

    } catch (error) {
        console.error('Erro ao carregar Origens:', error);
        alert('Erro ao carregar lista de Origens. Verifique o console para detalhes.');
    }
}

async function salvarOrigem() {
    const dados = {
        id: idInput.value ? parseInt(idInput.value) : null,
        codigo: codigoInput.value,
        descricao: descricaoInput.value
    };

    try {
        const response = await fetch(ENDPOINT, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });

        if (response.ok) {
            alert('Origem salva com sucesso!');
            limparFormulario();
            carregarOrigens(); // Recarrega a tabela
        } else {
            throw new Error('Falha ao salvar Origem.');
        }

    } catch (error) {
        console.error('Erro ao salvar Origem:', error);
        alert('Erro ao salvar Origem. Verifique o console para detalhes.');
    }
}

function preencherFormulario(origem) {
    idInput.value = origem.id;
    codigoInput.value = origem.codigo;
    descricaoInput.value = origem.descricao;
}

async function excluirOrigem(id) {
    if (!confirm('Tem certeza que deseja excluir esta Origem?')) return;

    try {
        const response = await fetch(`${ENDPOINT}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('Origem excluída com sucesso!');
            carregarOrigens();
        } else {
            throw new Error('Falha ao excluir Origem.');
        }
        
    } catch (error) {
        console.error('Erro ao excluir Origem:', error);
        alert('Erro ao excluir Origem. Verifique o console para detalhes.');
    }
}