package turma;
import java.util.ArrayList;
import java.util.Scanner;

public class Turma 
{
    String id;
    String disciplina;
    ArrayList<String> dias;
    ArrayList<String> horarios;
    String professor;
    ArrayList<String> alunos;

    public Turma(String id, String disciplina, ArrayList<String> dias, ArrayList<String> horarios, String professor,
            ArrayList<String> alunos) {
        this.id = id;
        this.disciplina = disciplina;
        this.dias = dias;
        this.horarios = horarios;
        this.professor = professor;
        this.alunos = alunos;

    }
    public void printTurma() {
       System.out.println( "ID: " + this.id +
                "\nDisciplina: " + this.disciplina +
                "\ndias: " + this.dias +
                "\nhorários: " + this.horarios +
                "\nprofessor: " + this.professor +
               "\nalunos: " + this.alunos);
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getDisciplina() {
        return this.disciplina;
    }

    public void setDias(ArrayList<String> dias) {
        this.dias = dias;
    }

    public ArrayList<String> getDias() {
        return this.dias;
    }

    public void setHorarios(ArrayList<String> horarios) {
        this.horarios = horarios;
    }

    public ArrayList<String> getHorarios() {
        return this.horarios;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getProfessor() {
        return this.professor;
    }

    public void setAlunos(ArrayList<String> alunos) {
        this.alunos = alunos;
    }

    public ArrayList<String> getAlunos() {
        return this.alunos;
    }

    public static void main(String args[]) {
        ArrayList<String> dias1 = new ArrayList<String>();
        ArrayList<String>  horarios1 = new ArrayList<String>();
        ArrayList<String>  alunos1 = new ArrayList<String>();
        Scanner option = new Scanner(System.in);

        ArrayList<Turma> turmas = new ArrayList<Turma>();
        while (true) {
            System.out.println("\n[1] - Adicionar turma;\n[2] - Editar dados de uma turma;\n[3] - Remover turma;\n[4] - Lista dados de uma turma;\n[5] - Listar turmas.\n[6] - Encerrar programa.");
            System.out.print("Selecione um dos comandos: ");
            String input;
            input = option.next();
            if(input.equals("1")) {
                String id;
                String disciplina;
                ArrayList<String> dias = new ArrayList<String>();
                ArrayList<String>  horarios = new ArrayList<String>();
                String professor;
                ArrayList<String>  alunos = new ArrayList<String>();

                System.out.println("\nInsira os dados da turma:");
                System.out.print("ID da turma: ");
                id = option.next();
                System.out.print("Disciplina da turma: ");
                disciplina = option.next();
                System.out.print("Dias de aula da turma (para parar, insira 'end'): ");
                int i = 0;
                while(i < 7) {
                    String value = option.next();
                    if (value.equals("end")) {
                        break;
                    }
                    dias.add(value);
                    i++;
                }
                System.out.print("Horários de aula da turma (para parar, insira 'end'): ");
                i = 0;
                while(i < 14) {
                    String value = option.next();
                    if (value.equals("end")) {
                        break;
                    }
                    horarios.add(value);
                    i++;
                }
                System.out.print("Professor da turma: ");
                professor = option.next();
                System.out.print("Alunos da turma (para parar, insira 'end'): ");
                i = 0;
                while(i < 40) {
                    String value = option.next();
                    if (value.equals("end")) {
                        break;
                    }
                    alunos.add(value);
                    i++;
                }
                Turma turma1 = new Turma(id, disciplina, dias, horarios, professor, alunos);
                turmas.add(turma1);
            }
            else if (input.equals("2")) {
                Turma turmateste = new Turma(null, null, dias1, horarios1, null, alunos1);
                System.out.print("Informe a turma que deseja editar: ");
                String id = option.next();
                Boolean ne = false;
                for (int i = 0; i < turmas.size(); i++) {
                    if (turmas.get(i).id.equals(id)) {
                        turmateste = turmas.get(i);
                        ne = true;
                        break;
                    }
                    else if (ne == false) {
                        System.out.println("A turma informada não existe no sistema.\n");
                    }
                }
                System.out.print("[1] - Editar ID;\n[2] - Editar disciplina;\n[3] - Editar dias de aula;\n[4] - Editar horários de aula;\n[5] - Editar professor;\n[6] - Editar alunos.\nSelecione um dos comandos: ");
                int op = option.nextInt();
                if (op == 1) {
                    System.out.print("Insira o novo 'ID': ");
                    turmateste.setId(option.next());

                } else if (op == 2) {
                    System.out.print("Insira o novo 'disciplina': ");
                    turmateste.setDisciplina(option.next());

                } else if (op == 3) {
                    ArrayList<String> lista = new ArrayList<String>();
                    System.out.print("Insira os novos dias de aula da turma (para parar, insira 'end'): ");
                    int i = 0;
                    while (i < 14) {
                        String value = option.next();
                        if (value.equals("end")) {
                            break;
                        }
                        lista.add(value);
                        i++;
                    }
                    turmateste.setDias(lista);
                } else if (op == 4) {
                    ArrayList<String> lista = new ArrayList<String>();
                    System.out.print("Insira os novos horários de aula da turma (para parar, insira 'end'): ");
                    int i = 0;
                    while (i < 14) {
                        String value = option.next();
                        if (value.equals("end")) {
                            break;
                        }
                        lista.add(value);
                        i++;
                    }
                    turmateste.setHorarios(lista);
                }
                else if (op == 5) {
                    System.out.print("Insira o(a) novo(a) professor(a) da turma: ");
                    turmateste.setProfessor(option.next());
                }
                else if (op == 6) {
                    ArrayList<String> lista = new ArrayList<String>();
                    System.out.print("Insira os novos alunos da turma (para parar, insira 'end'): ");
                    int i = 0;
                    while (i < 14) {
                        String value = option.next();
                        if (value.equals("end")) {
                            break;
                        }
                        lista.add(value);
                        i++;
                    }
                    turmateste.setAlunos(lista);
                }
            }
            else if (input.equals("3")) {
                System.out.print("\nInforme o ID da turma a ser removida: ");
                String op = option.next();
                for (int i = 0; i < turmas.size(); i++) {
                    if (turmas.get(i).id.equals(op)) {
                        turmas.remove(i);
                        System.out.printf("A turma %s foi removida do sistema.\n", i);
                    }
                }
            }
            else if (input.equals("4")) {
                System.out.print("\nInforme o ID da turma a ser buscada: ");
                String src = option.next();
                int ne = 0;
                for (int i = 0; i < turmas.size(); i++) {
                    if (turmas.get(i).id.equals(src)) {
                        turmas.get(i).printTurma();
                        ne += 1;
                        break;
                    }
                }
                if (ne == 0) {
                    System.out.println("A turma informada não existe no sistema.");    
                }
                
            }
            else if (input.equals("5")) { 
                System.out.println("\nTurmas cadastradas:");
                for (int i = 0; i < turmas.size(); i++) {
                    System.out.printf("[%s] - %s\n", turmas.get(i).id, turmas.get(i).disciplina);
                }
                
            }
            else if (input.equals("6")) {
                System.out.print("\nPrograma encerrado.\n\n");
                break;
            }
            else {
                System.out.print("\nInput inválido.\n");
            }
        }
        option.close();
    } 
    
}