package service;

import java.util.List;
import java.util.Scanner;
import models.Produto;
import models.Usuario;
import utils.GerenciadorDeProdutos;

public class HandleMenuP {

	// PRODUTOS

	Scanner sc = new Scanner(System.in);
	// Gerenciador
	GerenciadorDeProdutos gp = new GerenciadorDeProdutos();

	public long getNextId() {
		List<Produto> produtos = gp.lerProduto();
		long maxIdp = 0;
		// for => foreach
		// Unico usuario : Lista com todos
		for (Produto produto : produtos) {
			long id = produto.getIdP();
			// 1
			if (id > maxIdp) {
				maxIdp = id;
				// 10
			}
		}
		// soma 1 + o ultimo
		return maxIdp + 1;
	}

	public HandleMenuP() {
		// tida vez qye a classe menu, for instanciada, o nosso arquivo sera verificado
		gp.verificaECria("produtos.txt");
	}

	public void criarP() {

		long idP = 0;
		String nome = "";
		double preco = 0;
		int quantidade = 0;

		boolean nomeE = false;
		while (nomeE == false) {
			System.out.println("Qual o nome do Produto:");
			try {
				nome = sc.nextLine();
				if (nome.length() == 0) {
					System.err.println("NÂO DEIXE ESPAÇO EM BRANCO");

				}
				if (nome.length() < 3) {
					System.err.println("MINIMO DE CARACTERES = 3");

				} else {

					nomeE = true;
				}

			} catch (Exception e) {
			}
		}
		boolean precoE = false;
		while (precoE == false) {
			System.out.println("Digite seu preço:");
			try {
				preco = sc.nextDouble();
				if (preco < 0) {
					System.err.println("DIGITE UM VALOR POSITIVO");

				} else {
					precoE = true;
				}
			} catch (Exception e) {
				System.err.println("DIGITE APENAS NUMEROS");
			}
		}

		boolean quantidadeE = false;
		while (quantidadeE == false) {
			System.out.println("Digite a quantidade deste Produto");
			try {
				quantidade = sc.nextInt();
				if (quantidade < 0) {
					System.err.println("DIGITE UM VALOR POSITIVO");
				} else {
					quantidadeE = true;
				}
			} catch (Exception e) {
				System.err.println("DIGITE APENAS NUMEROS");
			}
			sc.nextLine();
		}

		idP = getNextId();
		Produto p = new Produto(idP, nome, preco, quantidade);
		gp.adicionarProduto(p);
	}

	public void editarProduto() {
		long idP = 0;
		String nome = "";
		double preco = 0;
		int quantidade = 0;

		System.out.println("Digite o ID do produto:");
		idP = sc.nextLong();

		boolean nomeE = false;
		while (nomeE == false) {
			System.out.println("Digite o novo nome:");
			try {
				nome = sc.nextLine();
				if (nome.length() == 0) {
					System.err.println("NÂO DEIXE ESPAÇO EM BRANCO");

				}
				if (nome.length() < 3) {
					System.err.println("MINIMO DE CARACTERES = 3");

				} else {

					nomeE = true;
				}

			} catch (Exception e) {
			}
		}

		boolean precoE = false;
		while (precoE == false) {
			System.out.println("Digite o novo preco:");
			try {
				preco = sc.nextDouble();
				if (preco < 0) {
					System.err.println("DIGITE UM VALOR POSITIVO");

				} else {
					precoE = true;
				}
			} catch (Exception e) {
				System.err.println("DIGITE APENAS NUMEROS");
			}
		}

		boolean quantidadeE = false;
		while (quantidadeE == false) {
			System.out.println("Digite a nova quantidade:");
			try {
				quantidade = sc.nextInt();
				if (quantidade < 0) {
					System.err.println("DIGITE UM VALOR POSITIVO");
				} else {
					quantidadeE = true;
				}
			} catch (Exception e) {
				System.err.println("DIGITE APENAS NUMEROS");
			}
			sc.nextLine();
		}

		gp.editarProduto(idP, nome, preco, quantidade);

	}

	public void deletaProduto() {
		long idP = 0;

		boolean idpE = false;
		while (idpE == false) {
			System.out.println("Digite o ID do produto:");
			try {
				idP = sc.nextLong();
				if (idP < 0) {
					System.err.println("DIGITE UM VALOR POSITIVO");

				} else {
					idpE = true;
				}
			} catch (Exception e) {
				System.err.println("DIGITE APENAS NUMEROS");
			}
		}

		gp.deletarProduto(idP);
	}

	public void listarProdutos() {
		gp.listarProdutos();
	}

	public void produtoUnico() {
		long idP = sc.nextLong();

		boolean idpE = false;
		while (idpE == false) {
			System.out.println("Digite o ID do Produto:");
			try {
				idP = sc.nextLong();
				if (idP < 0) {
					System.err.println("DIGITE UM VALOR POSITIVO");

				} else {
					idpE = true;
				}
			} catch (Exception e) {
				System.err.println("DIGITE APENAS NUMEROS");
			}
		}

		gp.produtoUnico(idP);
	}

	public void custoTotal() {
		System.out.println("Custo Total Dos Produtos");
		gp.custoTotal();
	}

	public void totalProduto() {
		System.out.println("Total Dos Produtos");
		gp.totalProduto();
	}
}
