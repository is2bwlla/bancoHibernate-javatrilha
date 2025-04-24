package br.ETS.almoxarifado;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CORRENTE")
public class ContaCorrente extends Conta {
    private double chequeEspecial;

    public ContaCorrente() {
        super();
    }

    public ContaCorrente(int numeroConta, double saldo, Double chequeEspecial, Cliente cliente) {
        super(numeroConta, saldo, cliente);
        this.chequeEspecial = chequeEspecial;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public void setChequeEspecial(double chequeEspecial) {
        this.chequeEspecial = chequeEspecial;
    }
}
