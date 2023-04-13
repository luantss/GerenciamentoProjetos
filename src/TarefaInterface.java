import java.util.List;

public interface TarefaInterface {
    
    public void criarTarefa(List<Tarefa> listTarefa);
    public void listarTarefa(List<Tarefa> listTarefa);
    public void editarTarefa(List<Tarefa> listTarefa);
    public void apagarTarefa(List<Tarefa> listTarefa);
}
