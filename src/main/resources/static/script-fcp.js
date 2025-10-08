document.addEventListener('DOMContentLoaded', carregarFCPs);
const formFCP = document.getElementById('form-fcp');
const tabelaFCP = document.getElementById('tabela-fcp');
const idInput = document.getElementById('id-fcp');
const aliquotaInput = document.getElementById('aliquota');
const baseLegalInput = document.getElementById('baseLegal');
const validoAteInput = document.getElementById('validoAte');
const ENDPOINT = '/api/fcp';

formFCP.addEventListener('submit', function(event) {
    event.preventDefault();
    salvarFCP();
});

function limparFormulario() {
    formFCP.reset();
    idInput.value = '';
}

async function carregarFCPs() {
    try {
        const response = await fetch(ENDPOINT);
        const fcps = await response.json();
        tabelaFCP.innerHTML = ''; // Limpa a tabela

        fcps.forEach(fcp => {
            const row = tabelaFCP.insertRow();
            row.insertCell(0).textContent = fcp.aliquota.toFixed(2) + '%';
            row.insertCell(1).textContent = fcp.baseLegal;
            row.insertCell(2).textContent = fcp.validoAte;
            
            // Botões de Ação
            const acoesCell = row.insertCell(3);
            const btnEditar = document.createElement('button');
            btnEditar.textContent = 'Editar';
            btnEditar.className = 'btn btn-sm btn-info me-2';
            btnEditar.onclick = () => preencherFormulario(fcp);
            
            const btnExcluir = document.createElement('button');
            btnExcluir.textContent = 'Excluir';
            btnExcluir.className = 'btn btn-sm btn-danger';
            btnExcluir.onclick = () => excluirFCP(fcp.id);
            
            acoesCell.appendChild(btnEditar);
            acoesCell.appendChild(btnExcluir);
        });

    } catch (error) {
        console.error('Erro ao carregar FCPs:', error);
        alert('Erro ao carregar lista de FCPs.');
    }
}

/*async function carregarFCPs() {
    try {
        const response = await fetch(ENDPOINT);
        if (!response.ok) {
            throw new Error(`Erro HTTP: ${response.status}`);
        }
        
        const fcps = await response.json();
        const tabelaFCP = document.getElementById('tabela-fcp');
        tabelaFCP.innerHTML = ''; // Limpa a tabela

        fcps.forEach(fcp => {
            const row = tabelaFCP.insertRow();
            
            // 1. Alíquota: Formata o Double para exibir o '%'
            row.insertCell(0).textContent = fcp.aliquota.toFixed(2) + '%';
            
            // 2. Base Legal
            row.insertCell(1).textContent = fcp.baseLegal;
            
            // 3. Válido até: A data já vem no formato YYYY-MM-DD
            row.insertCell(2).textContent = fcp.validoAte; 
            
            // 4. Célula de Ações
            const acoesCell = row.insertCell(3);
            
            const btnEditar = document.createElement('button');
            btnEditar.textContent = 'Editar';
            btnEditar.className = 'btn btn-sm btn-info me-2';
            btnEditar.onclick = () => preencherFormulario(fcp);
            
            const btnExcluir = document.createElement('button');
            btnExcluir.textContent = 'Excluir';
            btnExcluir.className = 'btn btn-sm btn-danger';
            btnExcluir.onclick = () => excluirFCP(fcp.id);
            
            acoesCell.appendChild(btnEditar);
            acoesCell.appendChild(btnExcluir);
        });

    } catch (error) {
        // Agora, se der erro, ele vai logar o erro detalhado no console
        console.error('Erro ao carregar FCPs:', error);
        alert('Erro ao carregar lista de FCPs. Verifique o console para detalhes.');
    }
}*/

async function salvarFCP() {
    const dados = {
        id: idInput.value ? parseInt(idInput.value) : null,
        aliquota: parseFloat(aliquotaInput.value),
        baseLegal: baseLegalInput.value,
        validoAte: validoAteInput.value // A API espera no formato YYYY-MM-DD
    };

    try {
        const response = await fetch(ENDPOINT, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });

        if (response.ok) {
            alert('FCP salvo com sucesso!');
            limparFormulario();
            carregarFCPs(); // Recarrega a tabela
        } else {
            throw new Error('Falha ao salvar o FCP.');
        }

    } catch (error) {
        console.error('Erro ao salvar FCP:', error);
        alert('Erro ao salvar o FCP. Verifique o console para detalhes.');
    }
}

function preencherFormulario(fcp) {
    idInput.value = fcp.id;
    aliquotaInput.value = fcp.aliquota;
    baseLegalInput.value = fcp.baseLegal;
    validoAteInput.value = fcp.validoAte;
}

async function excluirFCP(id) {
    if (!confirm('Tem certeza que deseja excluir esta alíquota de FCP?')) return;

    try {
        const response = await fetch(`${ENDPOINT}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('FCP excluído com sucesso!');
            carregarFCPs();
        } else {
            throw new Error('Falha ao excluir o FCP.');
        }
        
    } catch (error) {
        console.error('Erro ao excluir FCP:', error);
        alert('Erro ao excluir o FCP. Verifique o console para detalhes.');
    }
}