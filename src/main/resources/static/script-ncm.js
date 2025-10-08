document.addEventListener('DOMContentLoaded', carregarNCMs);
const formNCM = document.getElementById('form-ncm');
const tabelaNCM = document.getElementById('tabela-ncm');
const idInput = document.getElementById('id-ncm');
const codigoInput = document.getElementById('codigo');
const descricaoInput = document.getElementById('descricao');
const ENDPOINT = '/api/ncm';

formNCM.addEventListener('submit', function(event) {
    event.preventDefault();
    salvarNCM();
});

function limparFormulario() {
    formNCM.reset();
    idInput.value = '';
}

async function carregarNCMs() {
    try {
        const response = await fetch(ENDPOINT);
        const ncms = await response.json();
        tabelaNCM.innerHTML = ''; // Limpa a tabela

        ncms.forEach(ncm => {
            const row = tabelaNCM.insertRow();
            row.insertCell(0).textContent = ncm.codigo;
            row.insertCell(1).textContent = ncm.descricao;
            
            // Botões de Ação
            const acoesCell = row.insertCell(2); // Coluna 3
            const btnEditar = document.createElement('button');
            btnEditar.textContent = 'Editar';
            btnEditar.className = 'btn btn-sm btn-info me-2';
            btnEditar.onclick = () => preencherFormulario(ncm);
            
            const btnExcluir = document.createElement('button');
            btnExcluir.textContent = 'Excluir';
            btnExcluir.className = 'btn btn-sm btn-danger';
            btnExcluir.onclick = () => excluirNCM(ncm.id);
            
            acoesCell.appendChild(btnEditar);
            acoesCell.appendChild(btnExcluir);
        });

    } catch (error) {
        console.error('Erro ao carregar NCMs:', error);
        alert('Erro ao carregar lista de NCMs. Verifique o console para detalhes.');
    }
}

async function salvarNCM() {
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
            alert('NCM salvo com sucesso!');
            limparFormulario();
            carregarNCMs(); // Recarrega a tabela
        } else {
            throw new Error('Falha ao salvar NCM.');
        }

    } catch (error) {
        console.error('Erro ao salvar NCM:', error);
        alert('Erro ao salvar NCM. Verifique o console para detalhes.');
    }
}

function preencherFormulario(ncm) {
    idInput.value = ncm.id;
    codigoInput.value = ncm.codigo;
    descricaoInput.value = ncm.descricao;
}

async function excluirNCM(id) {
    if (!confirm('Tem certeza que deseja excluir este NCM?')) return;

    try {
        const response = await fetch(`${ENDPOINT}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('NCM excluído com sucesso!');
            carregarNCMs();
        } else {
            throw new Error('Falha ao excluir NCM.');
        }
        
    } catch (error) {
        console.error('Erro ao excluir NCM:', error);
        alert('Erro ao excluir NCM. Verifique o console para detalhes.');
    }
}