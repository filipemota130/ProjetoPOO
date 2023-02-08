import java.util.Scanner;
import java.util.ArrayList;

import jdk.nashorn.internal.runtime.arrays.ArrayLikeIterator;

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

    public static void main(String args[]) {

        ArrayList<Professor> professores = new ArrayList<Professor>();

        Scanner in = new Scanner(System.in);

        Professor prof1 = new Professor(01, "Badu", "123.456.789", "Doutor");

        System.out.println("***********Menu*********");
        System.out.println("[0] - Adicionar novo professor");
        System.out.println("[1] - editar informações");
        System.out.println("[2] - exibir informações");

        int option = in.nextInt();



        if(option == 0){//adicionar professor
            
            System.out.println("Digite o ID:\n>>");
            int id = in.nextInt();

            System.out.println("Digite o Nome:\n>>");
            String nome = in.next();

            System.out.println("Digite o CPF:\n>>");
            String cpf = in.next();

            System.out.println("Digite a Formação:\n>>");
            String formacao = in.next();

            Professor newProf = new Professor(id, nome, cpf, formacao);

            professores.add(newProf);

            newProf.printAtributos();

        }

        else if (option == 1) {/* editar infos */
            System.out.println("Qual informação deseja editar?\n");
            System.out.println("[1] - ID");
            System.out.println("[2] - Nome");
            System.out.println("[3] - CPF");
            System.out.println("[4] - Formação\n>>");

            option = in.nextInt();

            if (option == 1) {
                System.out.println("Digite o novo ID:\n>>");

                prof1.setId(in.nextInt());

            } else if (option == 2) {
                System.out.println("Digite o novo Nome:\n>>");

                prof1.setNome(in.next());

            } else if (option == 3) {
                System.out.println("Digite o novo CPF:\n>>");

                prof1.setCpf(in.next());

            }

            else if (option == 4) {
                System.out.println("Digite a nova formação:\n>>");

                prof1.setFormacao(in.next());
            }

            prof1.printAtributos();

        } else if (option == 2) {/* ver infos */

            System.out.println("***Exibindo Informações sobre o professor***\n");
            prof1.printAtributos();

        }

        



       
        

    }

    /*
     * Adicionar; Remover; Editar; Ver informações
     */

}