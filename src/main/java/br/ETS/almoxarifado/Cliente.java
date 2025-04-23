package br.ETS.almoxarifado;
import javax.persistence.*;

@Entity
@Table (name = "tbclientes")
public class Cliente {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    @Column(name = "cpf", unique = true)
    private String cpf;

    public Cliente() {
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.nome = clienteDTO.nome();
        this.cpf = clienteDTO.cpf();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cpf=" + cpf +
                '}';
    }
}
