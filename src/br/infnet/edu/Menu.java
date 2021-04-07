package br.infnet.edu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private static List<Curso> cursoList = new ArrayList<>();
    private static List<Turma> turmaList = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("Escolha uma opção:");
        System.out.println("1. Cadastro");
        System.out.println("2. Editar");
        System.out.println("3. Excluir");
        System.out.println("4. Listar");
        System.out.println("q --> Sair");

        Scanner scnMenu = new Scanner(System.in);
        String opcao = scnMenu.nextLine();

        try{
            do{
                switch (opcao.charAt(0)){
                    //cadastrar
                    case '1': {
                        System.out.println("Escolha o que cadastrar:");
                        System.out.println("1. Cadastrar Curso");
                        System.out.println("2. Cadastrar Turma");
                        System.out.println("3. Cadastrar Bloco");
                        System.out.println("4. Cadastrar Disciplinas");

                        Scanner scnCadastro = new Scanner(System.in);
                        String opCad = scnCadastro.nextLine();
                        switch (opCad.charAt(0)){
                            case '1': {
                                System.out.println("Entre com o código do curso:");
                                String codCurso = scnCadastro.nextLine();
                                System.out.println("Entre com o nome do curso:");
                                String nomeCurso = scnCadastro.nextLine();
                                System.out.println("Entre com a capacidade do curso:");
                                int capCursp = scnCadastro.nextInt();

                                Curso cr = new Curso(codCurso,nomeCurso, capCursp);

                                cursoList.add(cr);
                                break;
                            }
                            case '2': {
                                System.out.println("Entre com o nome da turma:");
                                String nomeTr = scnCadastro.nextLine();
                                System.out.println("Entre com a capacidade da turma:");
                                int capTr = scnCadastro.nextInt();

                                Turma tr = new Turma(nomeTr, capTr);

                                turmaList.add(tr);
                                break;
                            }
                        }
                        break;
                    }
                    //editar
                    case '2': {
                        System.out.println("Selecione o que editar:");
                        System.out.println("1. Editar Curso");
                        System.out.println("2. Editar Turma");
                        System.out.println("3. Editar Bloco");
                        System.out.println("4. Editar Disciplinas");

                        Scanner scnEditar = new Scanner(System.in);
                        String opEdit = scnEditar.nextLine();

                        switch (opEdit.charAt(0)){
                            case '1':{
                                System.out.println("Selecione o código do curso que irá editar:");
                                for (Curso cr: cursoList){
                                    System.out.println("Cód.: " + cr.getCodCurso() + " | Nome do curso: " + cr.getCurso());
                                }
                                Scanner scnEdCurso = new Scanner(System.in);
                                String codEdit = scnEdCurso.nextLine();

                                int index = -1;
                                for (Curso cr : cursoList){
                                    if (cr.getCodCurso() == codEdit){
                                        index = cursoList.indexOf(cr);
                                    }
                                }

                                Curso newCurso = cursoList.get(index);

                                if (newCurso != null){
                                    System.out.println("Entre com o novo nome do curso ou mantenha: " + newCurso.getCurso());
                                    String newNome = scnEdCurso.nextLine();
                                    if (!newNome.equals("")){
                                        newCurso.setCurso(newNome);
                                    }
                                    System.out.println("Entre com uma nova capacidade ou mantenha: " + newCurso.getCapacidade());
                                    String newCapacidade = scnEdCurso.nextLine();
                                    if (!newCapacidade.equals("")){
                                        newCurso.setCapacidade(Integer.parseInt(newCapacidade));
                                    }


                                }else{
                                    System.out.println("Curso não encontrado.");
                                }
                                break;
                            }
                        }
                        break;
                    }
                    //excluir
                    case '3': {
                        System.out.println("Selecione o que deseja excluir:");
                        System.out.println("1. Excluir Curso");
                        System.out.println("2. Excluir Turma");
                        System.out.println("3. Excluir Bloco");
                        System.out.println("4. Excluir Disciplinas");

                        Scanner scnExcluir = new Scanner(System.in);
                        String opExcluir = scnExcluir.nextLine();

                        switch (opExcluir.charAt(0)){
                            case '1':{
                                System.out.println("Selecione o código do curso que deseja exluir:");
                                for (Curso cr: cursoList){
                                    System.out.println("Código do curso: " + cr.getCodCurso() + " | Nome do curso: " + cr.getCurso());
                                }

                                Scanner scnExcCurso = new Scanner(System.in);
                                String crExlCr = scnExcluir.nextLine();

                                int index = -1;
                                for (Curso cr: cursoList){
                                    if (cr.getCurso() == crExlCr){
                                        index = cursoList.indexOf(cr);
                                    }
                                }
                                //exluindo
                                cursoList.remove(index);
                            }
                        }
                        break;
                    }
                    //listar
                    case '4': {
                        System.out.println("Selecione o que deseja listar: ");
                        System.out.println("1. Listar Curso");
                        System.out.println("2. Listar Turma");
                        System.out.println("3. Listar Bloco");
                        System.out.println("4. Listar Disciplinas");

                        Scanner scnLs = new Scanner(System.in);
                        String opLs = scnLs.nextLine();

                        switch (opLs.charAt(0)){
                            case '1': {
                                for (Curso cr : cursoList){
                                    System.out.println("Curso: " + cr.getCurso() + " | Código: " + cr.getCodCurso() + " | Capacidade: " + cr.getCapacidade());
                                }
                            }
                        }
                        break;
                    }
                    case 'q' : {
                        System.out.println("Inté");
                        System.exit(0);
                    }
                }

            }while (!opcao.equals("q"));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
