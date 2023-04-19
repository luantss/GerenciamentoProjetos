package Gerenciamento;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Opcao {

	Scanner leia = new Scanner(System.in);

	public void OpcaoCadastrar(List<Gerente> listGerente, List<Funcionario> listFuncionario, List<Tarefa> listTarefa,
			List<Projeto> listProjeto) {
		int opcao;
		while (true) {
			System.out.println("\n\n------------- Cadastro -------------");
			System.out.print("\n1- Cadastrar novo Gerente" +
					"\n2- Cadastrar novo Funcionário" +
					"\n3- Cadastrar novo Projeto" +
					"\n4- Cadastrar nova Tarefa" +
					"\n0 - Voltar\n" +
					"\n\nDigite a opção desejada: ");
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("\nCaracter inválido.");
				leia.nextLine();
				continue;
			}

			if (opcao == 0) {
				break;
			} else {
				switch (opcao) {
					case 1:
						Gerente objetoGerente = new Gerente();
						objetoGerente.criarGerente(listGerente);
						break;
					case 2:
						Funcionario objetoFuncionario = new Funcionario();
						objetoFuncionario.criarFuncionario(listFuncionario);
						break;
					case 3:
						Projeto objetoProjeto = new Projeto();
						objetoProjeto.criarProjeto(listProjeto);
						break;
					case 4:
						Tarefa objetoTarefa = new Tarefa();
						objetoTarefa.criarTarefa(listTarefa);
						break;
					default:
						System.out.println("\nOpção inválida.");

				}
			}
		}

	}

	public void OpcaoImprimir(List<Gerente> listGerente, List<Funcionario> listFuncionario) {

		int opcao;
		while (true) {
			System.out.println("\n\n------------- Impressão de Dados -------------");
			System.out.print("\n1- Imprimir dados de um Gerente" +
					"\n2- Imprimir dados de um Funcionário" +
					"\n0- Voltar\n" +
					"\n\nDigite a opção desejada: ");
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("\nCaracter inválido.");
				leia.nextLine();
				continue;
			}

			if (opcao == 0) {
				break;
			} else {
				switch (opcao) {
					case 1:
						Gerente objetoGerente = new Gerente();
						objetoGerente.imprimeDadosGerente(listGerente);
						break;
					case 2:
						Funcionario objetoFuncionario = new Funcionario();
						objetoFuncionario.imprimeDadosFuncionario(listFuncionario);
						break;
					default:
						System.out.println("Opção inválida.");
				}
			}
		}
	}

	public void OpcaoListar(List<Gerente> listGerente, List<Funcionario> listFuncionario, List<Tarefa> listTarefa,
			List<Projeto> listProjeto) {

		int opcao;
		while (true) {
			System.out.println("\n\n------------- Listar -------------");
			System.out.print("\n1- Listar Gerente(s)" +
					"\n2- Listar Funcionário(s)" +
					"\n3- Listar Projeto(s)" +
					"\n4- Listar Tarefa(s)" +
					"\n0- Voltar\n" +
					"\n\nDigite a opção desejada: ");
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("\nCaracter inválido.");
				leia.nextLine();
				continue;
			}

			if (opcao == 0) {
				break;
			} else {
				switch (opcao) {
					case 1:
						Gerente objetoGerente = new Gerente();
						objetoGerente.listarGerente(listGerente);
						break;
					case 2:
						Funcionario objetoFuncionario = new Funcionario();
						objetoFuncionario.listarFuncionario(listFuncionario);
						break;
					case 3:
						Projeto objetoProjeto = new Projeto();
						objetoProjeto.listarProjeto(listProjeto);
						break;
					case 4:
						Tarefa objetoTarefa = new Tarefa();
						objetoTarefa.listarTarefa(listTarefa);
						break;
					default:
						System.out.print("\nOpção inválida!");
				}
			}
		}
	}

	public void OpcaoExcluir(List<Gerente> listGerente, List<Funcionario> listFuncionario, List<Tarefa> listTarefa,
			List<Projeto> listProjeto) {

		int opcao;
		while (true) {
			System.out.println("\n\n------------- Excluir -------------");
			System.out.print("\n1- Excluir Gerente" +
					"\n2- Excluir Funcionário" +
					"\n3- Excluir Projeto" +
					"\n4- Excluir Tarefa" +
					"\n0- Voltar\n" +
					"\n\nDigite a opção desejada: ");
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("\nCaracter inválido.");
				leia.nextLine();
				continue;
			}

			if (opcao == 0) {
				break;
			} else {
				switch (opcao) {
					case 1:
						Gerente objetoGerente = new Gerente();
						objetoGerente.apagarGerente(listGerente);
						break;
					case 2:
						Funcionario objetoFuncionario = new Funcionario();
						objetoFuncionario.apagarFuncionario(listFuncionario);
						break;
					case 3:
						Projeto objetoProjeto = new Projeto();
						objetoProjeto.apagarProjeto(listProjeto);
						break;
					case 4:
						Tarefa objetoTarefa = new Tarefa();
						objetoTarefa.apagarTarefa(listTarefa);
						break;
					default:
						System.out.print("\nOpção inválida.");
				}
			}
		}
	}

	public void OpcaoAlterar(List<Gerente> listGerente, List<Funcionario> listFuncionario, List<Tarefa> listTarefa,
			List<Projeto> listProjeto) {

		int opcao;
		while (true) {
			System.out.println("\n\n------------- Alterar Dados -------------");
			System.out.print("\n1- Alterar dados de um Gerente" +
					"\n2- Alterar dados de um Funcionário" +
					"\n3- Alterar dados de um Projeto" +
					"\n4- Alterar dados de uma Tarefa" +
					"\n0- Voltar\n" +
					"\n\nDigite a opção desejada: ");
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Caractere inválido.");
				leia.nextLine();
				continue;
			}

			if (opcao == 0) {
				break;
			} else {
				switch (opcao) {
					case 1:
						Gerente objetoGerente = new Gerente();
						objetoGerente.editarGerente(listGerente);
						break;
					case 2:
						Funcionario objetoFuncionario = new Funcionario();
						objetoFuncionario.editarFuncionario(listFuncionario);
						break;
					case 3:
						Projeto objetoProjeto = new Projeto();
						objetoProjeto.editarProjeto(listProjeto);
						break;
					case 4:
						Tarefa objetoTarefa = new Tarefa();
						objetoTarefa.editarTarefa(listTarefa);
						break;
					default:
						System.out.print("\nOpção inválida.");
				}
			}
		}
	}

	public void OpcaoRelacionar(List<Projeto> listProjeto, List<Tarefa> listTarefa, List<Gerente> listGerente, List<Funcionario> listFuncionario) {

		int opcao;
		while (true) {
			System.out.println("\n\n------------- Relacionar -------------");
			System.out.print("\n1- Relacionar Tarefa ao Projeto" +
					"\n2- Relacionar Gerente ao Projeto" +
					"\n3- Relacionar Funcionario a Tarefa" +
					"\n0- Voltar\n" +
					"\n\nDigite a opção desejada: ");
			try {
				opcao = leia.nextInt();
			} catch (InputMismatchException exception) {
				System.out.println("Caractere inválido.");
				leia.nextLine();
				continue;
			}

			if (opcao == 0) {
				break;
			} else {
				switch (opcao) {
					case 1:
						Tarefa objetoTarefa = new Tarefa();
						objetoTarefa.relacionarTarefaProjeto(listTarefa, listProjeto);
						break;
					case 2:
						Gerente objetoGerente = new Gerente();
						objetoGerente.relacionarGerenteProjeto(listGerente, listProjeto);
						break;
					case 3:
						Funcionario objetoFuncionario = new Funcionario();
						objetoFuncionario.relacionarFuncionarioTarefa(listFuncionario, listTarefa);
						break;
					default:
						System.out.print("\nOpção inválida.");
				}
			}
		}
	}
}
