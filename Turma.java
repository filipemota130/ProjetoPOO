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

    public Turma(String id, String disciplina, ArrayList<String> dias, ArrayList<String> horarios, String professor, ArrayList<String> alunos) {
         this.id = id;
         this.disciplina = disciplina;
         this.dias = dias;
         this.horarios = horarios;
         this.professor = professor;
         this.alunos = alunos;

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
        ArrayList<Turma> turmas = new ArrayList<Turma>();
        Scanner option = new Scanner(System.in);
        while (true) {
            System.out.println("[1] - Adicionar turma;\n[2] - Editar dados da turma;\n[3] - Remover turma;\n[4] - Lista dados de uma turma;\n[5] - Listar turmas.\nSelecione um dos comandos: ");
            int num = 0;
            num = option.nextInt();
            if (num == 1) {
                String id;
                String disciplina;
                ArrayList<String> dias = new ArrayList<String>();
                ArrayList<String>  horarios = new ArrayList<String>();
                String professor;
                ArrayList<String>  alunos = new ArrayList<String>();

                System.out.println("Insira dos dados da turma:");
                System.out.print("ID da turma: ");
                id = option.next();
                System.out.print("Disciplina da turma: ");
                disciplina = option.next();
                System.out.print("Dias de aula da turma (para parar insira 'end'): ");
                int i = 0;
                while(i < 7) {
                    String value = option.next();
                    if (value.equals("end")) {
                        break;
                    }
                    dias.add(value);
                    i++;
                }
                System.out.print("Horários de aula da turma (para parar insira 'end'): ");
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
                System.out.print("Alunos da turma (para parar insira 'end'): ");
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
                System.out.print(turmas);
            }
            else if (num == 2) {
                break;
                //System.out.print("[1] - Editar ID;\n[2] - Editar disciplina;\n[3] - Editar dias de aula;\n[4] - Editar horários de aula;\n[5] - Editar professor;\n[6] - Editar alunos.\nSelecione um dos comandos: ");
            }
            else if (num == 3) {
                System.out.print("Informe o ID da turma a ser removida: ");
                String op = option.next();
                for (int i = 0; i <= turmas.size(); i++) {
                    if (turmas.get(i).id.equals(op)) {
                        turmas.remove(i);
                    }
                }
            }
            else if (num == 4) {
                break;
            }
            else if (num == 5) {
                break;
            }
            else {
                System.out.print("Input inválido. Programa encerrado.\n");
                System.exit(1);
            }
            option.close();
        }
    }
}