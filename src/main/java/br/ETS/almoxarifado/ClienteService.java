package br.ETS.almoxarifado;

import javax.persistence.EntityManager;

public class ClienteService {
    private ClienteDAO clienteDAO;

    public ClienteService(EntityManager entityManager) {
        this.clienteDAO = new ClienteDAO(entityManager);
    }

    public ClienteService(ClienteDAO clienteDAO) {
        this.clienteDAO = clienteDAO;
    }

    public void cadastrarCliente(ClienteDTO clienteDTO) {
        Cliente clienteExistente = clienteDAO.buscarPorCpf(clienteDTO.cpf());

        if (clienteExistente == null) {
            Cliente cliente = new Cliente();
            cliente.setNome(clienteDTO.nome());
            cliente.setCpf(clienteDTO.cpf());

            // Chama o DAO para salvar o novo cliente no banco de dados
            clienteDAO.cadastrar(cliente);
            System.out.println("Cliente cadastrado com sucesso.");
        } else {
            System.out.println("Cliente já cadastrado.");
        }
    }

    public void atualizarCliente(ClienteDTO clienteDTO){
        Cliente clienteExistente = clienteDAO.buscarPorCpf(clienteDTO.cpf());

        if (clienteExistente == null) {
            System.out.println("Não é possível atualizar um cliente inexistente.");
        } else {
            clienteExistente.setNome(clienteDTO.nome());
            clienteDAO.atualizar(clienteExistente);
            System.out.println("Cliente atualizado com sucesso.");
        }
    }
}
