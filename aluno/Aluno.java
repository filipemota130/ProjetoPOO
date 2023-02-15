package aluno;
import java.util.ArrayList;

public class Aluno {

    // Atributos.
    public String nome;
    public int matricula;
    public String email;
    public int cpf;
    public ArrayList<String> notas = new ArrayList<String>();
    public ArrayList<String> historicoAnalitico = new ArrayList<String>();
    public ArrayList<String> disciplinasAtuais = new ArrayList<String>();

    // Cadastrar informações dos alunosCadastrados.
    public Aluno(String nome, int matricula, String email, int cpf) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.cpf = cpf;
    }

    // Exibir todas as informações.
    public void printAluno() {
        System.out.print("Nome: " + this.nome +
                "\nMatrícula: " + this.matricula +
                "\nCPF: " + this.cpf +
                "\nE-mail: " + this.email+"\n");
    }

    // função boletim
    public void printBoletim() {
        for (int i = 0; i < notas.size(); i++) {
            System.out.println(notas.get(i));
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getCpf() {
        return cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public ArrayList<String> getNotas() {
        return this.notas;
    }

    public void setNotas(String nota) {
        this.notas.add(nota);
    }
    
    public void printHistorico() {
        for (int i = 0; i < historicoAnalitico.size(); i++) {
            System.out.println(historicoAnalitico.get(i));
        }
    }
    
    public void printDisciplina() {
        if (disciplinasAtuais.isEmpty()) {
            System.out.println("O aluno não está matriculado em nenhuma disciplina.");
        } else {
            for (int i = 0; i < disciplinasAtuais.size(); i++) {
                System.out.println(disciplinasAtuais.get(i));
            }
        }
    }

}