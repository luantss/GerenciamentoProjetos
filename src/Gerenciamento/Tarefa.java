package Gerenciamento;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Tarefa implements TarefaInterface {

    private String nomeTarefa;
    private String descricaoTarefa;
    private String prazoTarefa;
    private Projeto projeto;

    Scanner leia = new Scanner(System.in);

    public Tarefa(String nomeTarefa, String descricaoTarefa, String prazoTarefa) {
        this.nomeTarefa = nomeTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.prazoTarefa = prazoTarefa;
    }

    public Tarefa() {
        this.nomeTarefa = null;
        this.descricaoTarefa = null;
        this.prazoTarefa = null;
    }

    @Override
    public void criarTarefa(List<Tarefa> listTarefa) {
        while (true) {
            try {
                Tarefa objetoTare = new Tarefa();
                // Scanner leia = new Scanner(System.in);
                System.out.print("\nDigite o nome da tarefa: ");
                objetoTare.setNomeTarefa(leia.nextLine());
                System.out.print("\nDigite a descrição da tarefa: ");
                objetoTare.setDescricaoTarefa(leia.nextLine());
                System.out.print("\nDigite o prazo da tarefa: ");
                objetoTare.setPrazoTarefa(leia.nextLine());
                listTarefa.add(objetoTare);
                System.out.print("\n\nCadastro da tarefa realizado.");
                break;
            } catch (InputMismatchException exp) {
                System.out.print("\nCaracter inválido.");
                continue;
            }
        }
    }

    @Override
    public void listarTarefa(List<Tarefa> listTarefa) {
        int contador = 0;
        for (Tarefa in : listTarefa) {
            if (in.getProjeto() == null) {
                System.out.print(
                        "\n------------ Tarefa " + contador + " -------------" +
                        "\nPosição: " + contador +
                        "\nNome: " + in.getNomeTarefa() +
                        "\nDescrição: " + in.getDescricaoTarefa() +
                        "\nPrazo de entrega: " + in.getPrazoTarefa() +
                        "\n--------------------------------------------");
            } else {
                System.out.print(
                        "\n------------ Tarefa " + contador + " -------------" +
                        "\nPosição: " + contador +
                        "\nNome: " + in.getNomeTarefa() +
                        "\nDescrição: " + in.getDescricaoTarefa() +
                        "\nPrazo de entrega: " + in.getPrazoTarefa() +
                        "\nProjeto da tarefa: " + in.getProjeto().getNomeProjeto() +
                        "\n--------------------------------------------");
            }
            contador++;
        }
    }

    @Override
    public void editarTarefa(List<Tarefa> listTarefa) {
        while (true) {
            try {
                // Scanner leia = new Scanner(System.in);
                int index, opc;
                System.out.print("\nInsira a posição da tarefa que deseja editar informações: ");
                index = leia.nextInt();
                System.out.print(
                        "\n------------- Dados da Tarefa ------------- " +
                        "\nNome: " + listTarefa.get(index).getNomeTarefa() +
                        "\nDescrição: " + listTarefa.get(index).getDescricaoTarefa() +
                        "\nPrazo de entrega: " + listTarefa.get(index).getPrazoTarefa());
                System.out.println("\nEsta é a tarefa que deseja alterar?");
                System.out.println("\nDigite 1 para SIM\nDigite 2 para NÃO");
                opc = leia.nextInt();
                leia.nextLine();
                if (opc == 1) {
                    Tarefa objetoTarefa = new Tarefa();
                    System.out.print("\nDigite o nome da tarefa: ");
                    objetoTarefa.setNomeTarefa(leia.nextLine());
                    System.out.print("\nDigite a descrição da tarefa: ");
                    objetoTarefa.setDescricaoTarefa(leia.nextLine());
                    System.out.print("\nDigite o prazo de entrega da tarefa(dd/mm/aaaa): ");
                    objetoTarefa.setPrazoTarefa(leia.nextLine());
                    listTarefa.remove(index);
                    listTarefa.add(objetoTarefa);
                    System.out.print("\n\nEdição da tarefa realizada.");
                    break;
                } else if (opc != 1 && opc != 2) {
                    System.out.print("\nOpção inválida.");
                } else {
                    break;
                }

            } catch (InputMismatchException exCaractereInvalido) {
                System.out.print("Caractere inválido.");
                continue;
            }
        }
    }

    @Override
    public void apagarTarefa(List<Tarefa> listTarefa) {

        while (true) {
            try {
                // Scanner leia = new Scanner(System.in);
                int index, resposta;
                System.out.print("\nDigite a posição da tarefa que deseja excluir: ");
                index = leia.nextInt();
                System.out.print(
                        "\n------------- Dados do Projeto -------------" +
                                "\nNome: " + listTarefa.get(index).getNomeTarefa() +
                                "\nDescrição: " + listTarefa.get(index).getDescricaoTarefa() +
                                "\nPrazo de entrega: " + listTarefa.get(index).getPrazoTarefa());
                System.out.println("\nEsta é a tarefa que deseja excluir?");
                System.out.println("\nDigite 1 para SIM\nDigite 2 para NÃO");
                resposta = leia.nextInt();
                if (resposta == 1) {
                    listTarefa.remove(index);
                    System.out.print("\nTarefa excluída.");
                    break;
                } else if (resposta == 2) {
                    System.out.print("\n\nA tarefa não será excluida.");
                    break;
                } else if (resposta != 1 && resposta != 2) {
                    System.out.println("\nOpção inválida.");
                    break;
                }

            } catch (InputMismatchException exc) {
                System.out.print("\nCaracter inválido.");
                continue;
            }
        }
    }

    @Override
    public void relacionarTarefaProjeto(List<Tarefa> listTarefa, List<Projeto> listProjeto) {

        while (true) {
            Tarefa objetoTare = new Tarefa();
            Projeto objetoProj = new Projeto();
            int indexTarefa, indexProjeto;

            objetoTare.listarTarefa(listTarefa);
            System.out.print("\nQual TAREFA deseja relacionar a um projeto? Digite a posição: ");
            indexTarefa = leia.nextInt();

            objetoProj.listarProjeto(listProjeto);
            System.out.print("\nQual PROJETO deseja relacionar a essa tarefa? Digite a posição: ");
            indexProjeto = leia.nextInt();
            leia.nextLine();

            if (listProjeto.size() == 0) {
                System.out.print(
                        "\nNão existe nenhum projeto cadastrado, logo não é possível relacionar a tarefa ao projeto!");
                break;
            } else {
                Tarefa tarefa = listTarefa.get(indexTarefa);
                Projeto projeto = listProjeto.get(indexProjeto);
                tarefa.setProjeto(projeto);
                System.out.print("\nTarefa " + tarefa.getNomeTarefa() + " relacionada com sucesso ao projeto "
                        + projeto.getNomeProjeto());
                break;
            }

        }
    }

    public String getNomeTarefa() {
        return this.nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public String getDescricaoTarefa() {
        return this.descricaoTarefa;
    }

    public void setDescricaoTarefa(String descricaoTarefa) {
        this.descricaoTarefa = descricaoTarefa;
    }

    public String getPrazoTarefa() {
        return this.prazoTarefa;
    }

    public void setPrazoTarefa(String prazoTarefa) {
        this.prazoTarefa = prazoTarefa;
    }

    public Projeto getProjeto() {
        return this.projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

}
