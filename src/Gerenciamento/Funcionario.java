package Gerenciamento;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Funcionario extends Pessoa {
	
	Scanner leia = new Scanner (System.in);
	
	private String funcaoProjeto; 
	private Tarefa tarefa;
	
	//construtor
	public Funcionario (String nome, String cpf, String email, String equipe, String funcaoProjeto) {
		super(nome, cpf, email, equipe);
		this.funcaoProjeto = funcaoProjeto;
	}
	
	//construtor vazio
	public Funcionario() {
		super();
		this.funcaoProjeto = null; 
	}
	
	//get e set
	public String getFuncaoProjeto() {
		return funcaoProjeto;
	}

	public void setFuncaoProjeto(String funcaoProjeto) {
		this.funcaoProjeto = funcaoProjeto;
	}

	public Tarefa getTarefa() {
		return this.tarefa;
	}

	public void setTarefa(Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	//Método para criação de um funcionário
	public void criarFuncionario(List<Funcionario> listaFunc) {
		
		while(true) {
			try {
				Funcionario objeto = new Funcionario();
				System.out.print("\nDigite o nome do Funcionário: ");
				objeto.setNome(leia.nextLine());
				System.out.print("\nDigite o CPF do Funcionário: ");
				objeto.setCpf(leia.nextLine());
				System.out.print("\nDigite o E-mail do Funcionário: ");
				objeto.setEmail(leia.nextLine());
				System.out.print("\nDigite a equipe que o Funcionário pertence: ");
				objeto.setEquipe(leia.nextLine());
				System.out.print("\nDigite a função do Funcionário: ");
				objeto.setFuncaoProjeto(leia.nextLine());
				listaFunc.add(objeto);
				System.out.println("\n\nCadastro do funcionário realizado.");
				break;
				
			} catch (InputMismatchException exception) {
				System.out.println("\nCaractere inválido.");
				leia.nextLine();
				continue;
			}
		}
		
	}
	
	//Método para editar funcionário
	public void editarFuncionario(List<Funcionario> listaFunc) {
		
		while(true) {
			try {
				int index, resposta;
				System.out.println("Insira a posição do funcionário que deseja editar informações: ");
				index = leia.nextInt();
				System.out.print("\n------------- Dados do Funcionário -------------" +
						"\nNome: " + listaFunc.get(index).getNome() + 
						"\nCPF: " + listaFunc.get(index).getCpf() +
						"\nEmail: " + listaFunc.get(index).getEmail() +
						"\nEquipe: " + listaFunc.get(index).getEquipe() +
						"\nFunção: " + listaFunc.get(index).getFuncaoProjeto()
				);
				System.out.println("\nEste é o funcionário que deseja alterar?");
				System.out.println("\nDigite 1 para SIM\nDigite 2 para NÃO");
				resposta = leia.nextInt();
                leia.nextLine();
				if(resposta == 1) {
					Funcionario objeto = new Funcionario();
					System.out.print("\nDigite o nome do Funcionário: ");
					objeto.setNome(leia.nextLine());
					System.out.print("\nDigite o CPF do Funcionário: ");
					objeto.setCpf(leia.nextLine());
					System.out.print("\nDigite o E-mail do Funcionário: ");
					objeto.setEmail(leia.nextLine());
					System.out.print("\nDigite a equipe que o Funcionário pertence: ");
					objeto.setEquipe(leia.nextLine());
					System.out.print("\nDigite a função do Funcionário: ");
					objeto.setFuncaoProjeto(leia.nextLine());
					listaFunc.remove(index);
					listaFunc.add(objeto);
					System.out.println("\n\nEdição do funcionário realizada.");
					break;
				} else if(resposta != 1 && resposta != 2) {
						System.out.print("\nOpção inválida.");
				} else {
					break;
				}
				
			} catch (InputMismatchException exception) {
				System.out.println("\nCaractere inválido.");
				//leia.nextLine();
				continue;
			}
		}
	}
	
	//Método para listar os funcionários
	public void listarFuncionario(List<Funcionario> listaFunc) {
		
		int index = 0;
		for(Funcionario objeto : listaFunc) {
			if(objeto.getTarefa() == null) {
				System.out.print("\n------------ Funcionário " + index + " -------------" 
						+ "\nPosição do Funcionário: " + index +
						"\nNome:" + objeto.getNome() +
						"\nCPF: " + objeto.getCpf() +
						"\nFunção: " + objeto.getFuncaoProjeto() +
						"\n--------------------------------------------");
			} else {
				System.out.print("\n------------ Funcionário " + index + " -------------" 
						+ "\nPosição do Funcionário: " + index +
						"\nNome:" + objeto.getNome() +
						"\nCPF: " + objeto.getCpf() +
						"\nFunção: " + objeto.getFuncaoProjeto() +
						"\nTarefa do funcionário: " + objeto.getTarefa().getNomeTarefa()+
						"\n--------------------------------------------");
			}
			index++;
		}
	}
	
	//Método para apagar um funcionário
	public void apagarFuncionario(List<Funcionario> listaFunc) {
		while(true) {
			try {
				int index;
				int resposta;
				System.out.println("Insira a posição do funcionário que deseja apagar da lista de funcionários: ");
				index = leia.nextInt();
				listaFunc.get(index).imprimeDados();
				System.out.println("\n\nEste é o funcionário que deseja excluir?");
				System.out.println("\nDigite 1 para SIM\nDigite 2 para NÃO");
				resposta = leia.nextInt();
				if(resposta == 1) {
					listaFunc.remove(index);
					System.out.print("\n\nFuncionário excluído.");
					break;
				} else if(resposta == 2) {
					System.out.println("\n\nO funcionário não será excluído.");
					break;
				} else if(resposta != 1 && resposta != 2) {
					System.out.println("\nOpção inválida.");
					break;
				}
			} catch (InputMismatchException exception) {
				System.out.println("\nCaractere inválido.");
				//leia.nextLine();
				continue;
			}
		}
	}

	public void imprimeDadosFuncionario(List<Funcionario> listFunc) {
    
		while (true) {
			try {
				try {
					int index;
					System.out.print("\nDigite a posição que você deseja consultar: ");
					index = leia.nextInt();
					listFunc.get(index).imprimeDados();
					break;
				} catch (InputMismatchException exception) {
					System.out.println("\nCaractere inválido.");
					leia.nextLine();
					continue;
				}
			} catch (IndexOutOfBoundsException exc) {
				System.out.println("\nPosição inexistente!");
				continue;
			}
		}
	}
	
	//Método herdado da classe abstrata Pessoa
	@Override
	public void imprimeDados() {
		System.out.println("\n------------- Dados do Funcionário -------------" +
							"\nNome: " + this.getNome() +
							"\nCPF: " + this.getCpf() +
							"\nEmail: " + this.getEmail() +
							"\nEquipe: " + this.getEquipe() +
							"\nFunção no Projeto: " + this.getFuncaoProjeto());
	}

	public void relacionarFuncionarioTarefa(List<Funcionario> listFuncionario, List<Tarefa> listTarefa) {

        while (true) {
			try {
				try {
					Funcionario objetoFuncionario = new Funcionario();
					Tarefa objetoTarefa = new Tarefa();
					int indexFuncionario, indexTarefa;
		
					objetoFuncionario.listarFuncionario(listFuncionario);
					System.out.print("\nQual FUNCIONARIO deseja relacionar a uma tarefa? Digite a posição: ");
					indexFuncionario = leia.nextInt();
		
					objetoTarefa.listarTarefa(listTarefa);
					System.out.print("\nQual TAREFA deseja relacionar a esse funcionário? Digite a posição: ");
					indexTarefa = leia.nextInt();
					leia.nextLine();
		
					if (listTarefa.size() == 0) {
						System.out.print(
								"\nNão existe nenhuma tarefa cadastrado, logo não é possível relacionar o funcionário a tarefa!");
						break;
					} else {
						Funcionario funcionario = listFuncionario.get(indexFuncionario);
						Tarefa tarefa = listTarefa.get(indexTarefa);
						funcionario.setTarefa(tarefa);
						System.out.print("\nFuncionario " + funcionario.getNome() + " relacionado com sucesso a tarefa "
								+ tarefa.getNomeTarefa());
						break;
					}
					
				} catch (IndexOutOfBoundsException exc) {
					System.out.println("\nPosição inexistente!");
				}
			} catch (InputMismatchException exception) {
				System.out.println("\nCaractere inválido!");
				leia.nextLine();
				continue;
			}
        }
    }
		
}
