package br.ETS.almoxarifado;

import javax.persistence.*;

@Entity
@Table (name = "tbcontas")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoConta", discriminatorType = DiscriminatorType.STRING)
public class Conta {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String numeroConta;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "clienteID", nullable = false)
    Cliente cliente;
    double saldo;

    public Conta() {
    }

    public Conta(int numeroConta, double saldo, Cliente cliente) {
    }

    // Método para converter Conta para ContaDTO
    public ContaDTO toDTO() {
        return new ContaDTO(
                this.saldo,
                this.cliente != null ? this.cliente.getNome() : null  // Pega o nome do cliente
        );
    }

    public Conta(int id, String numeroConta, Cliente cliente, double saldo) {
        this.id = id;
        this.numeroConta = numeroConta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "id=" + id +
                ", numeroConta=" + numeroConta +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                '}';
    }
}
