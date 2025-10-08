document.addEventListener('DOMContentLoaded', carregarICMSs);

const formICMS = document.getElementById('form-icms');
const tabelaICMS = document.getElementById('tabela-icms');
const idInput = document.getElementById('id-icms');

// Elementos de input atualizados para a nova estrutura
const aliquotaInput = document.getElementById('aliquota');
const reducaoInput = document.getElementById('reducao'); // NOVO CAMPO
const validoAteInput = document.getElementById('validoAte'); // NOVO CAMPO (tipo date no HTML)

const ENDPOINT = '/api/icms';

formICMS.addEventListener('submit', function(event) {
    event.preventDefault();
    salvarICMS();
});

function limparFormulario() {
    formICMS.reset();
    idInput.value = '';
    // Opcional: Mudar o texto do botão de volta para "Salvar"
    document.querySelector('.btn-salvar').textContent = 'Salvar';
}

async function carregarICMSs() {
    try {
        const response = await fetch(ENDPOINT);
        const icmss = await response.json();
        tabelaICMS.innerHTML = ''; // Limpa a tabela
        
        if (icmss.length === 0) {
            tabelaICMS.innerHTML = '<tr><td colspan="4" class="text-center">Nenhuma alíquota de ICMS cadastrada.</td></tr>';
            return;
        }

        icmss.forEach(icms => {
            const row = tabelaICMS.insertRow();
            
            // 0: Alíquota
            row.insertCell(0).textContent = (icms.aliquota || 0.00).toFixed(2) + '%'; 
            // 1: Redução
            row.insertCell(1).textContent = (icms.reducao || 0.00).toFixed(2) + '%';
            // 2: Válido Até
            row.insertCell(2).textContent = icms.validoAte || 'Indefinido';
            
            // Botões de Ação
            const acoesCell = row.insertCell(3);
            
            const btnEditar = document.createElement('button');
            btnEditar.textContent = 'Editar';
            btnEditar.className = 'btn btn-sm btn-info me-2';
            btnEditar.onclick = () => preencherFormulario(icms);
            
            const btnExcluir = document.createElement('button');
            btnExcluir.textContent = 'Excluir';
            btnExcluir.className = 'btn btn-sm btn-danger';
            btnExcluir.onclick = () => excluirICMS(icms.id);
            
            acoesCell.appendChild(btnEditar);
            acoesCell.appendChild(btnExcluir);
        });

    } catch (error) {
        console.error('Erro ao carregar ICMSs:', error);
        alert('Erro ao carregar lista de ICMSs. Verifique o console para detalhes.');
    }
}

async function salvarICMS() {
    const dados = {
        id: idInput.value ? parseInt(idInput.value) : null,
        // Usando os novos campos
        aliquota: parseFloat(aliquotaInput.value),
        reducao: parseFloat(reducaoInput.value),
        validoAte: validoAteInput.value // Data é enviada como String
    };

    // Validação básica para garantir que os campos Double sejam números
    if (isNaN(dados.aliquota) || isNaN(dados.reducao)) {
        alert('Alíquota e Redução devem ser valores numéricos válidos.');
        return;
    }
    
    try {
        const response = await fetch(ENDPOINT, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });

        if (response.ok) {
            alert('ICMS salvo com sucesso!');
            limparFormulario();
            carregarICMSs(); // Recarrega a tabela
        } else {
            throw new Error('Falha ao salvar o ICMS.');
        }

    } catch (error) {
        console.error('Erro ao salvar ICMS:', error);
        alert('Erro ao salvar o ICMS. Verifique o console para detalhes.');
    }
}

function preencherFormulario(icms) {
    idInput.value = icms.id;
    // Preenchendo os novos campos
    aliquotaInput.value = icms.aliquota;
    reducaoInput.value = icms.reducao;
    validoAteInput.value = icms.validoAte;
    
    // Opcional: Mudar o texto do botão para indicar edição
    document.querySelector('.btn-salvar').textContent = 'Atualizar';
}

async function excluirICMS(id) {
    if (!confirm('Tem certeza que deseja excluir esta alíquota de ICMS?')) return;

    try {
        const response = await fetch(`${ENDPOINT}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('ICMS excluído com sucesso!');
            carregarICMSs();
        } else {
            throw new Error('Falha ao excluir o ICMS.');
        }
        
    } catch (error) {
        console.error('Erro ao excluir ICMS:', error);
        alert('Erro ao excluir o ICMS. Verifique o console para detalhes.');
    }
}