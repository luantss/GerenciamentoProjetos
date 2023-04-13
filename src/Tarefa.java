import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Tarefa implements TarefaInterface{
    
    private String nomeTarefa;
    private String descricaoTarefa;
    private String prazoTarefa;
    private String status;

    public Tarefa(String nomeTarefa, String descricaoTarefa, String prazoTarefa, String status) {
        this.nomeTarefa = nomeTarefa;
        this.descricaoTarefa = descricaoTarefa;
        this.prazoTarefa = prazoTarefa;
        this.status = status;
    }

    public Tarefa() {
        this.nomeTarefa = null;
        this.descricaoTarefa = null;
        this.prazoTarefa = null;
        this.status = null;
    }

    @Override
    public void criarTarefa(List<Tarefa> listTarefa) {
        while(true) {
            try {
                Tarefa objetoTare = new Tarefa();
                Scanner leia = new Scanner(System.in);
                System.out.print("\nDigite o nome da tarefa: ");
                objetoTare.setNomeTarefa(leia.nextLine());
                System.out.print("\nDigite a descrição da tarefa: ");
                objetoTare.setDescricaoTarefa(leia.nextLine());
                System.out.print("\nDigite o prazo da tarefa: ");
                objetoTare.setPrazoTarefa(leia.nextLine());
                objetoTare.setStatus("Ativo");
                listTarefa.add(objetoTare);
                System.out.print("\nTarefa criada com sucesso!");
                break;
            } catch(InputMismatchException exp) {
                System.out.print("Caracter inválido, digite um texto!");
                continue;
            }
        }
    }

    @Override
    public void listarTarefa(List<Tarefa> listTarefa) {
        int contador = 0;
        for(Tarefa in : listTarefa) {
            System.out.print(
                "\n======================================"+
                "\nPosição: "+contador+
                "\nNome da Tarefa: "+in.getNomeTarefa()+
                "\nDescrição da Tarefa: "+in.getDescricaoTarefa()+
                "\nPrazo da tarefa: "+in.getPrazoTarefa()+
                "\n======================================"
            );
            contador++;
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

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
