package aluno;

import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {

    // Atributos.
    public String nome;
    public int matricula;
    public String email;
    public int cpf;
    ArrayList<String> notas = new ArrayList<String>();

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
                "\nE-mail: " + this.email);
    }

    // função boletim
    public void printBoletim() {
        for (int i = 0; i < notas.size(); i++) {
            System.out.println(notas.get(i));
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

    public void setCpfAluno(int cpf) {
        this.cpf = cpf;
    }

    public int getCpfAluno() {
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
        Aluno alunoT = new Aluno("nome", 1, "email", 79589485);
        alunosCadastrados.add(alunoT);
        int x = 0;

        while (true) {
            Scanner leitor = new Scanner(System.in);
            System.out.println("\n[1] - Cadastrar Aluno");
            System.out.println("[2] - Remover Aluno");
            System.out.println("[3] - Editar dados do Aluno");
            System.out.println("[4] - Ver informações do Aluno");
            System.out.println("[5] - Gerar Boletim");
            System.out.println("[6] - Sair");
            x = leitor.nextInt();

            if (x == 1) {
                System.out.println("Nome: ");
                String nome = leitor.nextLine();

                System.out.println("Matrícula: ");
                int matricula = leitor.nextInt();

                System.out.println("CPF: ");
                int cpf = leitor.nextInt();

                System.out.println("Email: ");
                String email = leitor.nextLine();

                Aluno aluno1 = new Aluno(nome, matricula, email, cpf);
                alunosCadastrados.add(aluno1);
                System.out.println("Aluno adicionado!\n");
                aluno1.printAluno();
            } else if (x == 2) {
                System.out.println("nome do aluno: ");
                String nome = leitor.next();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).nome.equals(nome)) {
                        alunosCadastrados.remove(i);
                        System.out.println("Aluno removido!\n");
                        break;
                    }
                }
            } else if (x == 3) {
                System.out.print("nome do aluno: ");
                String id = leitor.next();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).nome.equals(id)) {
                        alunoT = alunosCadastrados.get(i);
                        break;
                    }
                }
                System.out.println("0 - Editar nome");
                System.out.println("1 - Editar email");
                int aux = leitor.nextInt();
                if (aux == 0) {
                    System.out.println("Digite o novo nome: ");
                    String new_name = leitor.next();
                    alunoT.setNomeAluno(new_name);
                    System.out.println("Informação atualizada!\n");
                } else if (aux == 1) {
                    System.out.println("Digite o novo email: ");
                    String email = leitor.nextLine();
                    alunoT.setEmailAluno(email);
                    System.out.println("Informação atualizada!\n");
                }
            } else if (x == 4) {
                System.out.print("nome do aluno: ");
                String id = leitor.next();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).nome.equals(id)) {
                        alunosCadastrados.get(i).printAluno();
                        break;
                    }
                }
            } else if (x == 5) {
                System.out.println("Insira o nome do aluno desejado: ");
                String aluno_name = leitor.next();
                for (int i = 0; i < alunosCadastrados.size(); i++) {
                    if (alunosCadastrados.get(i).nome.equals(aluno_name)) {
                        System.out.println("Boletim do aluno " + alunosCadastrados.get(i).nome);
                        alunosCadastrados.get(i).notas.add("Algebra --- 4.6");
                        alunosCadastrados.get(i).notas.add("logica 1 --- 7.6");
                        alunosCadastrados.get(i).notas.add("Programacao 1 --- 8.6");
                        alunosCadastrados.get(i).notas.add("Teoria da Computacao --- 9.6");
                        alunosCadastrados.get(i).notas.add("Sistemas de Informacao --- 10.0");
                        alunosCadastrados.get(i).notas.add("Calculo3 --- 5.6");
                        alunosCadastrados.get(i).printBoletim();
                        break;
                    }
                }
            } else if (x == 6) {
                break;
            } else {
                System.out.println("Opção não reconhecida, tente novamente.");
            }
        }
    }
}