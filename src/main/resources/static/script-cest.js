document.addEventListener('DOMContentLoaded', carregarCESTs);
const formCEST = document.getElementById('form-cest');
const tabelaCEST = document.getElementById('tabela-cest');
const idInput = document.getElementById('id-cest');
const codigoInput = document.getElementById('codigo');
const descricaoInput = document.getElementById('descricao');
const ENDPOINT = '/api/cest';

formCEST.addEventListener('submit', function(event) {
    event.preventDefault();
    salvarCEST();
});

function limparFormulario() {
    formCEST.reset();
    idInput.value = '';
}

async function carregarCESTs() {
    try {
        const response = await fetch(ENDPOINT);
        const cests = await response.json();
        tabelaCEST.innerHTML = ''; // Limpa a tabela

        cests.forEach(cest => {
            const row = tabelaCEST.insertRow();
            row.insertCell(0).textContent = cest.codigo;
            row.insertCell(1).textContent = cest.descricao;
            
            // Botões de Ação
            const acoesCell = row.insertCell(2); // Coluna 3
            const btnEditar = document.createElement('button');
            btnEditar.textContent = 'Editar';
            btnEditar.className = 'btn btn-sm btn-info me-2';
            btnEditar.onclick = () => preencherFormulario(cest);
            
            const btnExcluir = document.createElement('button');
            btnExcluir.textContent = 'Excluir';
            btnExcluir.className = 'btn btn-sm btn-danger';
            btnExcluir.onclick = () => excluirCEST(cest.id);
            
            acoesCell.appendChild(btnEditar);
            acoesCell.appendChild(btnExcluir);
        });

    } catch (error) {
        console.error('Erro ao carregar CESTs:', error);
        alert('Erro ao carregar lista de CESTs. Verifique o console para detalhes.');
    }
}

async function salvarCEST() {
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
            alert('CEST salvo com sucesso!');
            limparFormulario();
            carregarCESTs(); // Recarrega a tabela
        } else {
            throw new Error('Falha ao salvar CEST.');
        }

    } catch (error) {
        console.error('Erro ao salvar CEST:', error);
        alert('Erro ao salvar CEST. Verifique o console para detalhes.');
    }
}

function preencherFormulario(cest) {
    idInput.value = cest.id;
    codigoInput.value = cest.codigo;
    descricaoInput.value = cest.descricao;
}

async function excluirCEST(id) {
    if (!confirm('Tem certeza que deseja excluir este CEST?')) return;

    try {
        const response = await fetch(`${ENDPOINT}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('CEST excluído com sucesso!');
            carregarCESTs();
        } else {
            throw new Error('Falha ao excluir CEST.');
        }
        
    } catch (error) {
        console.error('Erro ao excluir CEST:', error);
        alert('Erro ao excluir CEST. Verifique o console para detalhes.');
    }
}