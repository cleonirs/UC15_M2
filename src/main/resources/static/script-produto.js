document.addEventListener('DOMContentLoaded', initCadastroProduto);

const formProduto = document.getElementById('form-produto');
const ENDPOINT = '/api/produto'; // Endpoint principal
// Mapeamento dos elementos <select>
const selectsMap = {
    categoria: document.getElementById('categoria'),
    origem: document.getElementById('origem'),
    ncm: document.getElementById('ncm'),
    cest: document.getElementById('cest'),
    cstEntrada: document.getElementById('cstEntrada'),
    cstSaida: document.getElementById('cstSaida'),
    icmsEntrada: document.getElementById('icmsEntrada'),
    icmsSaida: document.getElementById('icmsSaida'),
    pisCofins: document.getElementById('pisCofins'),
    fcp: document.getElementById('fcp')
};

// Limpa o formulário e reseta o ID oculto
function limparFormulario() {
    formProduto.reset();
    document.getElementById('id-produto').value = '';
    document.querySelector('.btn-salvar').textContent = 'Salvar'; // Volta para 'Salvar'
    alert('Formulário limpo! Pronto para novo cadastro.');
}

/**
 * Função aprimorada para popular o <select>.
 * Lida com alíquotas duplas (PISCOFINS), alíquota única (ICMS/FCP) e padrão (código/descrição).
 */
function popularSelect(selectElement, data, placeholderText = "Selecione...") {
    selectElement.innerHTML = `<option value="">${placeholderText}</option>`;
    
    data.forEach(item => {
        const option = document.createElement('option');
        option.value = item.id;
        
        let label = '';
        
        // 1. CHECAGEM ESPECÍFICA PARA PIS/COFINS (aliquotaPis e aliquotaCofins)
        if (item.aliquotaPis !== undefined && item.aliquotaCofins !== undefined) {
             const pis = parseFloat(item.aliquotaPis).toFixed(2);
             const cofins = parseFloat(item.aliquotaCofins).toFixed(2);
             
             let desc = item.descricao ? item.descricao : `ID ${item.id}`;
             label = `${desc} - PIS: ${pis}% / COFINS: ${cofins}%`;

        }
        // 2. CHECAGEM PARA ENTIDADES COM CAMPO 'aliquota' ÚNICO (ICMS, FCP)
        else if (item.aliquota !== undefined && item.aliquota !== null) {
             const aliquotaFormatada = parseFloat(item.aliquota).toFixed(2);
             
             if (item.descricao) {
                label = `${item.descricao} (${aliquotaFormatada}%)`;
             } else {
                label = `Alíquota: ${aliquotaFormatada}%`;
             }
        } 
        // 3. CHECAGEM PARA ENTIDADES COM CÓDIGO E DESCRIÇÃO (NCM, CST, Categoria, Origem)
        else if (item.codigo && item.descricao) {
            label = `${item.codigo} - ${item.descricao}`;
        } 
        // 4. FALLBACK
        else {
             label = `ID ${item.id} (Detalhe não encontrado)`;
        }

        option.textContent = label;
        selectElement.appendChild(option);
    });
}

// Carrega todos os dados mestres (Categorias, NCM, ICMS, etc.)
async function carregarDadosMestres() {
    try {
        const endpoints = {
            categoria: '/api/categorias',
            origem: '/api/origem',
            ncm: '/api/ncm',
            cest: '/api/cest',
            cst: '/api/cst',
            icms: '/api/icms', 
            pisCofins: '/api/piscofins',
            fcp: '/api/fcp'
        };
        
        // Dispara todas as chamadas de API em paralelo
        const promises = Object.keys(endpoints).map(key => fetch(endpoints[key]).then(res => {
            if (!res.ok) {
                throw new Error(`Falha ao carregar ${key}. Status: ${res.status}`);
            }
            return res.json();
        }));
        
        const [categorias, origens, ncms, cests, csts, icms, pisCofins, fcp] = await Promise.all(promises);

        popularSelect(selectsMap.categoria, categorias);
        popularSelect(selectsMap.origem, origens);
        popularSelect(selectsMap.ncm, ncms);
        popularSelect(selectsMap.cest, cests, 'Opcional');
        popularSelect(selectsMap.cstEntrada, csts);
        popularSelect(selectsMap.cstSaida, csts);
        popularSelect(selectsMap.icmsEntrada, icms);
        popularSelect(selectsMap.icmsSaida, icms);
        popularSelect(selectsMap.pisCofins, pisCofins);
        popularSelect(selectsMap.fcp, fcp);

    } catch (error) {
        console.error('Erro ao carregar dados mestres:', error);
        alert('Erro ao carregar dados fiscais. Verifique se o servidor está rodando e se os cadastros básicos (Categoria, NCM, etc.) foram preenchidos.');
    }
}

