package br.ETS.almoxarifado;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.Random;

public class ContaDAO {
    private EntityManager entityManager;

    public ContaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public String gerarNumeroConta() {
        Random random = new Random();
        int numeros = 1000000 + random.nextInt(9000000);
        int digito = random.nextInt(10);

        return String.format("%d-%d", numeros, digito);
    }

    public void criarConta(Conta conta) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            String numeroConta = gerarNumeroConta();

            conta.setNumeroConta(numeroConta);
            entityManager.persist(conta);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        }
    }


}
