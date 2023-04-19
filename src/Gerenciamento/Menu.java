package Gerenciamento;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {
		
		List<Gerente> listGerente = new ArrayList<Gerente>();
		List<Funcionario> listFuncionario = new ArrayList<Funcionario>();
		List<Tarefa> listTarefa = new ArrayList<Tarefa>();
		List<Projeto> listProjeto = new ArrayList<Projeto>();
		Opcao op = new Opcao();
		int resposta;
		Scanner leia = new Scanner(System.in);
		
		while(true) {
			System.out.print("\n---------- Menu de Gerenciamento de Projetos ----------");
			System.out.print("\n1 - Cadastrar" +
			"\n2 - Listar funcionários/gerentes/tarefas/projetos" + 
			"\n3 - Imprimir dados de um funcionário/gerente" +
			"\n4 - Alterar informções" +
			"\n5 - Excluir" + 
			"\n6 - Relacionar" +
			"\n0 - Sair do Programa" +
			"\n\nDigite sua opção: ");
			
			try {
				resposta = leia.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Carcter iválido.");
				leia.nextLine();
				continue;
			}
			
			if(resposta == 0) {
				System.out.println("Programa finalizado.");
				break;
			} else {
				switch (resposta) {
					case 1:
						op.OpcaoCadastrar(listGerente, listFuncionario, listTarefa, listProjeto);
						break;
					case 2:
						op.OpcaoListar(listGerente, listFuncionario, listTarefa, listProjeto);
						break;
					case 3:
						op.OpcaoImprimir(listGerente, listFuncionario);
						break;
					case 4:
						op.OpcaoAlterar(listGerente, listFuncionario, listTarefa, listProjeto);
						break;
					case 5:
						op.OpcaoExcluir(listGerente, listFuncionario, listTarefa, listProjeto);
						break;
					case 6:
						op.OpcaoRelacionar(listProjeto, listTarefa, listGerente, listFuncionario);
						break;
					default:
						System.out.print("\nOpção inválida!");	
				}
			}
		}
	}

}
