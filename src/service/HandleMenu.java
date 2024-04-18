package service;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import models.Produto;
import utils.GerenciadorDeUsuarios;
import utils.GerenciadorDeProdutos;

public class HandleMenu {

	Scanner sc = new Scanner(System.in);

	// Gerenciador
	GerenciadorDeUsuarios gs = new GerenciadorDeUsuarios();
	
	GerenciadorDeProdutos gp = new GerenciadorDeProdutos();

	public HandleMenu() {
		// tida vez qye a classe menu, for instanciada, o nosso arquivo sera verificado
		gs.verificaECria("usuarios.txt");
		gp.verificaECria("produtos.txt");
	}

	public void criar() {
		System.out.println("Digite o nome:");
		String nome = sc.next();
		System.out.println("Digite uma senha:");
		String senha = sc.next();

		int id = getNextId();
		Usuario u = new Usuario(id, nome, senha);
		gs.adicionarUsuario(u);
	}

	public void editar() {
		System.out.println("Digite o ID do usuario:");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome:");
		String nome = sc.next();
		System.out.println("Digite a nova senha:");
		String senha = sc.next();
		
		
	}

	public void deletar() {
		System.out.println("Digite o ID do usuario a ser deletado:");
		int id = sc.nextInt();
		gs.deletarUsuario(id);
	}

	public void listar() {
		gs.listarUsuarios();
	}

	public int getNextId() {
		List<Usuario> usuarios = gs.lerUsuarios();
		int maxId = 0;
		// for => foreach
		// Unico usuario : Lista com todos
		for (Usuario usuario : usuarios) {
			int id = usuario.getId();
			// 1
			if (id > maxId) {
				maxId = id;
				// 10
			}
		}
		// soma 1 + o ultimo
		return maxId + 1;
	}

	public void listaEspecifico() {
		System.out.println("Digite o ID do usuario Especifico");
		int id = sc.nextInt();
		gs.listarEspecifico(id);
		
	}
	
	public void login() {
		System.out.println("Digite seu login :");
		String nome = sc.next();
		System.out.println("Digite uma senha:");
		String senha = sc.next();
		
		gs.login( nome, senha);
			
	}
	
	//PRODUTOS
	
	public void criarP() {
		System.out.println("Qual o nome do Produto:");
		String nome = sc.next();
		System.out.println("Digite seu preço:");
		double preco = sc.nextDouble();
		
		System.out.println("Digite a quantidade deste Produto");
		int quantidade = sc.nextInt();
		
		System.out.println("Digite o id do produto");
		long idP = getNextId();
		
		Produto p = new Produto(idP,nome,preco,quantidade);
		gp.adicionarProduto(p);
	}
	
	public void editarProduto() {
		System.out.println("Digite o ID do produto:");
		long id = sc.nextInt();
		System.out.println("Digite o novo nome:");
		String nome = sc.next();
		System.out.println("Digite o novo preco:");
		double preco = sc.nextDouble();
		System.out.println("digite a nova quantidade:");
		int quantidade = sc.nextInt();
		
	}
	
	public void deletaProduto(){
		System.out.println("Digite o ID do produto:");
		long idP = sc.nextInt();
		gp.deletarProduto(idP);
	}
	
	public void listarProdutos() {
		gp.listarProdutos();
	}
	public void produtoUnico() {
		System.out.println("Digite o ID do Produto");
		long idP = sc.nextInt();
		gp.produtoUnico(idP);
	}
	
}
