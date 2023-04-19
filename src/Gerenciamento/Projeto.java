package Gerenciamento;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Projeto implements ProjetoInterface{
   
    private String nomeProjeto;
    private String descricaoProjeto;
    private String prazoEntregaProjeto;
    
    Scanner leia = new Scanner(System.in);

    public Projeto(String nomeProjeto, String descricaoProjeto, String prazoEntregaProjeto) {
        this.nomeProjeto = nomeProjeto; 
        this.descricaoProjeto = descricaoProjeto;
        this.prazoEntregaProjeto = prazoEntregaProjeto;
    }
    
    public Projeto() {
        this.nomeProjeto = null;
        this.descricaoProjeto = null;
        this.prazoEntregaProjeto = null;
    }

    @Override
    public void criarProjeto(List<Projeto> listProj) {
        while(true) {
            try {
                Projeto objetoProj = new Projeto();
                System.out.print("\nDigite o nome do projeto: ");
                objetoProj.setNomeProjeto(leia.nextLine());
                System.out.print("\nDigite a descrição do projeto: ");
                objetoProj.setDescricaoProjeto(leia.nextLine());
                System.out.print("\nDigite o prazo de entrega do projeto(dd/mm/aaaa): ");
                objetoProj.setPrazoEntregaProjeto(leia.nextLine());
                listProj.add(objetoProj);
                System.out.print("\n\nCadastro do projeto realizado.");
                break;

            } catch (InputMismatchException exCaractereInvalido) {
                System.out.print("\nCaractere inválido.");
                continue;
            }
        }
    }

    @Override
    public void listarProjeto(List<Projeto> listProj) {
        int contador = 0;
        for(Projeto in : listProj) {
            System.out.print(
                "\n------------ Projeto " + contador + " -------------" +
                "\nPosição: "+contador+
                "\nNome: "+in.getNomeProjeto()+
                "\nDescrição: "+in.getDescricaoProjeto()+
                "\nPrazo de entrega: "+in.getPrazoEntregaProjeto()+
                "\n--------------------------------------------");
            contador++;
        }
    }

    @Override
    public void editarProjeto(List<Projeto> listaProj) {
        while(true) {
            try {
                int index, opc;
                System.out.print("\nInsira a posição do projeto que deseja editar informações: ");
                index = leia.nextInt();
                System.out.print(
                    "\n------------- Dados do Projeto ------------- "+
                    "\nNome: "+listaProj.get(index).getNomeProjeto()+
                    "\nDescrição: "+listaProj.get(index).getDescricaoProjeto()+
                    "\nPrazo: "+listaProj.get(index).getPrazoEntregaProjeto()
                );
                System.out.println("\nEste é o projeto que deseja alterar?");
				System.out.println("\nDigite 1 para SIM\nDigite 2 para NÃO");
                opc = leia.nextInt();
                leia.nextLine();
                if(opc == 1) {
                    Projeto objetoProj = new Projeto();
                    System.out.print("\nDigite o nome do projeto: ");
                    objetoProj.setNomeProjeto(leia.nextLine());
                    System.out.print("\nDigite a descrição do projeto: ");
                    objetoProj.setDescricaoProjeto(leia.nextLine());
                    System.out.print("\nDigite o prazo de entrega do projeto(dd/mm/aaaa): ");
                    objetoProj.setPrazoEntregaProjeto(leia.nextLine());
                    listaProj.remove(index);
                    listaProj.add(objetoProj);
                    System.out.print("\n\nEdição do projeto realizada.");
                    break;
                } else if(opc != 1 && opc != 2) {
                    System.out.print("\nOpção inválida.");
                } else {
                    break;
                }

            } catch (InputMismatchException exCaractereInvalido) {
                System.out.print("\nCaractere inválido.");
                continue;
            }
        }
    }

    @Override
    public void apagarProjeto(List<Projeto> listProj) {

        while(true) {
            try {
                int index, resposta;
                System.out.print("\nDigite a posição do projeto que deseja excluir: ");
                index = leia.nextInt();
                System.out.print(
                    "\n------------- Dados do Projeto -------------"+
                    "\nNome: "+listProj.get(index).getNomeProjeto()+
                    "\nDescrição: "+listProj.get(index).getDescricaoProjeto()+
                    "\nPrazo de entrega: "+listProj.get(index).getPrazoEntregaProjeto()
                );
                System.out.println("\nEste é o projeto que deseja excluir?");
				System.out.println("\nDigite 1 para SIM\nDigite 2 para NÃO");
                resposta = leia.nextInt();
                if(resposta == 1) {
                    listProj.remove(index);
                    System.out.print("\n\nProjeto excluido.");
                    break;
                } else if(resposta == 2) {
                    System.out.print("\n\nO projeto não será excluido");
                    break;
                } else if(resposta != 1 && resposta != 2){
                    System.out.println("\nOpção inválida.");
                    break;
                }
                
            } catch(InputMismatchException exc) {
                System.out.print("\nCaracter inválido.");
                continue;
            }
        }
    }



    public String getNomeProjeto() {
        return this.nomeProjeto;
    }

    public void setNomeProjeto(String nomeProjeto) {
        this.nomeProjeto = nomeProjeto;
    }

    public String getDescricaoProjeto() {
        return this.descricaoProjeto;
    }

    public void setDescricaoProjeto(String descricaoProjeto) {
        this.descricaoProjeto = descricaoProjeto;
    }

    public String getPrazoEntregaProjeto() {
        return this.prazoEntregaProjeto;
    }

    public void setPrazoEntregaProjeto(String prazoEntregaProjeto) {
        this.prazoEntregaProjeto = prazoEntregaProjeto;
    }

}