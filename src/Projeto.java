

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Projeto implements ProjetosInterface{
   
    private String nomeProjeto;
    private String descricaoProjeto;
    private String prazoEntregaProjeto;

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
                Scanner leia = new Scanner(System.in);
                System.out.print("\nDigite o nome do projeto: ");
                objetoProj.setNomeProjeto(leia.nextLine());
                System.out.print("\nDigite a descrição do projeto: ");
                objetoProj.setDescricaoProjeto(leia.nextLine());
                System.out.print("\nDigite o prazo de entrega do projeto(dd/mm/aaaa): ");
                objetoProj.setPrazoEntregaProjeto(leia.nextLine());
                listProj.add(objetoProj);
                System.out.print("\nProjeto criado com sucesso!");
                leia.close();
                break;

            } catch (InputMismatchException exCaractereInvalido) {
                System.out.print("Caractere inválido, digite um texto.");
                continue;
            }
        }
    }

    @Override
    public void listarProjeto(List<Projeto> listProj) {
        int contador = 0;
        for(Projeto in : listProj) {
            System.out.print(
                "\n======================================"+
                "\nPosição: "+contador+
                "\nNome do Projeto: "+in.getNomeProjeto()+
                "\nDescrição do Projeto: "+in.getDescricaoProjeto()+
                "\nPrazo de entrega do Projeto: "+in.getPrazoEntregaProjeto()+
                "\n======================================");
            contador++;
        }
    }

    @Override
    public void editarProjeto(List<Projeto> listaProj) {
        while(true) {
            try {
                Scanner leia = new Scanner(System.in);
                int index, opc;
                System.out.print("\nQual é a posição do projeto que você deseja editar? ");
                index = leia.nextInt();
                System.out.print(
                    "\n======================================"+
                    "\nNome do Projeto: "+listaProj.get(index).getNomeProjeto()+
                    "\nDescrição do Projeto: "+listaProj.get(index).getDescricaoProjeto()+
                    "\nPrazo de entrega do Projeto: "+listaProj.get(index).getPrazoEntregaProjeto()+
                    "\n======================================"+
                    "\nEste é o projeto que você deseja alterar?"+
                    "\n(1)- Sim \n(2)- Não"+
                    "\nDigite a opção: ");
                opc = leia.nextInt();
                if(opc == 1) {
                    Projeto objetoProj = new Projeto();
                    System.out.print("\nDigite o nome do projeto: ");
                    objetoProj.setNomeProjeto(leia.nextLine());
                    System.out.print("\nDigite a descrição do projeto: ");
                    objetoProj.setDescricaoProjeto(leia.nextLine());
                    System.out.print("\nDigite o prazo de entrega do projeto(dd/mm/aaaa): ");
                    objetoProj.setPrazoEntregaProjeto(leia.nextLine());
                    listaProj.add(objetoProj);
                    break;
                } else if(opc != 1 && opc != 2) {
                    System.out.print("\nOpção inválida!");
                } else {
                    break;
                }

            } catch (InputMismatchException exCaractereInvalido) {
                System.out.print("Caractere inválido, digite um texto.");
                continue;
            }
        }
    }

    @Override
    public void apagarProjeto(List<Projeto> listProj) {

        while(true) {
            try {
                Scanner leia = new Scanner(System.in);
                int index, resposta;
                System.out.print("\nDigite a posição do projeto que deseja excluir: ");
                index = leia.nextInt();
                System.out.print(
                    "\n======================================"+
                    "\nNome do Projeto: "+listProj.get(index).getNomeProjeto()+
                    "\nDescrição do Projeto: "+listProj.get(index).getDescricaoProjeto()+
                    "\nPrazo de entrega do Projeto: "+listProj.get(index).getPrazoEntregaProjeto()+
                    "\n======================================"+
                    "\n\nTem certeza que deseja excluir esse projeto?"+
                    "\n(1)-Sim\n(2)-Não\n"
                );
                resposta = leia.nextInt();
                if(resposta == 1) {
                    listProj.remove(resposta);
                    System.out.print("\nProjeto excluido com sucesso!");
                    break;
                } else if(resposta == 2) {
                    System.out.print("\nO projeto não será excluido");
                    break;
                } else if(resposta != 1 && resposta != 2){
                    System.out.println("\nOpção inválida!");
                    break;
                }
                
            } catch(InputMismatchException exc) {
                System.out.print("\nCaracter inválido!");
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
