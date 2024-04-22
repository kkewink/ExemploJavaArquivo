package models;

public class Produto {
	// id = 
	private long idP;
	private String nome;
	private double preco;
	private int quantidade;
	
	
	public Produto(long idP, String nome, double preco, int quantidade) {
		super();
		this.idP = idP;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
	}
	public long getIdP() {
		return idP;
	}
	public void setId(int id) {
		this.idP = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return idP + ";" + nome  + ";" + preco + ";" + quantidade;
	}

}
