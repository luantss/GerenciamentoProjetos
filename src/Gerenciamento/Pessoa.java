package Gerenciamento;

public abstract class Pessoa {
	
	//atributos 
	protected String nome; 
	protected String cpf;
	protected String email;
	protected String equipe;
	
	//construtor 
	public Pessoa(String nome, String cpf, String email, String equipe) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.equipe = equipe; 
	}
	
	//construtor vazio 
	public Pessoa() {
		this.nome = null;
		this.cpf = null;
		this.email = null;
		this.equipe = null;
	}
	
	//get e set
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	} 
	
	//metodo 
	public abstract void imprimeDados();
}
