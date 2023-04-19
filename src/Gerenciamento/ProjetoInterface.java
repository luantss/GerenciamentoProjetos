package Gerenciamento;

import java.util.List;

public interface ProjetoInterface {
	public void criarProjeto(List<Projeto> listProj);
    public void listarProjeto(List<Projeto> listProj);
    public void editarProjeto(List<Projeto> listProj);
    public void apagarProjeto(List<Projeto> listProj);
    //public void buscarProjetoPorId();
}
