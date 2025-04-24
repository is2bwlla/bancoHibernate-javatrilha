package br.ETS.almoxarifado;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("POUPANCA")
public class ContaPoupanca extends Conta {
    private double taxaRentabilidade;

    public ContaPoupanca() {
        super();
    }

    public ContaPoupanca(int numeroConta, double saldo, Cliente cliente, double taxaRentabilidade) {
        super(numeroConta, saldo, cliente);
        this.taxaRentabilidade = taxaRentabilidade;
    }

    public double getTaxaRentabilidade() {
        return taxaRentabilidade;
    }

    public void setTaxaRentabilidade(double taxaRentabilidade) {
        this.taxaRentabilidade = taxaRentabilidade;
    }
}
