package turma;
import java.util.ArrayList;
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
}