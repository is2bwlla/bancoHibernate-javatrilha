package br.ETS.almoxarifado;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);
        ClienteService clienteService = new ClienteService(clienteDAO);

        ClienteDTO clienteDTO = new ClienteDTO("Igor Bedon de Sousa", "50050050055");

//        BANCO
        ContaDAO contaDAO = new ContaDAO(entityManager);
        ContaDTO contaDTO = new ContaDTO(2000.00, clienteDTO.nome());






//        CLIENTE

        // CADASTRO NOVO USUÁRIO USANDO CLIENTESERVICE
//        clienteService.cadastrarCliente(clienteDTO);

        // ATUALIZAÇÃO DE USUÁRIO SEM CLIENTESERVICE
//        Cliente clienteExistente = clienteDAO.buscarPorCpf(clienteDTO.cpf());
//        clienteExistente.setNome("Igor Bedon de Souza");
//        clienteDAO.atualizar(clienteExistente);

        // ATUALIZAÇÃO DE USUÁRIO COM CLIENTESERVICE
//        clienteService.atualizarCliente(clienteDTO);

        // REMOÇÃO DO USUÁRIO SEM CLIENTESERVICE
//        Cliente cliente = clienteDAO.buscarPorCpf(clienteDTO.cpf());
//        clienteDAO.remover(cliente);

        // REMOÇÃO DO USUÁRIO COM CLIENTESERVICE

    }
}
