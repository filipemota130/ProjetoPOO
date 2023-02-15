package professor;
public class Professor {

    int id;
    String nome;
    String cpf;
    String formacao;

    public Professor(int id, String nome, String cpf, String formacao) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.formacao = formacao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public void setNome(String nome) {

        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
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

    public void printAtributos() {
        System.out.printf("\nID: %d\n", this.getId());
        System.out.printf("Nome: %s\n", this.getNome());
        System.out.printf("CPF: %s\n", this.getCpf());
        System.out.printf("Formação: %s\n\n", this.getFormacao());
    }
}