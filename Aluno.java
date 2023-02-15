package aluno;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {

    // Atributos.
    public String nome;
    public int matricula;
    public String email;
    public String cpf;
    ArrayList<String> notas = new ArrayList<String>();
    ArrayList<String> historicoAnalitico = new ArrayList<String>();
    ArrayList<String> disciplinasAtuais = new ArrayList<String>();

    // Cadastrar informações dos alunosCadastrados.
    public Aluno(String nome, int matricula, String email, String cpf) {
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
        this.cpf = cpf;
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

    // Exibir todas as informações.
    public void printAluno() {
        System.out.print("Nome: " + this.nome +
                "\nMatrícula: " + this.matricula +
                "\nCPF: " + this.cpf +
                "\nE-mail: " + this.email +
                "\nDisciplinas matriculadas: ");
        printDisciplina();
    }

    // função boletim
    public void printBoletim() {
        for (int i = 0; i < notas.size(); i++) {
            System.out.println(notas.get(i));
        }
    }

    public void printHistorico() {
        for (int i = 0; i < historicoAnalitico.size(); i++) {
            System.out.println(historicoAnalitico.get(i));
        }
    }

    public void setNomeAluno(String nome) {
        this.nome = nome;
    }

    public String getNomeAluno() {
        return nome;
    }

    public void setMatriculaAluno(int matricula) {
        this.matricula = matricula;
    }

    public int getMatriculaAluno() {
        return matricula;
    }

    public void setCpfAluno(String cpf) {
        this.cpf = cpf;
    }

    public String getCpfAluno() {
        return cpf;
    }

    public void setEmailAluno(String email) {
        this.email = email;
    }

    public String getEmailAluno() {
        return email;
    }

    public static void main(String[] args) {
        ArrayList<Aluno> alunosCadastrados = new ArrayList<Aluno>();
        Aluno alunoT = new Aluno("nome", 1, "email", "79589485");
        alunosCadastrados.add(alunoT);
        int x = 0;

        while (true) {
            Scanner leitor = new Scanner(System.in);
            System.out.println("\n[1] - Cadastrar Aluno");
            System.out.println("[2] - Remover Aluno");
            System.out.println("[3] - Editar dados do Aluno");
            System.out.println("[4] - Ver informações do Aluno");
            System.out.println("[5] - Gerar Boletim");
            System.out.println("[6] - Gerar Histórico Analítico");
            System.out.println("[7] - Matricular Aluno em disciplina");
            System.out.println("[8] - Sair");
            x = leitor.nextInt();

            if (x == 1) {
                System.out.print("Nome: ");
                String nome = leitor.next();

                System.out.print("Matrícula: ");
                int matricula = leitor.nextInt();

                System.out.print("CPF: ");
                String cpf = leitor.next();

                System.out.print("Email: ");
                String email = leitor.next();

                Aluno aluno1 = new Aluno(nome, matricula, email, cpf);
                alunosCadastrados.add(aluno1);
                System.out.println("Aluno adicionado!\n");
                aluno1.printAluno();
            } else if (x == 2) {
                System.out.print("Matrícula do aluno: ");
                int matricula = leitor.nextInt();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).matricula == matricula) {
                        alunosCadastrados.remove(i);
                        System.out.println("Aluno removido!\n");
                        break;
                    }
                }
            } else if (x == 3) {
                System.out.print("Matrícula do aluno: ");
                int matricula = leitor.nextInt();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).matricula == matricula) {
                        alunoT = alunosCadastrados.get(i);
                        break;
                    }
                }
                System.out.println("[0] - Editar nome");
                System.out.println("[1] - Editar email");
                int aux = leitor.nextInt();
                if (aux == 0) {
                    System.out.print("Digite o novo nome: ");
                    String new_name = leitor.next();
                    alunoT.setNomeAluno(new_name);
                    System.out.println("Informação atualizada!\n");
                } else if (aux == 1) {
                    System.out.print("Digite o novo email: ");
                    String email = leitor.next();
                    alunoT.setEmailAluno(email);
                    System.out.println("Informação atualizada!\n");
                }
            } else if (x == 4) {
                System.out.print("Matrícula do aluno: ");
                int matricula = leitor.nextInt();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).matricula == matricula) {
                        alunosCadastrados.get(i).printAluno();
                        break;
                    }
                }
            } else if (x == 5) {
                System.out.print("Matrícula do aluno: ");
                int matricula = leitor.nextInt();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).matricula == matricula) {
                        System.out.println("Boletim do aluno " + alunosCadastrados.get(i).nome);
                        alunosCadastrados.get(i).notas.add("Algebra --- 4.6 --- 72h");
                        alunosCadastrados.get(i).notas.add("logica 1 --- 7.6 --- 72h");
                        alunosCadastrados.get(i).notas.add("Programacao 1 --- 8.6 --- 144h");
                        alunosCadastrados.get(i).notas.add("Teoria da Computacao --- 9.6 --- 72h");
                        alunosCadastrados.get(i).notas.add("Sistemas de Informacao --- 10.0 --- 72h");
                        alunosCadastrados.get(i).notas.add("Calculo3 --- 5.6 --- 72h");
                        alunosCadastrados.get(i).printBoletim();
                        break;
                    }
                }

            } else if (x == 6) {
                System.out.print("Matrícula do aluno: ");
                int matricula = leitor.nextInt();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).matricula == matricula) {
                        System.out.println("Histórico do aluno " + alunosCadastrados.get(i).nome);
                        alunosCadastrados.get(i).historicoAnalitico.add("Carga Horária Cumprida --- 720h");
                        alunosCadastrados.get(i).historicoAnalitico.add("Coeficiente de Rendimento --- 82.48%");
                        alunosCadastrados.get(i).historicoAnalitico.add("1º período --- Programação 1 --- 7.3 --- AP");
                        alunosCadastrados.get(i).historicoAnalitico
                                .add("1º período --- Matemática Discreta --- 9.4 --- AP");
                        alunosCadastrados.get(i).historicoAnalitico.add("2º período --- Banco de Dados --- 10 --- AP");
                        alunosCadastrados.get(i).historicoAnalitico
                                .add("2º período --- Estrutura de Dados --- 9.4 --- AP");
                        alunosCadastrados.get(i).historicoAnalitico.add("3º período --- Àlgebra Linear --- 5.7 --- AP");
                        alunosCadastrados.get(i).historicoAnalitico
                                .add("3º período --- Teoria dos Grafos --- 3.1 --- REP");
                        alunosCadastrados.get(i).historicoAnalitico
                                .add("Eletiva --- Sistemas Distribídos --- 9.2 --- AP");
                        alunosCadastrados.get(i).printHistorico();
                        break;
                    }
                }
            } else if (x == 7) {
                System.out.print("Matrícula do aluno: ");
                int matricula = leitor.nextInt();
                System.out.print("Insira o nome da disciplina: ");
                String disciplina = leitor.next();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).matricula == matricula) {
                        alunosCadastrados.get(i).disciplinasAtuais.add(disciplina);
                        System.out.println("Disciplina inserida com sucesso!");
                        break;
                    }
                }

            } else if (x == 8) {
                break;
            } else {
                System.out.println("Opção não reconhecida, tente novamente.");
            }
        }
    }
}
