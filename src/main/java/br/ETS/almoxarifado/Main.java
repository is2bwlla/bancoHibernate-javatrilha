package br.ETS.almoxarifado;

import javax.persistence.EntityManager;

public class Main {
    public static void main(String[] args) {
        EntityManager entityManager = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(entityManager);
        ClienteService clienteService = new ClienteService(clienteDAO);

        ClienteDTO clienteDTO = new ClienteDTO("Igor Bedon de Sousa", "50050050055");

        // CADASTRO NOVO USUÁRIO USANDO CLIENTSERVICE
//        clienteService.cadastrarCliente(clienteDTO);
//

        // ATUALIZAÇÃO DE USUÁRIO SEM CLIENTSERVICE
//        Cliente clienteExistente = clienteDAO.buscarPorCpf(clienteDTO.cpf());
//        clienteExistente.setNome("Igor Bedon de Souza");
//        clienteDAO.atualizar(clienteExistente);

        // ATUALIZAÇÃO DE USUÁRIO COM CLIENTSERVICE
//        clienteService.atualizarCliente(clienteDTO);

    }
}
