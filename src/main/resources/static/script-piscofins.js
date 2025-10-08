document.addEventListener('DOMContentLoaded', carregarPISCOFINSs);
const formPISCOFINS = document.getElementById('form-piscofins');
const tabelaPISCOFINS = document.getElementById('tabela-piscofins');
const idInput = document.getElementById('id-piscofins');
const codigoInput = document.getElementById('codigo');
const aliquotaPisInput = document.getElementById('aliquotaPis');
const aliquotaCofinsInput = document.getElementById('aliquotaCofins');
const ENDPOINT = '/api/piscofins';

formPISCOFINS.addEventListener('submit', function(event) {
    event.preventDefault();
    salvarPISCOFINS();
});

function limparFormulario() {
    formPISCOFINS.reset();
    idInput.value = '';
}

async function carregarPISCOFINSs() {
    try {
        const response = await fetch(ENDPOINT);
        const piscofinsLista = await response.json();
        tabelaPISCOFINS.innerHTML = ''; // Limpa a tabela

        piscofinsLista.forEach(piscofins => {
            const row = tabelaPISCOFINS.insertRow();
            row.insertCell(0).textContent = piscofins.codigo;
            row.insertCell(1).textContent = piscofins.aliquotaPis.toFixed(4) + '%';
            row.insertCell(2).textContent = piscofins.aliquotaCofins.toFixed(4) + '%';
            
            // Botões de Ação
            const acoesCell = row.insertCell(3);
            const btnEditar = document.createElement('button');
            btnEditar.textContent = 'Editar';
            btnEditar.className = 'btn btn-sm btn-info me-2';
            btnEditar.onclick = () => preencherFormulario(piscofins);
            
            const btnExcluir = document.createElement('button');
            btnExcluir.textContent = 'Excluir';
            btnExcluir.className = 'btn btn-sm btn-danger';
            btnExcluir.onclick = () => excluirPISCOFINS(piscofins.id);
            
            acoesCell.appendChild(btnEditar);
            acoesCell.appendChild(btnExcluir);
        });

    } catch (error) {
        console.error('Erro ao carregar PIS/COFINS:', error);
        alert('Erro ao carregar lista de PIS/COFINS. Verifique o console para detalhes.');
    }
}

async function salvarPISCOFINS() {
    const dados = {
        id: idInput.value ? parseInt(idInput.value) : null,
        codigo: codigoInput.value,
        aliquotaPis: parseFloat(aliquotaPisInput.value),
        aliquotaCofins: parseFloat(aliquotaCofinsInput.value)
    };

    try {
        const response = await fetch(ENDPOINT, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });

        if (response.ok) {
            alert('PIS/COFINS salvo com sucesso!');
            limparFormulario();
            carregarPISCOFINSs(); // Recarrega a tabela
        } else {
            throw new Error('Falha ao salvar PIS/COFINS.');
        }

    } catch (error) {
        console.error('Erro ao salvar PIS/COFINS:', error);
        alert('Erro ao salvar PIS/COFINS. Verifique o console para detalhes.');
    }
}

function preencherFormulario(piscofins) {
    idInput.value = piscofins.id;
    codigoInput.value = piscofins.codigo;
    aliquotaPisInput.value = piscofins.aliquotaPis;
    aliquotaCofinsInput.value = piscofins.aliquotaCofins;
}

async function excluirPISCOFINS(id) {
    if (!confirm('Tem certeza que deseja excluir esta alíquota de PIS/COFINS?')) return;

    try {
        const response = await fetch(`${ENDPOINT}/${id}`, {
            method: 'DELETE'
        });

        if (response.ok) {
            alert('PIS/COFINS excluído com sucesso!');
            carregarPISCOFINSs();
        } else {
            throw new Error('Falha ao excluir PIS/COFINS.');
        }
        
    } catch (error) {
        console.error('Erro ao excluir PIS/COFINS:', error);
        alert('Erro ao excluir PIS/COFINS. Verifique o console para detalhes.');
    }
}