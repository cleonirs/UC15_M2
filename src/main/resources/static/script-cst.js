document.addEventListener('DOMContentLoaded', carregarCSTs);
const formCST = document.getElementById('form-cst');
const tabelaCST = document.getElementById('tabela-cst');
const idInput = document.getElementById('id-cst');
const codigoInput = document.getElementById('codigo');
const descricaoInput = document.getElementById('descricao');
const ENDPOINT = '/api/cst';

formCST.addEventListener('submit', function(event) {
    event.preventDefault();
    salvarCST();
});

function limparFormulario() {
    formCST.reset();
    idInput.value = '';
}

async function carregarCSTs() {
    try {
        const response = await fetch(ENDPOINT);
        const csts = await response.json();
        tabelaCST.innerHTML = ''; // Limpa a tabela

        csts.forEach(cst => {
            const row = tabelaCST.insertRow();
            row.insertCell(0).textContent = cst.codigo;
            row.insertCell(1).textContent = cst.descricao;
            
            // Botões de Ação
            const acoesCell = row.insertCell(2); // Coluna 3
            const btnEditar = document.createElement('button');
            btnEditar.textContent = 'Editar';
            btnEditar.className = 'btn btn-sm btn-info me-2';
            btnEditar.onclick = () => preencherFormulario(cst);
            
            const btnExcluir = document.createElement('button');
            btnExcluir.textContent = 'Excluir';
            btnExcluir.className = 'btn btn-sm btn-danger';
            btnExcluir.onclick = () => excluirCST(cst.id);
            
            acoesCell.appendChild(btnEditar);
            acoesCell.appendChild(btnExcluir);
        });

    } catch (error) {
        console.error('Erro ao carregar CSTs:', error);
        alert('Erro ao carregar lista de CSTs. Verifique o console para detalhes.');
    }
}

async function salvarCST() {
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
            alert('CST salvo com sucesso!');
            limparFormulario();
            carregarCSTs(); // Recarrega a tabela
        } else {
            throw new Error('Falha ao salvar CST.');
        }

    } catch (error) {
        console.error('Erro ao salvar CST:', error);
        alert('Erro ao salvar CST. Verifique o console para detalhes.');
    }
}

function preencherFormulario(cst) {
    idInput.value = cst.id;
    codigoInput.value = cst.codigo;
    descricaoInput.value = cst.descricao;
}

async function excluirCST(id) {
    if (!confirm('Tem certeza que deseja excluir este CST?')) return;

    try {
        const response = await fetch(`${ENDPOINT}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('CST excluído com sucesso!');
            carregarCSTs();
        } else {
            throw new Error('Falha ao excluir CST.');
        }
        
    } catch (error) {
        console.error('Erro ao excluir CST:', error);
        alert('Erro ao excluir CST. Verifique o console para detalhes.');
    }
}