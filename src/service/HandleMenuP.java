package service;

import java.util.Scanner;
import models.Produto;
import utils.GerenciadorDeProdutos;

public class HandleMenuP {

	// PRODUTOS

	Scanner sc = new Scanner(System.in);
	// Gerenciador
	GerenciadorDeProdutos gp = new GerenciadorDeProdutos();

	public HandleMenuP() {
		// tida vez qye a classe menu, for instanciada, o nosso arquivo sera verificado
		gp.verificaECria("produtos.txt");
	}

	public void criarP() {
		System.out.println("Digite o id do produto");
		long idP = sc.nextLong();
		System.out.println("Qual o nome do Produto:");
		String nome = sc.next();
		System.out.println("Digite seu preço:");
		double preco = sc.nextDouble();

		System.out.println("Digite a quantidade deste Produto");
		int quantidade = sc.nextInt();

		Produto p = new Produto(idP, nome, preco, quantidade);
		gp.adicionarProduto(p);
	}

	public void editarProduto() {
		System.out.println("Digite o ID do produto:");
		long id = sc.nextLong();
		System.out.println("Digite o novo nome:");
		String nome = sc.next();
		System.out.println("Digite o novo preco:");
		double preco = sc.nextDouble();
		System.out.println("digite a nova quantidade:");
		int quantidade = sc.nextInt();

	}

	public void deletaProduto() {
		System.out.println("Digite o ID do produto:");
		long idP = sc.nextLong();
		gp.deletarProduto(idP);
	}

	public void listarProdutos() {
		gp.listarProdutos();
	}

	public void produtoUnico() {
		System.out.println("Digite o ID do Produto");
		long idP = sc.nextLong();
		gp.produtoUnico(idP);
	}

	public void custoTotal() {

	}
	public void totalProduto() {
		
	}
}
