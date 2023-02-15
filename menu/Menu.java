package menu;

import professor.Professor;
import turma.Turma;
import java.util.ArrayList;
import java.util.Scanner;
import aluno.Aluno;

public class Menu {
    public void undoRedo(ArrayList<String> OP1, ArrayList<String> OP2, ArrayList<Professor> professores,
            ArrayList<Professor> professores_removidos, ArrayList<Professor> professores_pre_editados,
            ArrayList<Professor> professores_editados, ArrayList<Aluno> alunos, ArrayList<Aluno> alunos_removidos,
            ArrayList<Aluno> alunos_pre_editados, ArrayList<Aluno> alunos_editados, ArrayList<Turma> turmas,
            ArrayList<Turma> turmas_removidas, ArrayList<Turma> turmas_pre_editadas, ArrayList<Turma> turmas_editadas) {
        
            String operation = OP1.get(OP1.size() - 1);
            String[] comando = operation.split(":");
            if (comando[0].equals("add")) {
                if (comando[1].equals("prof")) {
                    professores_removidos.add(professores.get(professores.size() - 1));
                    professores.remove(professores.size() - 1);
                    OP2.add("rm:prof");
                } else if (comando[1].equals("aluno")) {
                    alunos_removidos.add(alunos.get(alunos.size() - 1));
                    alunos.remove(alunos.size() - 1);
                    OP2.add("rm:aluno");
                } else if (comando[1].equals("turma")){
                    turmas_removidas.add(turmas.get(turmas.size() - 1));
                    turmas.remove(turmas.size() - 1);
                    OP2.add("rm:turma");
                }
                else{

                }
            } else if (comando[0].equals("rm")) {
                if (comando[1].equals("prof")) {
                    professores.add(professores_removidos.get(professores_removidos.size() - 1));
                    professores_removidos.remove(professores.size() - 1);
                    OP2.add("add:prof");
                } else if (comando[1].equals("aluno")) {
                    alunos.add(alunos_removidos.get(alunos_removidos.size() - 1));
                    alunos_removidos.remove(alunos_removidos.size() - 1);
                    OP2.add("add:aluno");
                } else if (comando[1].equals("turma")) {
                    turmas.add(turmas_removidas.get(turmas_removidas.size() - 1));
                    turmas_removidas.remove(turmas_removidas.size() - 1);
                    OP2.add("add:turma");
                }
                else{
                    turmas.add(turmas_removidas.get(turmas_removidas.size() - 1));
                    turmas_removidas.remove(turmas_removidas.size() - 1);
                    OP2.add("add:mat");
                }
            } else if (comando[0].equals("edit")) {
                if (comando[1].equals("prof")) {
                    if (comando[2].equals("undo")) {
                        Professor buscador = professores_pre_editados.get(professores_pre_editados.size() - 1);
                        for (int i = 0; i < professores.size(); i++) {
                            if (professores.get(i).getId() == (buscador.getId())) {
                                professores_editados.add(professores.get(i));
                                professores.remove(i);
                                professores.add(buscador);
                                break;
                            }
                        }
                        professores_pre_editados.remove(professores_pre_editados.size() - 1);
                        OP2.add("edit:prof:redo");
                    } else {
                        Professor buscador = professores_editados.get(professores_editados.size() - 1);
                        for (int i = 0; i < professores.size(); i++) {
                            if (professores.get(i).getId() == (buscador.getId())) {
                                professores_pre_editados.add(professores.get(i));
                                professores.remove(i);
                                professores.add(buscador);
                                break;
                            }
                        }
                        professores_editados.remove(professores_editados.size() - 1);
                        OP2.add("edit:prof:undo");
                    }
                } else if (comando[1].equals("aluno")) {
                    if (comando[2].equals("undo")) {
                        Aluno buscador = alunos_pre_editados.get(alunos_pre_editados.size() - 1);
                        for (int i = 0; i < alunos.size(); i++) {
                            if (alunos.get(i).getMatricula() == (buscador.getMatricula())) {
                                alunos_editados.add(alunos.get(i));
                                alunos.remove(i);
                                alunos.add(buscador);
                                break;
                            }
                        }
                        alunos_pre_editados.remove(alunos_pre_editados.size() - 1);
                        OP2.add("edit:aluno:redo");
                    } else {
                        Aluno buscador = alunos_editados.get(alunos_editados.size() - 1);
                        for (int i = 0; i < alunos.size(); i++) {
                            if (alunos.get(i).getMatricula() == (buscador.getMatricula())) {
                                alunos_pre_editados.add(alunos.get(i));
                                alunos.remove(i);
                                alunos.add(buscador);
                                break;
                            }
                        }
                        alunos_editados.remove(alunos_editados.size() - 1);
                        OP2.add("edit:aluno:undo");
                    }
                } else {
                    if (comando[2].equals("undo")) {
                        Turma buscador = turmas_pre_editadas.get(turmas_pre_editadas.size() - 1);
                        for (int i = 0; i < turmas.size(); i++) {
                            if (turmas.get(i).getId() == (buscador.getId())) {
                                turmas_editadas.add(turmas.get(i));
                                turmas.remove(i);
                                turmas.add(buscador);
                                break;
                            }
                        }
                        turmas_pre_editadas.remove(turmas_pre_editadas.size() - 1);
                        OP2.add("edit:turma:redo");
                    } else {
                        Turma buscador = turmas_editadas.get(turmas_editadas.size() - 1);
                        for (int i = 0; i < turmas.size(); i++) {
                            if (turmas.get(i).getId() == (buscador.getId())) {
                                turmas_pre_editadas.add(turmas.get(i));
                                turmas.remove(i);
                                turmas.add(buscador);
                                break;
                            }
                        }
                        turmas_editadas.remove(turmas_editadas.size() - 1);
                        OP2.add("edit:turma:undo");
                    }
                }
            }
        OP1.remove(OP1.size() - 1);
    }
    public static void main(String args[]) {
        ArrayList<String> undoList = new ArrayList<String>();
        ArrayList<String> redoList = new ArrayList<String>();

        ArrayList<Turma> turmas = new ArrayList<Turma>();
        ArrayList<Professor> professores = new ArrayList<Professor>();
        ArrayList<Aluno> alunos = new ArrayList<Aluno>();

        ArrayList<Professor> professores_removidos = new ArrayList<Professor>();
        ArrayList<Aluno> alunos_removidos = new ArrayList<Aluno>();
        ArrayList<Turma> turmas_removidas = new ArrayList<Turma>();

        ArrayList<Professor> professores_pre_editados = new ArrayList<Professor>();
        ArrayList<Aluno> alunos_pre_editados = new ArrayList<Aluno>();
        ArrayList<Turma> turmas_pre_editadas = new ArrayList<Turma>();

        ArrayList<Professor> professores_editados = new ArrayList<Professor>();
        ArrayList<Aluno> alunos_editados = new ArrayList<Aluno>();
        ArrayList<Turma> turmas_editadas = new ArrayList<Turma>();

        Aluno alunoT = new Aluno("nome", 10, "email", 79589485);
        alunos.add(alunoT);
        Professor prof1 = new Professor(10, "Badu", "123.456.789", "Doutor");
        Scanner leitor = new Scanner(System.in);
        while(true){
            System.out.println("[1] - Turmas");
            System.out.println("[2] - Professores");
            System.out.println("[3] - Alunos");
            System.out.println("[4] - Desfazer ultima ação");
            System.out.println("[5] - Resfazer ultima ação");
            System.out.println("[6] - Sair");
            System.out.print("Selecione um dos comandos: ");
            int x = 0;
            x = leitor.nextInt();
            if (x == 2) { //PROFESSOR
                System.out.println("[1] - Adicionar novo professor");
                System.out.println("[2] - editar informações");
                System.out.println("[3] - exibir informações");
                System.out.println("[4] - Remover professor");
                System.out.print("Selecione um dos comandos: ");
                int option = leitor.nextInt();

                if (option == 1) {//adicionar professor
                    System.out.println("Digite o ID:");
                    int id = leitor.nextInt();
                    boolean check = false;
                    for (int i =0; i<professores.size();i++){
                        if(professores.get(i).getId() == id){
                            System.out.println("Id já existente!!");
                            check=true;
                            break;
                        }
                    }
                    if(check){
                        continue;
                    }
                    System.out.println("Digite o Nome:");
                    String nome = leitor.next();

                    System.out.println("Digite o CPF:");
                    String cpf = leitor.next();

                    System.out.println("Digite a Formação:");
                    String formacao = leitor.next();
                    Professor newProf = new Professor(id, nome, cpf, formacao);
                    professores.add(newProf);
                    undoList.add("add:prof:undo");
                    newProf.printAtributos();
                }
                else if (option == 2) {/* editar infos */
                    System.out.print("ID do professor: ");
                    int id = leitor.nextInt();
                    for (int i = 0; i < professores.size(); i++) {
                        if (professores.get(i).getId()==id) {
                            prof1 = professores.get(i);
                            break;
                        }
                    }
                    System.out.println("Qual informação deseja editar?\n");
                    System.out.println("[1] - Nome");
                    System.out.println("[2] - CPF");
                    System.out.println("[3] - Formação\n>>");
                    option = leitor.nextInt();
                    Professor edit = new Professor(prof1.getId(),prof1.getNome(),prof1.getCpf(),prof1.getFormacao());
                    professores_pre_editados.add(edit);
                    if (option == 1) {
                        System.out.println("Digite o novo Nome:\n>>");
                        prof1.setNome(leitor.next());
                    } else if (option == 2) {
                        System.out.println("Digite o novo CPF:\n>>");
                        prof1.setCpf(leitor.next());
                    } else if (option == 3) {
                        System.out.println("Digite a nova formação:\n>>");
                        prof1.setFormacao(leitor.next());
                    }
                    undoList.add("edit:prof:undo");
                    prof1.printAtributos();


                } else if (option == 3) {/* ver infos */
                    System.out.print("ID do professor: ");
                    int id = leitor.nextInt();
                    for (int i = 0; i < professores.size(); i++) {
                        if (professores.get(i).getId()==id){
                            professores.get(i).printAtributos();
                            break;
                        }
                    }
                } else if (option == 4) {/* remover */
                    System.out.print("ID do professor: ");
                    int id = leitor.nextInt();
                    for (int i = 0; i < professores.size(); i++) {
                        if (professores.get(i).getId()==id){
                            Professor toBeRemoved = new Professor(professores.get(i).getId(),professores.get(i).getNome(), professores.get(i).getCpf(), professores.get(i).getFormacao());
                            professores_removidos.add(toBeRemoved);
                            professores.remove(i);
                            System.out.println("Professor removido.");
                            undoList.add("rm:prof:undo");
                            break;
                        }
                    }
                }
            } else if (x == 3) { //ALUNO
                System.out.println("\n[1] - Cadastrar Aluno");
                System.out.println("[2] - Remover Aluno");
                System.out.println("[3] - Editar dados do Aluno");
                System.out.println("[4] - Ver informações do Aluno");
                System.out.println("[5] - Gerar Boletim");
                System.out.println("[6] - Gerar Histórico Analítico");
                System.out.println("[7] - Matricular aluno em disciplina");
                System.out.println("[8] - Listar disciplinas");
                System.out.println("[9] - Sair");
                x = leitor.nextInt();

                if (x == 1) { //Adicionar
                    System.out.println("Nome: ");
                    String nome = leitor.next();

                    System.out.println("Matrícula: ");
                    int matricula = leitor.nextInt();

                    System.out.println("CPF: ");
                    int cpf = leitor.nextInt();

                    System.out.println("Email: ");
                    String email = leitor.next();

                    Aluno aluno1 = new Aluno(nome, matricula, email, cpf);
                    alunos.add(aluno1);
                    System.out.println("Aluno adicionado!\n");
                    aluno1.printAluno();
                    undoList.add("add:aluno:undo");
                } else if (x == 2) { // Remover
                    System.out.println("Matrícula do aluno: ");
                    int id = leitor.nextInt();
                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula()==id){
                            alunos_removidos.add(alunos.get(i));
                            alunos.remove(i);
                            System.out.println("Aluno removido!\n");
                            undoList.add("rm:aluno:undo");
                            break;
                        }
                    }
                } else if (x == 3) { //Editar
                    System.out.println("Matrícula do aluno: ");
                    int id = leitor.nextInt();
                    boolean check =false;
                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula()==id){
                            alunoT = alunos.get(i);
                            check=true;
                            break;
                        }
                    }
                    if (!check){
                        System.out.println("Aluno inexistente.");
                        continue;
                    }
                    Aluno edit = new Aluno(alunoT.getNome(), alunoT.getMatricula(), alunoT.getEmail(), alunoT.getCpf());
                    alunos_pre_editados.add(edit);
                    System.out.println("0 - Editar nome");
                    System.out.println("1 - Editar email");
                    System.out.println("2 - Trancar curso");
                    System.out.println("3 - Reabrir curso");
                    int aux = leitor.nextInt();
                    if (aux == 0) {
                        System.out.println("Digite o novo nome: ");
                        String new_name = leitor.next();
                        alunoT.setNome(new_name);
                        System.out.println("Informação atualizada!\n");
                    } else if (aux == 1) {
                        System.out.println("Digite o novo email: ");
                        String email = leitor.next();
                        alunoT.setEmail(email);
                        System.out.println("Informação atualizada!\n");
                    } else if (aux == 2) {
                        System.out.println("Deseja continuar(S/N)?");
                        String resp = leitor.next();
                        if (resp.equals("S") || resp.equals("s")) {
                            alunoT.setStatusCurso(false);
                            System.out.println("Informação atualizada!\n");
                        } else {
                            System.out.println("Operação cancelada.\n");
                        }
                    } else if (aux == 3) {
                        if (alunoT.getStatusCurso()==false){
                            System.out.println("Bem vindo(a), novamente!\n");
                            edit.setStatusCurso(false);
                            alunoT.setStatusCurso(true);
                        }
                        System.out.println("Sua matricula nao está trancada\n");
                    }
                    undoList.add("edit:aluno:undo");
                } else if (x == 4) {
                    System.out.println("Matrícula do aluno: ");
                    int id = leitor.nextInt();
                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula()==id){
                            alunos.get(i).printAluno();
                            break;
                        }
                    }
                } else if (x == 5) {
                    System.out.println("Matrícula do aluno: ");
                    int id = leitor.nextInt();
                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula()==id){
                            System.out.println("Boletim do aluno " + alunos.get(i).nome);
                            alunos.get(i).notas.add("Algebra --- 4.6 --- 72h");
                            alunos.get(i).notas.add("logica 1 --- 7.6 --- 72h");
                            alunos.get(i).notas.add("Programacao 1 --- 8.6 --- 144h");
                            alunos.get(i).notas.add("Teoria da Computacao --- 9.6 --- 72h");
                            alunos.get(i).notas.add("Sistemas de Informacao --- 10.0 --- 72h");
                            alunos.get(i).notas.add("Calculo3 --- 5.6 --- 72h");
                            alunos.get(i).printBoletim();
                            break;
                        }
                    }
                } else if (x == 6) {
                    System.out.println("Matrícula do aluno: ");
                    int id = leitor.nextInt();
                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula()==id){
                            System.out.println("Histórico do aluno " + alunos.get(i).nome);
                            alunos.get(i).historicoAnalitico.add("Carga Horária Cumprida --- 720h");
                            alunos.get(i).historicoAnalitico.add("Coeficiente de Rendimento --- 82.48%");
                            alunos.get(i).historicoAnalitico.add("1º período --- Programação 1 --- 7.3 --- AP");
                            alunos.get(i).historicoAnalitico
                                    .add("1º período --- Matemática Discreta --- 9.4 --- AP");
                            alunos.get(i).historicoAnalitico.add("2º período --- Banco de Dados --- 10 --- AP");
                            alunos.get(i).historicoAnalitico
                                    .add("2º período --- Estrutura de Dados --- 9.4 --- AP");
                            alunos.get(i).historicoAnalitico.add("3º período --- Àlgebra Linear --- 5.7 --- AP");
                            alunos.get(i).historicoAnalitico
                                    .add("3º período --- Teoria dos Grafos --- 3.1 --- REP");
                            alunos.get(i).historicoAnalitico
                                    .add("Eletiva --- Sistemas Distribídos --- 9.2 --- AP");
                            alunos.get(i).printHistorico();
                            break;
                        }
                    }
                } else if (x == 7) { //Matricula
                    System.out.print("Matrícula do aluno: ");
                    int id = leitor.nextInt();
                    System.out.print("Insira o nome da disciplina: ");
                    String disciplina = leitor.next();
                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula()==id) {
                            Aluno aluno_pre = new Aluno(alunos.get(i).getNome(), alunos.get(i).getMatricula(), alunos.get(i).getEmail(), alunos.get(i).getCpf());
                            alunos_pre_editados.add(aluno_pre);
                            alunos.get(i).disciplinasAtuais.add(disciplina);
                            undoList.add("edit:aluno:undo");
                            System.out.println("Disciplina inserida com sucesso!");
                            break;
                        }
                    }
                }
                else if (x == 8) { //listar disciplinas
                    System.out.println("Matrícula do aluno: ");
                    int id = leitor.nextInt();
                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula()==id){
                            alunos.get(i).printDisciplina();
                            break;
                        }
                    }
                }
                else if (x == 9) {
                    continue;
                }
                else {
                    System.out.println("Opção não reconhecida, tente novamente.");
                }
            } else if (x == 1) { // TURMA
                System.out.println("\n[1] - Adicionar turma;\n[2] - Editar dados de uma turma;\n[3] - Remover turma;\n[4] - Lista dados de uma turma;\n[5] - Listar turmas.");
                System.out.print("Selecione um dos comandos: ");
                String input;
                input = leitor.next();
                if (input.equals("1")) {
                    String id;
                    String disciplina;
                    ArrayList<String> dias = new ArrayList<String>();
                    ArrayList<String> horarios = new ArrayList<String>();
                    String professor;
                    ArrayList<String> alunos1 = new ArrayList<String>();

                    System.out.println("\nInsira os dados da turma:");
                    System.out.print("ID da turma: ");
                    id = leitor.next();
                    System.out.print("Disciplina da turma: ");
                    disciplina = leitor.next();
                    System.out.print("Dias de aula da turma (para parar, insira 'end'): ");
                    int i = 0;
                    while (i < 7) {
                        String value = leitor.next();
                        if (value.equals("end")) {
                            break;
                        }
                        dias.add(value);
                        i++;
                    }
                    System.out.print("Horários de aula da turma (para parar, insira 'end'): ");
                    i = 0;
                    while (i < 14) {
                        String value = leitor.next();
                        if (value.equals("end")) {
                            break;
                        }
                        horarios.add(value);
                        i++;
                    }
                    System.out.print("Professor da turma: ");
                    professor = leitor.next();
                    System.out.print("Alunos da turma (para parar, insira 'end'): ");
                    i = 0;
                    while (i < 40) {
                        String value = leitor.next();
                        if (value.equals("end")) {
                            break;
                        }
                        alunos1.add(value);
                        i++;
                    }
                    Turma turma1 = new Turma(id, disciplina, dias, horarios, professor, alunos1);
                    undoList.add("add:turma:undo");
                    turmas.add(turma1);
                    System.out.println("Turma adicionada!\n");
                } else if (input.equals("2")) {
                    ArrayList<String> dias1 = new ArrayList<String>();
                    ArrayList<String> horarios1 = new ArrayList<String>();
                    ArrayList<String> alunos1 = new ArrayList<String>();
                    Turma turmateste = new Turma(null, null, dias1, horarios1, null, alunos1);
                    System.out.print("Informe o ID da turma que deseja editar: ");
                    String id = leitor.next();
                    Boolean ne = false;
                    for (int i = 0; i < turmas.size(); i++) {
                        if (turmas.get(i).getId().equals(id)) {
                            turmateste = turmas.get(i);
                            ne = true;
                            break;
                        }
                    }
                    if (ne == false) {
                        System.out.println("A turma informada não existe no sistema.\n");
                        continue;
                    }
                    Turma turmaUndo = new Turma(turmateste.getId(),turmateste.getDisciplina(), turmateste.getDias(),turmateste.getHorarios(), turmateste.getProfessor(), turmateste.getAlunos());
                    turmas_pre_editadas.add(turmaUndo);
                    undoList.add("edit:turma:undo");
                    System.out.print(
                            "[1] - Editar disciplina;\n[2] - Editar dias de aula;\n[3] - Editar horários de aula;\n[4] - Editar professor;\n[5] - Editar alunos.\nSelecione um dos comandos: ");
                    int op = leitor.nextInt();
                    if (op == 1) {
                        System.out.print("Insira o novo 'disciplina': ");
                        turmateste.setDisciplina(leitor.next());
                    } else if (op == 2) {
                        ArrayList<String> lista = new ArrayList<String>();
                        System.out.print("Insira os novos dias de aula da turma (para parar, insira 'end'): ");
                        int i = 0;
                        while (i < 14) {
                            String value = leitor.next();
                            if (value.equals("end")) {
                                break;
                            }
                            lista.add(value);
                            i++;
                        }
                        turmateste.setDias(lista);
                    } else if (op == 3) {
                        ArrayList<String> lista = new ArrayList<String>();
                        System.out.print("Insira os novos horários de aula da turma (para parar, insira 'end'): ");
                        int i = 0;
                        while (i < 14) {
                            String value = leitor.next();
                            if (value.equals("end")) {
                                break;
                            }
                            lista.add(value);
                            i++;
                        }
                        turmateste.setHorarios(lista);
                    } else if (op == 4) {
                        System.out.print("Insira o(a) novo(a) professor(a) da turma: ");
                        turmateste.setProfessor(leitor.next());
                    } else if (op == 5) {
                        ArrayList<String> lista = new ArrayList<String>();
                        System.out.print("Insira os novos alunos da turma (para parar, insira 'end'): ");
                        int i = 0;
                        while (i < 14) {
                            String value = leitor.next();
                            if (value.equals("end")) {
                                break;
                            }
                            lista.add(value);
                            i++;
                        }
                        turmateste.setAlunos(lista);
                    }
                    System.out.println("Dados da turma editados com sucesso!");

                } else if (input.equals("3")) {
                    System.out.print("\nInforme o ID da turma a ser removida: ");
                    String op = leitor.next();
                    for (int i = 0; i < turmas.size(); i++) {
                        if (turmas.get(i).getId().equals(op)) {
                            turmas_removidas.add(turmas.get(i));
                            undoList.add("rm:turma:undo");
                            turmas.remove(i);
                            System.out.printf("A turma %s foi removida do sistema.\n", i);
                        }
                    }
                } else if (input.equals("4")) {
                    System.out.print("\nInforme o ID da turma a ser buscada: ");
                    String src = leitor.next();
                    int ne = 0;
                    for (int i = 0; i < turmas.size(); i++) {
                        if (turmas.get(i).getId().equals(src)) {
                            turmas.get(i).printTurma();
                            ne += 1;
                            break;
                        }
                    }
                    if (ne == 0) {
                        System.out.println("A turma informada não existe no sistema.");
                    }
                } else if (input.equals("5")) {
                    System.out.println("\nTurmas cadastradas:");
                    for (int i = 0; i < turmas.size(); i++) {
                        System.out.printf("[%s] - %s\n", turmas.get(i).getId(), turmas.get(i).getDisciplina());
                    }
                    System.out.println("\n");
                } else {
                    System.out.print("\nInput inválido.\n");
                }
            }
            else if (x == 4) { //UNDO
                Menu menu = new Menu();
                if (undoList.size() > 0) {
                    menu.undoRedo(undoList, redoList, professores, professores_removidos, professores_pre_editados,
                            professores_editados, alunos, alunos_removidos, alunos_pre_editados,
                            alunos_editados, turmas, turmas_removidas, turmas_pre_editadas, turmas_editadas);
                    System.out.println("Ultima operação desfeita!");
                }
                else{
                    System.out.println("Não há ações a serem desfeitas.");
                }
            }
            else if (x == 5) {
                Menu menu = new Menu();
                if (redoList.size() > 0) {
                    menu.undoRedo(redoList, undoList, professores, professores_removidos, professores_pre_editados,
                            professores_editados, alunos, alunos_removidos, alunos_pre_editados,
                            alunos_editados, turmas, turmas_removidas, turmas_pre_editadas, turmas_editadas);
                    System.out.println("Ultima operação refeita!");
                } 
                else{
                    System.out.println("Não há ações a serem refeitas.");
                }
            }
            else if (x == 6) {
                break;
            }
        }
        leitor.close();
    }
}