// Busca o produto pelo ID para preencher o formulário de edição
async function buscarProdutoParaEdicao(id) {
    try {
        const response = await fetch(`${ENDPOINT}/${id}`);
        if (!response.ok) {
            throw new Error(`Produto ID ${id} não encontrado.`);
        }
        const produto = await response.json();
        preencherFormulario(produto);
    } catch (error) {
        console.error('Erro ao buscar produto para edição:', error);
        alert('Erro ao carregar dados para edição: ' + error.message);
        limparFormulario();
    }
}

// Preenche o formulário com os dados do produto para edição
function preencherFormulario(produto) {
    document.getElementById('id-produto').value = produto.id;
    document.getElementById('codigo').value = produto.codigo;
    document.getElementById('descricao').value = produto.descricao;
    document.getElementById('codBarras').value = produto.codBarras;

    // Preenche os selects
    selectsMap.categoria.value = produto.categoria.id;
    selectsMap.origem.value = produto.origem.id;
    selectsMap.ncm.value = produto.ncm.id;
    selectsMap.cest.value = produto.cest ? produto.cest.id : ''; 
    selectsMap.cstEntrada.value = produto.cstEntrada.id;
    selectsMap.cstSaida.value = produto.cstSaida.id;
    selectsMap.icmsEntrada.value = produto.icmsEntrada.id;
    selectsMap.icmsSaida.value = produto.icmsSaida.id;
    selectsMap.pisCofins.value = produto.pisCofins.id;
    selectsMap.fcp.value = produto.fcp.id;
    
    // Altera o texto do botão para indicar que é uma atualização
    document.querySelector('.btn-salvar').textContent = 'Atualizar'; 
}


// Salva (cria) ou Atualiza (edita) o produto
async function salvarProduto() {
    const produtoId = document.getElementById('id-produto').value;

    const dados = {
        id: produtoId ? parseInt(produtoId) : null,
        codigo: document.getElementById('codigo').value,
        descricao: document.getElementById('descricao').value,
        codBarras: document.getElementById('codBarras').value,
        
        // Relacionamentos: enviamos apenas o ID, o Service do Java faz o resto
        categoria: { id: parseInt(selectsMap.categoria.value) },
        origem: { id: parseInt(selectsMap.origem.value) },
        ncm: { id: parseInt(selectsMap.ncm.value) },
        cest: selectsMap.cest.value ? { id: parseInt(selectsMap.cest.value) } : null,
        cstEntrada: { id: parseInt(selectsMap.cstEntrada.value) },
        cstSaida: { id: parseInt(selectsMap.cstSaida.value) },
        icmsEntrada: { id: parseInt(selectsMap.icmsEntrada.value) },
        icmsSaida: { id: parseInt(selectsMap.icmsSaida.value) },
        pisCofins: { id: parseInt(selectsMap.pisCofins.value) },
        fcp: { id: parseInt(selectsMap.fcp.value) }
    };

    try {
        const response = await fetch(ENDPOINT, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(dados)
        });

        if (response.ok) {
            alert(`Produto ${produtoId ? 'atualizado' : 'salvo'} com sucesso!`);
            limparFormulario(); 
        } else {
            const errorText = await response.text();
            throw new Error(`Falha ao salvar Produto. Status: ${response.status}. Detalhe: ${errorText.substring(0, 100)}...`);
        }

    } catch (error) {
        console.error('Erro ao salvar Produto:', error);
        alert(`Erro ao salvar Produto. Verifique o console para detalhes.`);
    }
}

// Função de inicialização
function initCadastroProduto() {
    // 1. Carrega os selects (dados mestres) primeiro
    carregarDadosMestres().then(() => {
        // 2. Após carregar os selects, verifica se há um ID de edição na localStorage
        const produtoId = localStorage.getItem('produtoIdParaEdicao');
        if (produtoId) {
            buscarProdutoParaEdicao(produtoId);
            localStorage.removeItem('produtoIdParaEdicao'); // Limpa o ID após o uso
        }
    });

    // 3. Adiciona o listener de submit (Salvar/Atualizar)
    formProduto.addEventListener('submit', function(event) {
        event.preventDefault();
        salvarProduto();
    });
}