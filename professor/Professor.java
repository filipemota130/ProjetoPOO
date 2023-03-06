package professor;

import modelo.Modelo;

public class Professor extends Modelo {

    private String cpf;
    private String formacao;

    public Professor(int id, String nome, String cpf, String formacao) {
        super(id, nome);
        this.cpf = cpf;
        this.formacao = formacao;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return this.cpf;
    }

    public void setFormacao(String formacao) {
        this.formacao = formacao;
    }

    public String getFormacao() {
        return this.formacao;
    }

    public void Ver_info() {
        System.out.printf("\nID: %d\n", getId());
        System.out.printf("Nome: %s\n", getNome());
        System.out.printf("CPF: %s\n", getCpf());
        System.out.printf("Formação: %s\n\n", getFormacao());
    }

}