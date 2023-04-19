package Gerenciamento;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Gerente extends Pessoa {
	Scanner leia = new Scanner (System.in);
	
	private String idAcesso; 
	private Projeto projeto;

	//construtor
	public Gerente (String nome, String cpf, String email, String equipe, String idAcesso) {
		super(nome, cpf, email, equipe);
		this.idAcesso = idAcesso;
	}
	
	//construtor vazio
	public Gerente() {
		super();
		this.idAcesso = null; 
	}
	
	//get e set
	public String getIdAcesso() {
		return idAcesso;
	}
	
	public void setIdAcesso(String idAcesso) {
		this.idAcesso = idAcesso;
	}

	public Projeto getProjeto() {
		return this.projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}
	
	//Método para criação de um gerente
	public void criarGerente(List<Gerente> listGerente) {
		
		while(true) {
			try {
				Gerente objeto = new Gerente();
				System.out.print("\nDigite o nome do Gerente: ");
				objeto.setNome(leia.nextLine());
				System.out.print("\nDigite o CPF do Gerente: ");
				objeto.setCpf(leia.nextLine());
				System.out.print("\nDigite o E-mail do Gerente: ");
				objeto.setEmail(leia.nextLine());
				System.out.print("\nDigite a equipe que o Gerente pertence: ");
				objeto.setEquipe(leia.nextLine());
				System.out.print("\nDigite o ID de acesso do Gerente: ");
				objeto.setIdAcesso(leia.nextLine());
				listGerente.add(objeto);
				System.out.println("\n\nCadastro do Gerente realizado.");
				break;
				
			} catch (InputMismatchException exception) {
				System.out.println("\nCaractere inválido.");
				leia.nextLine();
				continue;
			}
		}
		
	}
	
	//Método para editar gerente
	public void editarGerente(List<Gerente> listGerente) {
		
		while(true) {
			try {
				int index, resposta;
				System.out.println("Insira a posição do gerente que deseja editar informações: ");
				index = leia.nextInt();
				System.out.print("\nDados do Funcionário " +
						"\nNome: " + listGerente.get(index).getNome() + 
						"\nCPF: " + listGerente.get(index).getCpf() +
						"\nEmail: " + listGerente.get(index).getEmail() +
						"\nEquipe: " + listGerente.get(index).getEquipe() +
						"\nID de Acesso: " + listGerente.get(index).getIdAcesso()
				);
				System.out.println("\nEste é o gerente que deseja alterar?");
				System.out.println("\nDigite 1 para SIM\nDigite 2 para NÃO");
				resposta = leia.nextInt();
                leia.nextLine();
				if(resposta == 1) {
					Gerente objeto = new Gerente();
					System.out.print("\nDigite o nome do Gerente: ");
					objeto.setNome(leia.nextLine());
					System.out.print("\nDigite o CPF do Gerente: ");
					objeto.setCpf(leia.nextLine());
					System.out.print("\nDigite o E-mail do Gerente: ");
					objeto.setEmail(leia.nextLine());
					System.out.print("\nDigite a equipe que o Geente pertence: ");
					objeto.setEquipe(leia.nextLine());
					System.out.print("\nDigite o ID de acesso do Gerente: ");
					objeto.setIdAcesso(leia.nextLine());
					listGerente.remove(index);
					listGerente.add(objeto);
					System.out.println("\n\nEdição do gerente realizada.");
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
	
	//Método para listar os gerentes
	public void listarGerente(List<Gerente> listGerente) {
		
		int index = 0;
		for(Gerente objeto : listGerente) {
			if(objeto.getProjeto() == null) {
				System.out.print("\n------------ Gerente " + index + " -------------" +
						"\nPosição do Gerente: " + index +
						"\nNome:" + objeto.getNome() +
						"\nCPF: " + objeto.getCpf() +
						"\nID de Acesso: " + objeto.getIdAcesso() +
						"\n--------------------------------------------");
			} else {
				System.out.print("\n------------ Gerente " + index + " -------------" +
						"\nPosição do Gerente: " + index +
						"\nNome:" + objeto.getNome() +
						"\nCPF: " + objeto.getCpf() +
						"\nID de Acesso: " + objeto.getIdAcesso() +
						"\nProjeto do Gerente: " + objeto.getProjeto().getNomeProjeto()+
						"\n--------------------------------------------");
			}
			index++;
		}
	}
	
	//Método para apagar um gerente
	public void apagarGerente(List<Gerente> listGerente) {
		while(true) {
			try {
				int index;
				int resposta;
				System.out.println("Insira a posição do gerente que deseja apagar da lista de gerentes: ");
				index = leia.nextInt();
				listGerente.get(index).imprimeDados();
				System.out.println("\nEste é o gerente que deseja excluir?");
				System.out.println("\nDigite 1 para SIM\nDigite 2 para NÃO");
				resposta = leia.nextInt();
				if(resposta == 1) {
					listGerente.remove(index);
					System.out.print("\n\nGerente excluído.");
					break;
				} else if(resposta == 2) {
					System.out.print("\n\nO gerente não será excluído.");
					break;
				} else if(resposta != 1 && resposta != 2) {
						System.out.println("\nOpção inválida.");
						break;
					}
				} catch (InputMismatchException exception) {
				System.out.println("\nCaractere inválido.");
				continue;
			}
		}
	}

	public void imprimeDadosGerente(List<Gerente> listGerente) {
    
		while (true) {
			try {
				try {
					int index;
					System.out.print("\nDigite a posição que você deseja consultar: ");
					index = leia.nextInt();
					listGerente.get(index).imprimeDados();
					break;
				} catch (InputMismatchException exception) {
					System.out.println("\nCaractere inválido!");
					leia.nextLine();
					continue;
				}
			} catch (IndexOutOfBoundsException exc) {
				System.out.println("Posição inexistente!");
				continue;
			}
		}
	}
	
	
	//Método herdado da classe abstrata Pessoa
	@Override
	public void imprimeDados() {
		System.out.println("\n------------- Dados do Gerente -------------" +
							"\nNome: " + this.getNome() +
							"\nCPF: " + this.getCpf() +
							"\nEmail: " + this.getEmail() +
							"\nEquipe: " + this.getEquipe() +
							"\nID de Acesso: " + this.getIdAcesso());
	}

	public void relacionarGerenteProjeto(List<Gerente> listGerente, List<Projeto> listProjeto) {

        while (true) {
			try {
				try {
					Gerente objetoGerente = new Gerente();
					Projeto objetoProj = new Projeto();
					int indexGerente, indexProjeto;
		
					objetoGerente.listarGerente(listGerente);
					System.out.print("\nQual GERENTE deseja relacionar a um projeto? Digite a posição: ");
					indexGerente = leia.nextInt();
		
					objetoProj.listarProjeto(listProjeto);
					System.out.print("\nQual PROJETO deseja relacionar a essa gerente? Digite a posição: ");
					indexProjeto = leia.nextInt();
					leia.nextLine();
		
					if (listProjeto.size() == 0) {
						System.out.print(
								"\nNão existe nenhum projeto cadastrado, logo não é possível relacionar o gerente ao projeto!");
						break;
					} else {
						Gerente gerente = listGerente.get(indexGerente);
						Projeto projeto = listProjeto.get(indexProjeto);
						gerente.setProjeto(projeto);
						System.out.print("\nGerente " + gerente.getNome() + " relacionada com sucesso ao projeto "
								+ projeto.getNomeProjeto());
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
