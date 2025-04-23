package br.ETS.almoxarifado;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

public class ClienteDAO {
    private EntityManager entityManager;

    public ClienteDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Função que cadastra o meu cliente no banco através do persist e do commit
    public void cadastrar(Cliente cliente) {
        entityManager.getTransaction().begin();
        this.entityManager.persist(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Função que atualiza um cliente já existente no banco de dados através do merge
    public void atualizar(Cliente cliente) {
        entityManager.getTransaction().begin();
        this.entityManager.merge(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    // Função que remove um cliente existente do banco desde de que tenha o saldo zerado atráves do remove
    public void remover(Cliente cliente) {
        entityManager.getTransaction().begin();
        cliente = entityManager.merge(cliente);
        this.entityManager.remove(cliente);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public Cliente buscarPorCpf(String cpf) {
        String jpql = "SELECT c FROM Cliente c WHERE c.cpf = :cpf";
        try {
            return entityManager.createQuery(jpql, Cliente.class)
                    .setParameter("cpf", cpf)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }
}
