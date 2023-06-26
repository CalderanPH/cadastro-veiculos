const baseUrl = 'http://localhost:8080';

// Função para fazer uma requisição GET para a rota /veiculos
function getVeiculos() {
    fetch(`${baseUrl}/veiculos`)
        .then(response => response.json())
        .then(data => {
            alert('Veiculos no console');
            console.log(data);
            displayResults(data);
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

// Função para fazer uma requisição GET para a rota /veiculos/filter
function getVeiculosByFilter(marca, ano, cor) {
    fetch(`${baseUrl}/veiculos/filter?marca=${marca}&ano=${ano}&cor=${cor}`)
        .then(response => response.json())
        .then(data => {
            alert('Veiculos no console');
            displayResults(data);
            console.log(data);
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

// Função para fazer uma requisição GET para a rota /veiculos/nao-vendidos
function getVeiculosNaoVendidos() {
    fetch(`${baseUrl}/veiculos/nao-vendidos`)
        .then(response => response.json())
        .then(data => {
            alert('Veiculos no console');
            displayResults(data);
            console.log(data);
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

// Função para fazer uma requisição GET para a rota /veiculos/decada
function getVeiculosByDecada(ano) {
    fetch(`${baseUrl}/veiculos/decada?ano=${ano}`)
        .then(response => response.json())
        .then(data => {
            alert('Veiculos no console');
            displayResults(data);
            console.log(data);
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

// Função para fazer uma requisição GET para a rota /veiculos/ultima-semana
function getVeiculosUltimaSemana() {
    fetch(`${baseUrl}/veiculos/ultima-semana`)
        .then(response => response.json())
        .then(data => {
            alert('Veiculos no console');
            displayResults(data);
            console.log(data);
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

// Função para fazer uma requisição POST para a rota /veiculos
function createVeiculo(veiculoData) {
    fetch(`${baseUrl}/veiculos`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(veiculoData)
    })
        .then(response => {
            if (response.ok) {
                alert('Veículo criado com sucesso.');
                console.log('Veículo criado com sucesso.');
            } else {
                throw new Error('Erro ao criar veículo.');
            }
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

// Função para fazer uma requisição PUT para a rota /veiculos/{id}
function updateVeiculo(id, veiculoData) {
    fetch(`${baseUrl}/veiculos/${id}`, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(veiculoData)
    })
        .then(response => {
            if (response.ok) {
                alert('Veículo atualizado com sucesso.');
                console.log('Veículo atualizado com sucesso.');
            } else {
                throw new Error('Erro ao atualizar veículo.');
            }
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

// Função para fazer uma requisição PATCH para a rota /veiculos/{id}
function updateVeiculoStatus(id, veiculoStatusData) {
    fetch(`${baseUrl}/veiculos/${id}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(veiculoStatusData)
    })
        .then(response => {
            if (response.ok) {
                alert('Status do veículo atualizado com sucesso.');
                console.log('Status do veículo atualizado com sucesso.');
            } else {
                throw new Error('Erro ao atualizar o status do veículo.');
            }
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

// Função para fazer uma requisição DELETE para a rota /veiculos/{id}
function deleteVeiculo(id) {
    fetch(`${baseUrl}/veiculos/${id}`, {
        method: 'DELETE'
    })
        .then(response => {
            if (response.ok) {
                alert('Veículo excluído com sucesso.');
                console.log('Veículo excluído com sucesso.');
            } else {
                throw new Error('Erro ao excluir veículo.');
            }
        })
        .catch(error => {
            console.error('Ocorreu um erro:', error);
        });
}

const veiculoData = {
};

createVeiculo(veiculoData);

const id = '12345-67890';
const veiculoUpdateData = {
};

updateVeiculo(id, veiculoUpdateData);

const veiculoStatusData = {
};

updateVeiculoStatus(id, veiculoStatusData);

deleteVeiculo(id);