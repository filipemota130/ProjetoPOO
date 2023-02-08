import java.util.ArrayList;
import  java.util.Scanner;

public class Aluno {

    // Atributos.
    public String nome;
    public int matricula;
    public String dataNasc;
    public char sexo;
    public String etnia;
    public String email;
    public int cpf;
    public int rg;
    public int telefone;
    ArrayList<Aluno> notas = new ArrayList<Aluno>();
    

   
    // Cadastrar informações dos alunosCadastrados.
    public Aluno(String nome, int matricula, String dataNasc, char sexo, String etnia, String email, int cpf, int rg, int telefone) {
        this.nome = nome;
        this.matricula = matricula;
        this.dataNasc = dataNasc;
        this.sexo = sexo;
        this.etnia = etnia;
        this.email = email;
        this.cpf = cpf;
        this.rg = rg;
        this.telefone = telefone;
    }

    // Exibir todas as informações.
    public String printAluno() {
        return "Nome: " + this.nome +
                "\nMatrícula: " + this.nome +
                "\nRG: " + this.rg +
                "\nCPF: " + this.cpf +
                "\nData de nascimento: " + this.dataNasc +
                "\nSexo: " + this.sexo +
                "\nEtnia: " + this.etnia +
                "\nE-mail: " + this.email +
                "\nTelefone: " + this.telefone;
    }
    

    // Seção de sets.
    public void setNomeAluno(String nome) {
        this.nome = nome;
    }
    public void setMatriculaAluno(int matricula) {
        this.matricula = matricula;
    }
    public void setRgAluno(int rg) {
        this.rg = rg;
    }
    public void setCpfAluno(int cpf) {
        this.cpf = cpf;
    }
    public void setSexoAluno(char sexo) {
        this.sexo = sexo;
    }
    public void setEtniaAluno(String etnia) {
        this.etnia = etnia;
    }
    public void setDataNascAluno(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public void setEmailAluno(String email) {
        this.email = email;
    }
    public void setTelefoneAluno(int telefone) {
        this.telefone = telefone;
    }
    
    // Seção de gets.
    public String getNomeAluno() {
        return nome;
    }
    public int getMatriculaAluno() {
        return matricula;
    }
    public int getRgAluno() {
        return rg;
    }
    public int getCpfAluno() {
        return cpf;
    }
    public int getTelefoneAluno() {
        return telefone;
    }
    public char getSexoAluno() {
        return sexo;
    }
    public String getEmailAluno() {
        return email;
    }
    public String getEtniaAluno() {
        return etnia;
    }
    public String getDataNascAluno() {
        return dataNasc;
    }
    public static void main(String[] args) {
        ArrayList<Aluno> alunosCadastrados = new ArrayList<Aluno>();
        Scanner leitor = new Scanner(System.in);
        int x=0;

        while (x != 5){
            System.out.println("\n[1] - Cadastrar Aluno");
            System.out.println("[2] - Remover Aluno");
            System.out.println("[3] - Editar dados do Aluno");
            System.out.println("[4] - Ver informações do Aluno");
            System.out.println("[5] - Sair");
            x = leitor.nextInt();

            if (x == 1){
                /*
                System.out.print("\nNome: ");
                String nome = leitor.nextLine();
    
                System.out.print("\nMatrícula: ");
                int matricula = leitor.nextInt();
    
                System.out.print("\nCPF: ");
                int cpf = leitor.nextInt();
    
                System.out.print("\nRG: ");
                int rg = leitor.nextInt();
    
                System.out.print("\nData de nascimento: ");
                String dataNasc = leitor.nextLine();
    
                System.out.print("\nSexo: ");
                char sexo = leitor.nextLine().charAt(0);
    
                System.out.print("\nEtnia: ");
                String etnia = leitor.nextLine();
    
                System.out.print("\nTelefone: ");
                int telefone = leitor.nextInt();
    
                System.out.print("\nEmail: ");
                String email = leitor.nextLine(); */
    
                Aluno aluno1 = new Aluno("nome", 1234, "dataNasc", 'F', "etnia", "email", 1235, 678, 678768);
                alunosCadastrados.add(aluno1);
                System.out.println("Aluno adicionado!\n");
                System.out.println(aluno1.printAluno());
            }
            
            if (x == 2) {
                System.out.println("ID do aluno: ");
                int id = leitor.nextInt();
                alunosCadastrados.remove(id);
                System.out.println("Aluno removido!\n");
            }
    
            if (x == 3) {
                System.out.println("ID do aluno: ");
                int id = leitor.nextInt();
                System.out.println("1 - Editar telefone");
                System.out.println("2 - Editar email");
                int aux = leitor.nextInt();
                if (aux == 1) {
                    System.out.println("Digite o novo telefone: ");
                    int telefone = leitor.nextInt();
                    Aluno aluno1 = alunosCadastrados.get(id);
                    aluno1.setTelefoneAluno(telefone);
                    System.out.println("Iformação atualizada!\n");

                }
                if (aux == 2) {
                    System.out.println("Digite o novo email: ");
                    String email = leitor.nextLine();
                    Aluno aluno1 = alunosCadastrados.get(id);
                    aluno1.setEmailAluno(email);
                    System.out.println("Iformação atualizada!\n");
                }

            }

            if (x == 4) {
                System.out.println("ID do aluno: ");
                int id = leitor.nextInt();
                Aluno aluno1 = alunosCadastrados.get(id);
                System.out.println(aluno1.printAluno());
                
            }
            if (x == 5){
                System.out.println("Insira o nome do aluno desejado");
                String aluno_name = leitor.next();
                for (int i=0;i<alunosCadastrados.size();i++){
                    if (alunosCadastrados.get(i).nome.equals(aluno_name)){
                        System.out.println("Boletim do aluno" + alunosCadastrados.get(i).nome);
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
      }
        }
        
        

        leitor.close();
    }

}
